package microsoft;

public class ExcelSheetColumnNumber0171 {
    public int titleToNumber(String s) {
        int res = 0;
        int weight = 1;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i=len - 1; i>=0; i--){
            res = res + (chars[i] - 'A' + 1) * weight;
            weight *= 26;
        }

        for (int i=0; i<len; i++){
            res = res * 26 + (chars[i] - 'A' + 1);
        }

        return res;
    }
}
