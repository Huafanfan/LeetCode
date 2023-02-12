package acwing.algorithmimprovement.dp.statemachine.acwing1052;

import java.util.Scanner;

/**
 * @author yifan.zhangyf
 * @date 2022/12/3 21:49
 */
public class Main{
    static int N = 55, mod = (int)1e9 + 7;

    //当前已经枚举到了第i位密码，然后在KMP匹配过程中跳到状态j(0 - m)的方案的数量
    static int[][] f = new int[N][N];
    static char[] str = new char[N];
    //next[]数组
    static int[] ne = new int[N];
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = scan.next();
        int m = s.length();
        for (int i = 1 ; i <= m ; i ++ ) {
            str[i] = s.charAt(i - 1);
        }

        //这一步是kmp中的核心预处理next操作
        for (int i = 2 , j = 0 ; i <= n ; i ++ ){
            while (j != 0 && str[i] != str[j + 1]) {
                j = ne[j];
            }
            if (str[i] == str[j + 1]) {
                j ++;
            }
            ne[i] = j;
        }

        //初始化
        //当前已经枚举了0位密码，然后状态是0的也是一种合法状态
        f[0][0] = 1;


        //我们可以想象一下，前面三道题目的状态机的转移路径图，每一个状态能够跳到的位置，进行取一个max
        //那我们这里可以想象kmp匹配过程，是不是也是进行匹配然后向前面跳，或者向后面跳的过程，
        //这样不就是类似我们前面三道题目所学习的状态机路径一样的想法，前面三道题是取最大值，
        //我们这里是求的是数量，所以比如我们从j跳到u，那么u状态的数量就要加上从跳到他的点j的数量


        //本来不是需要两组字符串才能够进行匹配，但是题目只是给出了一组字符串，怎么能够进行匹配呢？
        //前面两重循环就行，枚举了所有密码的状态其实已经定好了，有26的n次方种原字符串的选法
        //我们要做的是，将原数组所有的选法，进行匹配，如果不能匹配子串，那么就是一种合法的状态

        //枚举n位密码，进行kmp匹配
        for (int i = 0 ; i < n ; i ++ ){
            //每一位密码能够选择的情况有26种，所以枚举每一位密码时候，
            for (int j = 0 ; j < m ; j ++){
                // 需要将每一位密码能够选择的情况全部没举出来

                //接下来是枚举能够匹配的状态，因为不能匹配到 第m位，才算合法
                for (char k = 'a'; k <= 'z'; k ++){
                    //如果匹配到最后一位就矛盾了，kmp中，枚举到m就说明匹配成功，说明是子串

                    //看看j这种状态能够跳到什么位置，如果跳到的位置不超过m，那么就可以进行加上跳过来的点的数量


                    //将每一种状态能够走到的长度不超过m的路径都累加起来
                    int u = j;
                    //接下来这一步也是kmp中的模板代码
                    while (u != 0 && k != str[u + 1]) {
                        u = ne[u];
                    }
                    if (k == str[u + 1]) {
                        u ++ ;
                    }

                    //然后如果状态长度如果没有超过m，说明是合法的状态，所以我们需要对状态进行更新
                    //u是j能够跳到的点，

                    if (u < m) {
                        f[i+1][u] = (f[i+1][u] + f[i][j]) % mod;
                    }

                    //f[i][u] ==> 意思是当前已经写到了第i个密码，然后状态是u的方法数量
                    //u所有过程中u++(往前跳) 还是  u = ne[u](往回跳)，都是从j状态转移过来的
                    //因为u一开始等于j，所以相当于是j在0-m各个状态的情况下，跳到的所有状态，
                    //这就相当于前面三道题目中状态机分析的所有出边，然后我们将每一条出边的数量
                    //跳到的点u += 跳过来的点j、


                    //因为总数就这么多，可能会有重复的出边，需要进行多次计算，一样累加起来就行
                }
            }
        }
        //最后将写了i为密码的所有状态的数量都累加起来
        int res = 0;
        for (int i = 0 ; i < m ; i ++ ) {
            res = (res + f[n][i]) % mod;
        }
        System.out.println(res);
    }
}
