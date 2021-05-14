package com.study.offer.group1_10;

/**
 * @author ZJP
 * @create 2021-04-16 10:53
 */
public class A7 {
    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     * 输入：n = 2
     * 输出：1
     *
     * 示例 2：
     * 输入：n = 5
     * 输出：5
     *
     * 提示：
     * 0 <= n <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int n = 3;
        int i = SevenZjp(n);
        System.out.println("斐波那契数为："+i);
    }


    /**
      * 题解：
      *     取模运算是求两个数相除的余数
     *      1e9:科学计数法，1乘以10的9次幂
      *         1e9+7这个数，满足[0,1e9+7)内所有数，两个数相加不爆int，两个数相乘不爆long
      *         long还有一点，由于1e9+7是质数，所以在[1,1e9+7)内所有数都存在关于1e9+7的逆元
     *      斐波那契数列由 0 和 1 开始：
      *     F(N) = F(N - 1) + F(N - 2), 其中 N > 1
     *     F(0) = 0,   F(1) = 1
     *           a     b
     *     F(2)=F(0)+F(1)=1
     *     F(3)=F(1)+F(2)=2
     *     F(4)=F(2)+F(3)=3
     *     F(5)=F(3)+F(4)=5
     *     F(6)=F(4)+F(5)=8
     *     F(7)=F(5)+F(6)=13
      *
      *
      */
    private static int SevenZjp(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) ;
            a = b;
            b = sum;
        }
        //最后一次循环为 f(n+1)=f(n-1)+f(n)  故返回赋值后的a
        return a;
    }
}
