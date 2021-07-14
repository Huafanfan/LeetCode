package medium;

public class GetEqualSubstringsWithinBudget1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        s = " " + s;
        t = " " + t;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] sum = new int[n + 1];
        for (int i=1; i<=n; i++){
            sum[i] = sum[i-1] + Math.abs(ss[i] - tt[i]);
        }
        int l = 1;
        int r = n;
        while (l < r){
            int mid = (r - l + 1) / 2 + l;
            if (check(sum, mid, maxCost)){
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }
        return check(sum, l, maxCost) ? l : 0;
    }
    public boolean check(int[] sum, int mid, int maxCost){
        for (int i = mid; i<sum.length; i++){
            int tol = sum[i] - sum[i - mid];
            if (tol <= maxCost){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GetEqualSubstringsWithinBudget1208 getEqualSubstringsWithinBudget1208 = new GetEqualSubstringsWithinBudget1208();
        System.out.println(getEqualSubstringsWithinBudget1208.equalSubstring("abcd", "bcdf", 3));
    }
}
