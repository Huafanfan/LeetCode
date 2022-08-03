package hard;

import java.util.Arrays;

public class OrderlyQueue0899 {
    public String orderlyQueue(String s, int k) {
        if (k == 1){
            String min = s;
            StringBuilder sb = new StringBuilder(s);
            for (int i=0; i<s.length(); i++){
                sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
                if (sb.toString().compareTo(min) < 0){
                    min = sb.toString();
                }
            }
            return min;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }
    }

    public String orderlyQueue2(String s, int _k) {
        char[] cs = s.toCharArray();
        if (_k == 1) {
            int i = 0, j = 1, k = 0, n = cs.length;
            while (i < n && j < n && k < n) {
                char a = cs[(i + k) % n], b = cs[(j + k) % n];
                if (a == b) k++;
                else {
                    if (a > b) i += k + 1;
                    else j += k + 1;
                    if (i == j) i++;
                    k = 0;
                }
            }
            i = Math.min(i, j);
            return s.substring(i) + s.substring(0, i);
        } else {
            Arrays.sort(cs);
            return String.valueOf(cs);
        }
    }
}
