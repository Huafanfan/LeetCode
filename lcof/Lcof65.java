package lcof;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/24 10:19
 */
public class Lcof65 {
    public int add(int a, int b) {
        // 当进位为 0 时跳出
        while(b != 0) {
            // c = 进位
            int c = (a & b) << 1;
            // a = 非进位和
            a ^= b;
            // b = 进位
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        Lcof65 lcof65 = new Lcof65();
        System.out.println(lcof65.add(2,1));
    }
}
