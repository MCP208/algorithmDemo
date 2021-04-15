package com.study.offer.OneToTen;

/**
 * @author ZJP
 * @create 2021-04-14 16:47
 */
public class Two {

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     *  
     *
     * 示例:
     *
     * 现有矩阵 matrix 如下：
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     *
     * 给定 target = 20，返回 false。
     *
     *  
     *
     * 限制：
     *
     * 0 <= n <= 1000
     *
     * 0 <= m <= 1000
     *
     *
     */
    public static void main(String[] args) {
        int[][] nums = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target=100;
        boolean result  = twoZJP(nums, target);
        if(result){
            System.out.println("target值在二维数组中");
        }else {
            System.out.println("target值没有二维数组中");
        }

    }
    /*
    *@author ZJP
    *@Description
    *@param
    *@return
    *@data 2021-04-14 17:15
    */ 
    private static boolean twoZJP(int[][] nums, int target) {
        int rows = nums.length;
        int columns = nums[0].length;
        if (nums == null || rows == 0 || columns == 0 || rows < 0 || rows > 1000 || columns < 0 || columns > 1000) {
            return false;
        }
        //循环判断数组中有没有数据
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(nums[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
