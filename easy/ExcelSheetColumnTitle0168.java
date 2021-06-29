package easy;

public class ExcelSheetColumnTitle0168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0){
            columnNumber -- ;
            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle0168 excelSheetColumnTitle0168 = new ExcelSheetColumnTitle0168();
        System.out.println(excelSheetColumnTitle0168.convertToTitle(26));
    }
}
