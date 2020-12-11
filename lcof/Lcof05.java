package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/11 15:03
 */
public class Lcof05 {
    /**
     * 13.43%
     * 56.97%
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    /**
     * 100.00%
     * 80.54%
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }
}
