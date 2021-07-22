package byteDance;

public class IntegerReplacement {
    int minReplace = Integer.MAX_VALUE;
    public int integerReplacement(int n) {
        dfs(n, 0);
        return minReplace;
    }

    public void dfs(long n, int count){
        if (n == 1){
            minReplace = Math.min(minReplace, count);
            return;
        }
        if ((n & 1) == 1){
            dfs(n + 1, count + 1);
            dfs(n - 1, count + 1);
        }
        else {
            dfs(n /2 , count + 1);
        }
    }

    public static void main(String[] args) {
        IntegerReplacement integerReplacement = new IntegerReplacement();
        System.out.println(integerReplacement.integerReplacement(2147483647));
    }
}
