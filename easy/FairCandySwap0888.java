package easy;

import java.util.*;

public class FairCandySwap0888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }

    public int[] fairCandySwap2(int[] A, int[] B) {
        boolean[] flag =new boolean[100001];
        int diff=0;
        for (int num : A) {
            diff-=num;
        }
        for (int num : B) {
            diff+=num;
            flag[num]=true;
        }
        diff/=2;
        for (int num : A) {
            int numb=num+diff;
            if (numb>0&&numb<100001&&flag[numb]){
                return new int[]{num,numb};
            }
        }
        return new int[]{};
    }
}
