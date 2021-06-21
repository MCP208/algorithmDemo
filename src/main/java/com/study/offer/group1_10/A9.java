package com.study.offer.group1_10;

/**
 * @author ZJP
 * @create 2021-04-20 16:38
 */
public class A9 {
    /**
     *
     *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
     *  输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     *
     * 示例 1：
     *
     * 输入：[3,4,5,1,2]
     * 输出：1
     * 示例 2：
     *
     * 输入：[2,2,2,0,1]
     * 输出：0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
         int [] numbers={2,2,2,0,1};
        System.out.println(minArray(numbers));
    }

    private static int  NineZJP(int [] numbers){
        //直接求数组中的最小数不就行了 为啥还要选择数组什么意思？
        int n=numbers[0];
        for (int i=1;i<numbers.length;i++){
            if(numbers[i]<n){
                n=numbers[i];
            }
        }
        return n;
    }

       /** 题解：
         *   给出的结构固定：旋转数组：---->考察：部分有序降低时间复杂度
         *  需要做的就是找到数组的临界值。然后拿到最小的数
         *  二分法：
         *
         *
         */
       static int minArray(int [] numbers) {
            int low = 0;
            int high = numbers.length - 1;
            while (low < high) {
                int pivot = low + (high - low) / 2;
                if (numbers[pivot] < numbers[high]) {
                    high = pivot;
                }
                else if (numbers[pivot] > numbers[high]) {
                    low = pivot + 1;
                }
                else {
                    high -= 1;
                }
            }
            return numbers[low];
        }

}
