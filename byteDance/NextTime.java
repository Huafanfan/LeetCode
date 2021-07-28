package byteDance;

import java.util.Arrays;

public class NextTime {
//    有一个表示时间的字符串，格式是“HH:MM”，你可以使用字符串中的数字（可以重复使用）来构造出另一个字符串使得表示的时间比给定的要大，而且保证是满足条件的时间中最小的，例子如下：
//    第一个例子：给定19:34，需要输出19:39，注意不能输出19:11，这样就相当于过去了24小时（到第二天了）。
//    第二个例子：给定23:59，需要输出22:22，此时表示的是第二天的时间
    public String nextMinTime(String time){
        char[] sb = time.toCharArray();
        int time0 = Integer.parseInt(String.valueOf(time.charAt(0)));
        int time1 = Integer.parseInt(String.valueOf(time.charAt(1)));
        int time3 = Integer.parseInt(String.valueOf(time.charAt(3)));
        int time4 = Integer.parseInt(String.valueOf(time.charAt(4)));
        int[] nums = new int[4];
        nums[0] = time0;
        nums[1] = time1;
        nums[2] = time3;
        nums[3] = time4;
        Arrays.sort(nums);
        for (int i=0; i<4; i++){
            if (nums[i] > time4){
                sb[4] = (char) (nums[i] + '0');
                return new String(sb);
            }
        }
        for (int i=0; i<4; i++){
            if (nums[i] > time3 && nums[i] < 6){
                sb[3] = (char) (nums[i] + '0');
                sb[4] = (char) (nums[0] + '0');
                return new String(sb);
            }
        }
        for (int i=0; i<4; i++){
            if (time0 == 2){
                if (nums[i] > time1 && nums[i] < 3 ){
                    sb[1] = (char) (nums[i] + '0');
                    sb[3] = (char) (nums[0] + '0');
                    sb[4] = (char) (nums[0] + '0');
                    return new String(sb);
                }
            }
            else {
                if (nums[i] > time1 && nums[i] < 10 ){
                    sb[1] = (char) (nums[i] + '0');
                    sb[3] = (char) (nums[0] + '0');
                    sb[4] = (char) (nums[0] + '0');
                    return new String(sb);
                }
            }

        }
        for (int i=0; i<4; i++){
            if (nums[i] > time0  && nums[i] < 3){
                sb[0] = (char) (nums[i] + '0');
                sb[1] = (char) (nums[0] + '0');
                sb[3] = (char) (nums[0] + '0');
                sb[4] = (char) (nums[0] + '0');
                return new String(sb);
            }
        }
        sb[0] = (char) (nums[0] + '0');
        sb[1] = (char) (nums[0] + '0');
        sb[3] = (char) (nums[0] + '0');
        sb[4] = (char) (nums[0] + '0');
        return new String(sb);
    }

    public static void main(String[] args) {
        NextTime nextTime = new NextTime();
        System.out.println(nextTime.nextMinTime("23:59"));
        System.out.println(nextTime.nextMinTime("12:34"));
        System.out.println(nextTime.nextMinTime("19:34"));
        System.out.println(nextTime.nextMinTime("13:59"));
        System.out.println(nextTime.nextMinTime("13:21"));
        System.out.println(nextTime.nextMinTime("19:59"));
    }
}
