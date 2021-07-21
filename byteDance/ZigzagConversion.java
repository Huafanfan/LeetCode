package byteDance;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++){
            sbs[i] = new StringBuilder();
        }
        int step = -1;
        int index = 0;
        for (int i=0; i<s.length(); i++){
            if (index == 0 || index == numRows - 1){
                step = -step;
            }
            sbs[index].append(s.charAt(i));
            index += step;
        }
        StringBuilder res = new StringBuilder();
        for (int i=0; i<numRows; i++){
            res.append(sbs[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 3));
    }
}
