package bishi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/7/5 14:35
 */
public class Main
{
    static Map<Integer, Boolean> memory = new HashMap<>();
    public static void main(String[] args)
    {
        Main main = new Main();
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int s = in.nextInt();
        for (int a=0; a<s; a++){
            int m = in.nextInt();
            int n = in.nextInt();
            int [][] nums = new int[m][n];
            int startX = 0, startY = 0;
            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    nums[i][j] = in.nextInt();
                    if (nums[i][j] == 0){
                        startX = i;
                        startY = j;
                    }
                }
            }

            if (main.dfs(nums, startX, startY, 0)){
                out.println("YES");
            }
            else {
                out.println("NO");
            }

        }
        out.close();
    }

    public boolean dfs(int[][] nums, int x, int y, int time){
        if (x < 0 || x == nums.length ||  y < 0 || y == nums[0].length || nums[x][y]  < time || !memory.getOrDefault(x + y * 100 + time, true)){
            return false;
        }
        if (x == nums.length - 1 && y == nums[0].length - 1){
            return true;
        }
        int tmp = nums[x][y];
        nums[x][y] = -1;
        boolean res = false;
        res = dfs(nums, x - 1, y, time + 1);
        if (res){
            return true;
        }
        res = dfs(nums, x + 1, y, time + 1);
        if (res){
            return true;
        }
        res = dfs(nums, x, y-1 , time+1);
        if (res){
            return true;
        }
        res = dfs(nums, x, y+1 , time+1);
        if (res){
            return true;
        }
        nums[x][y] = tmp;
        memory.put(x + y * 100 + time, false);
        return false;
    }
}
class InputReader
{
    BufferedReader buf;
    StringTokenizer tok;
    InputReader()
    {
        buf = new BufferedReader(new InputStreamReader(System.in));
    }
    boolean hasNext()
    {
        while(tok == null || !tok.hasMoreElements())
        {
            try
            {
                tok = new StringTokenizer(buf.readLine());
            }
            catch(Exception e)
            {
                return false;
            }
        }
        return true;
    }
    String next()
    {
        if(hasNext()) return tok.nextToken();
        return null;
    }
    int nextInt()
    {
        return Integer.parseInt(next());
    }
    long nextLong()
    {
        return Long.parseLong(next());
    }
    double nextDouble()
    {
        return Double.parseDouble(next());
    }
    BigInteger nextBigInteger()
    {
        return new BigInteger(next());
    }
    BigDecimal nextBigDecimal()
    {
        return new BigDecimal(next());
    }
}
