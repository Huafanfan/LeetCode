package microsoft;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/2/15 20:23
 */
public class RomanToInteger0013 {
    public int romanToInt(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i=0; i<len;){
            switch (chars[i]){
                case 'I':
                    if (i < len - 1 && chars[i + 1] == 'V'){
                        res += 4;
                        i += 2;
                    }
                    else if (i < len - 1 && chars[i + 1] == 'X'){
                        res += 9;
                        i += 2;
                    }
                    else {
                        res += 1;
                        i++;
                    }
                    break;
                case 'V':
                    res += 5;
                    i++;
                    break;
                case 'X':
                    if (i < len - 1 && chars[i + 1] == 'L'){
                        res += 40;
                        i += 2;
                    }
                    else if (i < len - 1 && chars[i + 1] == 'C'){
                        res += 90;
                        i += 2;
                    }
                    else {
                        res += 10;
                        i++;
                    }
                    break;
                case 'L':
                    res += 50;
                    i++;
                    break;
                case 'C':
                    if (i < len - 1 && chars[i + 1] == 'D'){
                        res += 400;
                        i += 2;
                    }
                    else if (i < len - 1 && chars[i + 1] == 'M'){
                        res += 900;
                        i += 2;
                    }
                    else {
                        res += 100;
                        i++;
                    }
                    break;
                case 'D':
                    res += 500;
                    i++;
                    break;
                case 'M':
                    res += 1000;
                    i++;
                    break;
                default:
            }
        }
        return res;
    }
}
