package com.study.offer.OneToTen;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ZJP
 * @create 2021-04-16 9:50
 */
public class Six {
    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     *
     *  
     *
     * 示例 1：
     *
     * 输入：
     * ["CQueue","appendTail","deleteHead","deleteHead"]
     * [[],[3],[],[]]
     * 输出：[null,null,3,-1]
     * 示例 2：
     *
     * 输入：
     * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [[],[],[5],[2],[],[]]
     * 输出：[null,-1,null,null,5,2]
     * 提示：
     *
     * 1 <= values <= 10000
     * 最多会对 appendTail、deleteHead 进行 10000 次调用
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 题解：
     * 简单明了，带你直接看懂题目和例子。 输入： ["CQueue","appendTail","deleteHead","deleteHead"] 这里是要执行的方法，从左到右执行
     * <p>
     * [[],[3],[],[]]对应上面的方法，是上面方法的参数。CQueue和deleteHead方法不需要指定数字，只有添加才需要指定数字
     * <p>
     * 1.创建队列，返回值为null
     * <p>
     * 2.将3压入栈，返回值为null
     * <p>
     * 3.将栈底的元素删除，也就是消息队列中先进来的元素，所以是deleteHead，返回该元素的数值，所以为3
     * <p>
     * 4.继续删除栈底的元素，但是没有元素了，所以返回-1
     * <p>
     * 所以就有了下面的输出 输出：[null,null,3,-1]
     * <p>
     * 示例 2： 输入： ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * <p>
     * [[],[],[5],[2],[],[]]
     * <p>
     * 1.创建队列，返回值为null
     * <p>
     * 2.删除栈底的元素，但是没有元素，所以返回-1
     * <p>
     * 3.把5压入栈，返回null
     * <p>
     * 4.把2压入栈，返回null
     * <p>
     * 5.删除栈底的一个元素，也就是消息队列中先进来的元素，所以是deleteHead，就是最先进来的5，返回值为5，
     * <p>
     * 6.删除栈底的一个元素，就是后进来的2，返回值为2，
     * <p>
     * 所以就有了下面的输出
     * <p>
     * 输出：[null,-1,null,null,5,2]
     * <p>
     * 有没有发现先进来的数字，首先显示出来了，但是题目中说要使用栈，栈是先进后出的，使用栈来实现先进先出，在这里使用两个栈就好了，从一个进来再到另一个栈，这样顺序就是先进先出了。题目的主旨写在第一句，就是，使用两个栈实现一个队列。
     */
    public static void main(String[] args) {
       //这个题有点懵逼 坐等春鹏大佬介绍 思路和答案都给你写在上面了
    }

    class CQueue {
        //两个栈，一个出栈，一个入栈
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if(!stack2.isEmpty()){
                return stack2.pop();
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.isEmpty() ? -1 : stack2.pop();
            }
        }
    }
}
