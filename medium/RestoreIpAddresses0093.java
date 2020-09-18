package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/18 12:13
 */
public class RestoreIpAddresses0093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        Deque<String> ip = new ArrayDeque<>();
        int spiltTimes = 0;
        dfs(s, s.length(), spiltTimes, 0, ip, result);
        return result;
    }

    public void dfs(String s, int length, int spiltTimes, int start, Deque<String> ip, List<String> result){
        if (start == length){
            if (spiltTimes == 4){
                result.add(String.join(".", ip));
            }
            return;
        }
        if (length - start < (4 - spiltTimes) || length - start > 3 * (4 - spiltTimes)){
            return;
        }

        for (int i=0; i<3; i++){
            if (start + i >= length) {
                break;
            }
            int ipSegment = judgeIP(s,start,start+i);
            if (ipSegment != -1){
                ip.addLast(ipSegment + "");
                dfs(s, length, spiltTimes + 1, start + i + 1, ip, result);
                ip.removeLast();
            }
        }
    }

    public int judgeIP(String s, int start , int end){
        int length = end - start + 1;
        if (length > 1 && s.charAt(start) == '0'){
            return -1;
        }
        int res = 0;
        for (int i=start; i<=end; i++){
            res = res * 10 + (s.charAt(i) - '0');
        }
        return res > 255 ? -1 : res;
    }

    public List<String> restoreIpAddressesForce(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        int length = s.length();
        for (int i=1; i<Math.min(4,length-2); i++){
            for (int j=i+1; j<Math.min(i+4,length-1); j++){
                for (int k=j+1; k<Math.min(j+4,length); k++){
                    if (length - k > 3){
                        continue;
                    }
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j,k);
                    String s4 = s.substring(k,length);
                    boolean flag = false;
                    if (s1.charAt(0)=='0'&&s1.length()>1){
                        flag = true;
                    }
                    if (s2.charAt(0)=='0'&&s2.length()>1){
                        flag = true;
                    }
                    if (s3.charAt(0)=='0'&&s3.length()>1){
                        flag = true;
                    }
                    if (s4.charAt(0)=='0'&&s4.length()>1){
                        flag = true;
                    }
                    if (flag){
                        continue;
                    }
                    int a = Integer.parseInt(s1);
                    int b = Integer.parseInt(s2);
                    int c = Integer.parseInt(s3);
                    int d = Integer.parseInt(s4);
                    if (0<=a && a<=255 && 0<=b && b<=255 && 0<=c && c<=255 && 0<=d && d<=255 ){
                        result.add(a+"."+b+"."+c+"."+d);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RestoreIpAddresses0093 restoreIpAddresses0093 = new RestoreIpAddresses0093();
        System.out.println(restoreIpAddresses0093.restoreIpAddressesForce("101023"));
    }
}
