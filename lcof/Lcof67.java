package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/24 11:04
 */
public class Lcof67 {
    public int strToInt(String str) {
        String str0 = str.trim();
        int start = 0;
        int end = 0;
        char symbol = ' ';
        if (str0.charAt(0) == '+'){
            symbol = '+';
            start++;
        }
        else if (str0.charAt(0) == '-') {
            symbol = '-';
            start++;
        }

        for (int i=start; i<str0.length(); i++){
            boolean isNum = str0.charAt(i)>='0' && str0.charAt(i)<='9';
            if (i == start && !isNum){
                return 0;
            }
            end = i;
            if (!isNum){
                break;
            }
        }
        if (str0.charAt(end)>='0' && str0.charAt(end)<='9'){
            end++;
        }
        if (start > end){
            return 0;
        }
        String str1 = str0.substring(start, end);
        int resSymbol = 1;
        if (symbol == '-'){
            resSymbol = -1;
        }

        try {
            return resSymbol * Integer.parseInt(str1);
        }
        catch (Exception e){
            return resSymbol == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

    }

    public int strToInt2(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0) {
            return 0;
        }
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') {
            sign = -1;
        } else if(c[0] != '+') {
            i = 0;
        }
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') {
                break;
            }
            if(res > bndry || res == bndry && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }

    public static void main(String[] args) {
        Lcof67 lcof67 = new Lcof67();
        System.out.println(lcof67.strToInt("+fvfv"));
    }
}
