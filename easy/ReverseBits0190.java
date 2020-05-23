package com.huafanfan.easy;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/5/14 11:38
 */
public class ReverseBits0190 {
    /**
     * 调用库函数
     * @param n
     * @return
     */
    public int reverseBitsSourceCode(int n) {
        return Integer.reverse(n);
    }

    /**
     * 逐位颠倒
     * 时间复杂度：O(log2N)。在算法中，我们有一个循环来迭代输入的最高非零位，即log2N。
     * 空间复杂度：O(1)，因为不管输入是什么，内存的消耗是固定的。
     * 给定的n从末尾开始先与1做与运算，所得的数向左移位31-i，给定的n向右移位i
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int a=0;
        for(int i=0;i<=31;i++){
            a=a+((1&(n>>i))<<(31-i));
        }
        return a;
    }

    /**
     * 分治
     */

    public int reverseBitsDivideAndConquer(int n) {
        n=(n>>>16)|(n<<16);
        n=((n&0xff00ff00)>>>8)|((n&0x00ff00ff)<<8);
        n=((n&0xf0f0f0f0)>>>4)|((n&0x0f0f0f0f)<<4);
        n=((n&0xcccccccc)>>>2)|((n&0x33333333)<<2);
        n=((n&0xaaaaaaaa)>>>1)|((n&0x55555555)<<1);
        return n;
    }

}
