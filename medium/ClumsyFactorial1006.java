package medium;

import java.util.Deque;
import java.util.LinkedList;

public class ClumsyFactorial1006 {
    public int clumsy(int N) {
        if (N == 1){
            return 1;
        }
        Deque<Integer> num = new LinkedList<>();
        num.push(N);
        int status = 0;
        for (int i=N-1; i>=1; i--){
            switch (status){
                case 0:
                    num.push(num.pop() * i);
                    status = 1;
                    break;
                case 1:
                    num.push(num.pop() / i);
                    status = 2;
                    break;
                case 2:
                    num.push(i);
                    status = 3;
                    break;
                case 3:
                    num.push(-i);
                    status = 0;
                    break;
                default:
            }
        }
        int res = 0;
        while (!num.isEmpty()){
            res += num.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        ClumsyFactorial1006 clumsyFactorial1006 = new ClumsyFactorial1006();
        System.out.println(clumsyFactorial1006.clumsy(10));
    }
}
