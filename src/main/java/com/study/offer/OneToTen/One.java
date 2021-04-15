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

            /***
             **************************************************************
             *                                                            *
             *   .=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-.       *
             *    |                     ______                     |      *
             *    |                  .-"      "-.                  |      *
             *    |                 /            \                 |      *
             *    |     _          |              |          _     |      *
             *    |    ( \         |,  .-.  .-.  ,|         / )    |      *
             *    |     > "=._     | )(__/  \__)( |     _.=" <     |      *
             *    |    (_/"=._"=._ |/     /\     \| _.="_.="\_)    |      *
             *    |           "=._"(_     ^^     _)"_.="           |      *
             *    |               "=\__|IIIIII|__/="               |      *
             *    |              _.="| \IIIIII/ |"=._              |      *
             *    |    _     _.="_.="\          /"=._"=._     _    |      *
             *    |   ( \_.="_.="     `--------`     "=._"=._/ )   |      *
             *    |    > _.="                            "=._ <    |      *
             *    |   (_/                                    \_)   |      *
             *    |                                                |      *
             *    '-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-='      *
             *                                                            *
             *           LASCIATE OGNI SPERANZA, VOI CH'ENTRATE           *
             *                      MCP出品、必属废品                     *
             **************************************************************
             */

    /**
     * @Author  MCP
     * @Description
     * @Date  2021/4/15 15:44
     * @Param  [array]
     * @return int
     **/
    public static int program1(int[] array){
        //初始化一个长度相同的数组
        int[] temp = new int[array.length];
        //遍历数组，把array的值作为temp的下标，给该下标的temp的值+1，再进行判断temp[array[i]]。如果大于1肯定重复。
        for(int i = 0; i < array.length; i++){
            temp[array[i]]++;
            if(temp[array[i]] > 1) return array[i];
        }
        return -1;
    }

    /**
     * @Author  MCP
     * @Description
     * @Date  2021/4/15 15:44
     * @Param  [array]
     * @return int
     **/
   /*
    补充知识：while语句属于循环语句，在判断时，如果条件为true，则会继续判断，直到false为止，即会进行多次判断（除非一开始条件就是错的）
    if语句属于条件判断语句，如果条件是true，则继续执行，为false则跳出语句不执行，只会进行单次判断。所以此处用外圈判断用while。
    {2, 3, 1, 0, 0, 4} 测试数据
        */
   //若无重复数字，则nums[i]=i；否则，有些位置空缺，有些位置存在多个数字。因此，可以利用将原数组重排归位的方法，判断重复数字。
    public static int program2(int[] array){
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                if (array[i] == array[array[i]]) {
                    return array[i];
                }
                int tmp = array[i];
                array[i] = array[tmp];
                array[tmp] = tmp;
            }
        }
        return -1;
    }

}
