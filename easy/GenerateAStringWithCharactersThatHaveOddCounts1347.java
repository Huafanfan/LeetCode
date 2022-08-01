package easy;

public class GenerateAStringWithCharactersThatHaveOddCounts1347 {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 1){
            return sb.append("a".repeat(n)).toString();
        } else {
            return sb.append("a".repeat(n-1)).append("b").toString();
        }
    }

    public static void main(String[] args) {
        GenerateAStringWithCharactersThatHaveOddCounts1347 g = new GenerateAStringWithCharactersThatHaveOddCounts1347();
        System.out.println(g.generateTheString(5));
    }
}
