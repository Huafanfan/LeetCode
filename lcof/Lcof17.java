package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/13 09:35
 */
public class Lcof17 {
    /**
     * 不考虑int越界
     * 100.00%
     * 87.42%
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for(int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    StringBuilder res;
    int count = 0, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers2(int n) {
        this.n = n;
        // 数字字符串集
        res = new StringBuilder();
        // 定义长度为 n 的字符列表
        num = new char[n];
        // 开启全排列递归
        dfs(0);
        // 删除最后多余的逗号
        res.deleteCharAt(res.length() - 1);
        // 转化为字符串并返回
        return res.toString();
    }
    void dfs(int x) {
        // 终止条件：已固定完所有位
        if(x == n) {
            // 拼接 num 并添加至 res 尾部，使用逗号隔开
            res.append(String.valueOf(num)).append(",");
            return;
        }
        // 遍历 ‘0‘ - ’9‘
        for(char i : loop) {
            // 固定第 x 位为 i
            num[x] = i;
            // 开启固定第 x + 1 位
            dfs(x + 1);
        }
    }

    int nine = 0, start;
    public String printNumbers3(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        dfs1(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    void dfs1(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!"0".equals(s)) {
                res.append(s).append(",");
            }
            if(n - start == nine) {
                start--;
            }
            return;
        }
        for(char i : loop) {
            if(i == '9') {
                nine++;
            }
            num[x] = i;
            dfs1(x + 1);
        }
        nine--;
    }

    int[] resArrays;
    public int[] printNumbers4(int n) {
        this.n = n;
        resArrays = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs2(0);
        return resArrays;
    }
    void dfs2(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!"0".equals(s)) {
                resArrays[count++] = Integer.parseInt(s);
            }
            if(n - start == nine) {
                start--;
            }
            return;
        }
        for(char i : loop) {
            if(i == '9') {
                nine++;
            }
            num[x] = i;
            dfs2(x + 1);
        }
        nine--;
    }

    public static void main(String[] args) {
        Lcof17 lcof17 = new Lcof17();
        System.out.println(lcof17.printNumbers3(2));
    }
}
