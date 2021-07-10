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

    public static void main(String[] args)
    {
        Main m = new Main();
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int[][] num = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[] start = new int[]{0,0};
        int[] end = new int[]{2,2};
        out.println(m.minimumInitHealth(num, start, end));
        out.close();
    }

    //public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
    //    // write code here
    //}
    public String compressString(String param) {
        //"shopeew"
        StringBuilder sb = new StringBuilder();
        char pre = param.charAt(0);
        int count = 1;
        for (int i=1; i<param.length(); i++){
            char ch = param.charAt(i);
            if (ch == pre){
                count++;
            }
            else {
                sb.append(pre);
                if (count > 1){
                    sb.append(count);
                }
                pre = ch;
                count = 1;
            }
        }
        sb.append(pre);
        if (count > 1){
            sb.append(count);
        }
        return sb.toString();
    }

    public int petalsBreak(int[] petals) {
        int count = 0;
        for (int petal : petals) {
            if (petal > 0){
                count += ((petal >> 1) + (petal & 1));
            }
        }
        return count;
    }

    List<Integer> cost = new ArrayList<>();
    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
        int[][] isUsed = new int[rooms.length][rooms[0].length];
        isUsed[startPoint[0]][startPoint[1]] = 1;
        List<String> path = new ArrayList<>();
        path.add(startPoint[0] +" "+ startPoint[1]);
        dfs(path, rooms, isUsed, startPoint[0], startPoint[1], rooms[startPoint[0]][startPoint[1]], endPoint[0], endPoint[1]);
        Collections.sort(cost);
        for (int i=0; i<cost.size(); i++){
            if (cost.get(i) > 0){
                if (i>1){
                    return -cost.get(i-1) + 1;
                }
                else {
                    return 0;
                }
            }
        }
        return 0;
    }

    public void dfs(List<String> path, int[][] rooms, int[][] isUsed, int x, int y, int health, int endx, int endy){
        if (x == endx && y == endy){
            cost.add(health);
            return;
        }
        if (x-1>=0 && isUsed[x-1][y] == 0){
            isUsed[x-1][y] = 1;
            health += rooms[x-1][y];
            path.add((x-1)  + " " + y);
            dfs(path, rooms, isUsed, x-1, y, health, endx, endy);
            health -= rooms[x-1][y];
            isUsed[x-1][y] = 0;
            path.remove(path.size()-1);
        }
        if (x+1<rooms.length && isUsed[x+1][y] == 0){
            isUsed[x+1][y] = 1;
            health += rooms[x+1][y];
            path.add((x+1)  + " " + y);
            dfs(path, rooms, isUsed, x+1, y, health, endx, endy);
            health -= rooms[x+1][y];
            isUsed[x+1][y] = 0;
            path.remove(path.size()-1);
        }
        if (y-1>=0 && isUsed[x][y-1] == 0){
            isUsed[x][y-1] = 1;
            health += rooms[x][y-1];
            path.add(x  + " " + (y-1));
            dfs(path, rooms, isUsed, x, y-1, health, endx, endy);
            health -= rooms[x][y-1];
            isUsed[x][y-1] = 0;
            path.remove(path.size()-1);
        }
        if (y+1<rooms[0].length && isUsed[x][y+1] == 0){
            isUsed[x][y+1] = 1;
            health += rooms[x][y+1];
            path.add(x  + " " + (y+1));
            dfs(path, rooms, isUsed, x, y+1, health, endx, endy);
            health -= rooms[x][y+1];
            isUsed[x][y+1] = 0;
            path.remove(path.size()-1);
        }
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
