package com.study.offer.OneToTen;

/**
 * @author ZJP
 * @create 2021-04-14 17:12
 */
public class Three {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *  
     *
     * 限制：
     *
     * 0 <= s 的长度 <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        String str="We are happy.";

        String s = threeZJP(str);
        System.out.println("转换的值为："+s);
    }
    
    /*
    *@author ZJP
    *@Description
    *@param
    *@return
    *@data 2021-04-14 17:15
    */
    private static  String threeZJP(String str){
        String string="";
        if(str.length()>=5 && str.length()<=10000){
            String replace = str.replace(" ", "%20");
            string=replace;
        }
        
        return string;
    }
}
