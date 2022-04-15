package medium;

/**
 * @author Alex
 * @version 1.0
 * @date 2022/4/15 11:52
 */
public class MiniParser0385 {
    int index = 0;
    static class NestedInteger {

        public NestedInteger(int num) {

        }

        public NestedInteger() {

        }

        public void add(NestedInteger deserialize) {
        }

    }
    public NestedInteger deserialize(String s) {
        if (s.charAt(index) == '[') {
            index++;
            NestedInteger ni = new NestedInteger();
            while (s.charAt(index) != ']') {
                ni.add(deserialize(s));
                if (s.charAt(index) == ',') {
                    index++;
                }
            }
            index++;
            return ni;
        } else {
            boolean negative = false;
            if (s.charAt(index) == '-') {
                negative = true;
                index++;
            }
            int num = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + s.charAt(index) - '0';
                index++;
            }
            if (negative) {
                num *= -1;
            }
            return new NestedInteger(num);
        }
    }
}
