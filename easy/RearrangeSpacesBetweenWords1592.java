package easy;

/**
 * @author yifan.zhangyf
 * @date 2022/9/7 10:34 PM
 */
public class RearrangeSpacesBetweenWords1592 {
    public String reorderSpaces(String text) {
        int length = text.length();
        String[] words = text.trim().split("\\s+");
        int cntSpace = length;
        for (String word : words) {
            cntSpace -= word.length();
        }
        StringBuilder sb = new StringBuilder();
        if (words.length == 1) {
            sb.append(words[0]);
            sb.append(" ".repeat(cntSpace));
            return sb.toString();
        }
        int perSpace = cntSpace / (words.length - 1);
        int restSpace = cntSpace % (words.length - 1);
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                sb.append(" ".repeat(perSpace));
            }
            sb.append(words[i]);
        }
        sb.append(" ".repeat(restSpace));
        return sb.toString();
    }
}
