package com.study.offer.group1_10;

import java.util.Stack;

/**
 * @author ZJP
 * @create 2021-04-16 9:50
 */
public class A6 {

    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     *
     * 示例 1：
     * 输入：
     * ["CQueue","appendTail","deleteHead","deleteHead"]
     * [[],[3],[],[]]
     * 输出：[null,null,3,-1]
     *
     * 示例 2：
     * 输入：
     * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [[],[],[5],[2],[],[]]
     * 输出：[null,-1,null,null,5,2]
     *
     * 提示：
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
     * [[],[3],[],[]]对应上面的方法，是上面方法的参数。CQueue和deleteHead方法不需要指定数字，只有添加才需要指定数字
     * 1.创建队列，返回值为null
     * 2.将3压入栈，返回值为null
     * 3.将栈底的元素删除，也就是消息队列中先进来的元素，所以是deleteHead，返回该元素的数值，所以为3
     * 4.继续删除栈底的元素，但是没有元素了，所以返回-1
     * 所以就有了下面的输出 输出：[null,null,3,-1]
     *
     * 示例 2： 输入： ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [[],[],[5],[2],[],[]]
     * 1.创建队列，返回值为null
     * 2.删除栈底的元素，但是没有元素，所以返回-1
     * 3.把5压入栈，返回null
     * 4.把2压入栈，返回null
     * 5.删除栈底的一个元素，也就是消息队列中先进来的元素，所以是deleteHead，就是最先进来的5，返回值为5，
     * 6.删除栈底的一个元素，就是后进来的2，返回值为2，
     * 所以就有了下面的输出
     * 输出：[null,-1,null,null,5,2]
     * 有没有发现先进来的数字，首先显示出来了，但是题目中说要使用栈，栈是先进后出的，使用栈来实现先进先出，
     * 在这里使用两个栈就好了，从一个进来再到另一个栈，这样顺序就是先进先出了。题目的主旨写在第一句，就是，使用两个栈实现一个队列。
     */

    public static void main(String[] args) {
        CQueue cQueue=new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.deleteHead();
        cQueue.deleteHead();
        cQueue.deleteHead();
        cQueue.deleteHead();

    }

    /**
     *  做题前，要知道栈和队列的基础知识：
     *       栈： 先进后出
     *       队列：先进先出
     *
     *  理解题目：
     *      就是调用方法和对应的参数：
     *           CQueue()--创建队列，无返回值
     *           deleteHead()--从队列的头部删除一个元素，返回删除的元素值，如果没有元素了，就返回-1
     *           appendTail(5)--从队列的尾部追加一个元素，无返回值
     *  这下就明了了，就是用两个栈实现先进先出的数据结构，并且实现这三个方法：
     *
     *  思路：
     *
     */

    static class CQueue {
        //两个栈，一个出栈，一个入栈
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        //创建队列：新建两个栈
        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        //往队列中添加元素：直接入栈
        public void appendTail(int value) {
            stack1.push(value);     //[1,2,3]
        }

        //删除队列中元素：把stack1中的元素出栈并且入栈到stack2中去：
        //stack.pop--->[3,2,1]----stack2.push---->stack2=[3,2,1]
        //最后判断如果stack2为空，就返回-1，不为空就pop一下得到结果[3,2]，再进行返回
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
