package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/10/13 10:12
 */
public class FizzBuzz0412 {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            answer.add(sb.toString());
        }
        return answer;
    }
}
