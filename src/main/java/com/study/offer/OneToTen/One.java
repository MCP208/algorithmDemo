package com.study.offer.OneToTen;


import java.util.HashSet;

public class One {
   /**  剑指 Offer 03:
         找出数组中重复的数字。
        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
        也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
        示例：
                输入：
                [2, 3, 1, 0, 2, 5, 3]输出：2 或 3
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    **/

   public static void main(String[] args) {
       int[] nums={2, 3, 1, 0, 2, 5, 3};
       //findRepeatNumber(nums);
       int num = oneZjp(nums);
       if(num==-1){
           System.out.println("没有重复数据！！！");
       }else if(num==-2){
           System.out.println("数据超出了限制！！！");
       }else {
           System.out.println("重复数据为："+num);
       }
   }

    /*
    *@author ZJP
    *@Description
    *@param
    *@return
    *@data 2021-04-14 15:18
    */
    private static int oneZjp(int[] array){
        int num=-1;
        HashSet<Integer> arraySet = new HashSet<>();
        if(array.length>=2 &&  array.length<=100000) {
            //把数组放到hashSet中可以去重
            for (int i : array) {
                //如果添加不进去证明是重复数据
                if(!arraySet.add(i)){
                    num=i;
                    break;
                }
            }
        }else {
            num=-2;
        }
        return num;
    }
}
