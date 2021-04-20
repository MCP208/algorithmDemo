package com.study.offer.OneToTen;

/**
 * @author ZJP
 * @create 2021-04-20 10:02
 */
public class Eight {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     * <p>
     * 输入：n = 0
     * 输出：1
     * 提示：
     * <p>
     * 0 <= n <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int i = 0;
        int n = EightZJP(i);
        System.out.println("小青蛙的跳法为："+n);
    }

    private static int EightZJP(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;

    }
}
