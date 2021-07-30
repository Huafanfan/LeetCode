package easy;

public class ExcelSheetColumnNumber0171 {
//    A -> 1
//    B -> 2
//    C -> 3
//            ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//            ...
    public int titleToNumber(String columnTitle) {
        int num = 0;
        int pow = 0;
        char[] chars = columnTitle.toCharArray();
        for (int i=chars.length - 1; i >= 0; i--){
            num += (chars[i] - 'A' + 1) * (int)Math.pow(26, pow++);
        }
        return num;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber0171 excelSheetColumnNumber0171 = new ExcelSheetColumnNumber0171();
        System.out.println(excelSheetColumnNumber0171.titleToNumber("A"));
        System.out.println(excelSheetColumnNumber0171.titleToNumber("Z"));
        System.out.println(excelSheetColumnNumber0171.titleToNumber("AA"));
        System.out.println(excelSheetColumnNumber0171.titleToNumber("AB"));
        System.out.println(excelSheetColumnNumber0171.titleToNumber("ZY"));
        System.out.println(excelSheetColumnNumber0171.titleToNumber("FXSHRXW"));
    }
}
