package microsoft;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses0022 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        traceback(res, "", n, n);
        return res;
    }
    public void traceback(List<String> res, String str, int left, int right){
        if (left == 0 && right == 0){
            res.add(new String(str));
            return;
        }
        else {
            if (left == right){
                traceback(res, str + "(", left - 1, right);
            }
            else if (left < right){
                if (left > 0){
                    traceback(res, str + "(", left - 1, right);
                }
                traceback(res, str + ")", left, right - 1);
            }
        }
    }

    public static void main(String[] args) {
        GenerateParentheses0022 generateParentheses0022 = new GenerateParentheses0022();
        System.out.println(generateParentheses0022.generateParenthesis(3));
    }
}
