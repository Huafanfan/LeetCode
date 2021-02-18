package microsoft;

public class CompareVersionNumbers0165 {
    public int compareVersion(String version1, String version2) {
        String[] version1Arrays = version1.split("\\.");
        String[] version2Arrays = version2.split("\\.");
        int len1 = version1Arrays.length;
        int len2 = version2Arrays.length;
        int i1, i2;
        for (int i = 0; i < Math.max(len1, len2); ++i) {
            i1 = i < len1 ? Integer.parseInt(version1Arrays[i]) : 0;
            i2 = i < len2 ? Integer.parseInt(version2Arrays[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers0165 compareVersionNumbers0165 = new CompareVersionNumbers0165();
        System.out.println(compareVersionNumbers0165.compareVersion("0.1", "1.1"));
    }
}
