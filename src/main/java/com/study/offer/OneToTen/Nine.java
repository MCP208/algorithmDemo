package com.study.offer.OneToTen;

/**
 * @author ZJP
 * @create 2021-04-20 16:38
 */
public class Nine {

    public static void main(String[] args) {
         int [] numbers={2,2,2,0,1};

        int i = NineZJP(numbers);
        System.out.println("最小数为："+i);
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
}
