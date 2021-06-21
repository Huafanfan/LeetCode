package easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch0401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i=0; i<12; i++){
            for (int j=0; j<60; j++){
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn){
                    res.add(i + ":" + (j > 9 ? j : "0" + j));
                }
            }
        }
        return res;
    }

    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i=0; i<1024; i++){
            int h = i >> 6;
            int l = i & 63;
            if (h < 12 && l < 60 && Integer.bitCount(i) == turnedOn){
                res.add(h + ":" + (l > 9 ? l : "0" + l));
            }
        }
        return res;
    }

    // 直接把二进制的问题转换为数组累加问题
    int[] hours = new int[]{1,2,4,8,0,0,0,0,0,0};
    int[] minutes = new int[]{0,0,0,0,1,2,4,8,16,32};
    List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch3(int turnedOn) {
        // 方法二：采用回溯法
        backTrack(turnedOn,0,0,0);
        return res;

    }

    // 回溯的参数：num(需要点亮的灯，初始为turnedOn),index(点亮的下标)
    // hour(小时数)minute(分钟数)
    public void backTrack(int num,int index,int hour,int minute){
        // 剪枝操作
        if(hour > 11  || minute > 59){
            return;
        }
        // 递归出口,当点亮到第0栈灯的时候，那么回溯所有数据
        if(num == 0){
            // 进行字符串拼接
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if(minute < 10){
                sb.append('0');
            }
            sb.append(minute);
            res.add(sb.toString());
            //记得return终止掉
            return;
        }
        // 这里是从下标开始递归遍历
        for(int i = index; i < 10; i++){
            backTrack(num - 1, i+1,hour+hours[i],minute+minutes[i]);
        }
    }
}
