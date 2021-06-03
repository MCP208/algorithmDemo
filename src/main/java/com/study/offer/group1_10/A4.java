package com.study.offer.group1_10;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ZJP
 * @create 2021-04-15 10:22
 */
public class A4 {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= 链表长度 <= 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //定义一个头节点
    ListNode head;
    //创建一个空链表
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    //链表添加数据  先进后出
    public void addListNodeR(int data) {
        ListNode listNode = new ListNode(data);
        listNode.next = head;
        head = listNode;
    }

    //链表添加数据  先进先出
    public void addListNodeF(int data) {
        ListNode listNode = new ListNode(data);
        if (head == null) {
            head = listNode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = listNode;
        }
    }

    //打印
    public void printLink() {
        ListNode listNode = head;
        while (listNode != null) {
            System.out.println(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    //长度
    public int length() {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }
    //按索引插入
    public void insertByIndex(int index,int data) {
        ListNode node = new ListNode(data);
        if(index<0||index>length()) {
            System.out.println("插入位置不对");
            return ;
        }
        int length=1;
        ListNode tmp = head;
        while(tmp.next!=null) {
            length++;
            tmp=tmp.next;
            if(index== length) {
                node.next=tmp.next;
                tmp.next=node;
                return;
            }
        }
    }
    //按索引删除
    public void deleteByIndex(int index) {
        ListNode temp = head;
        if(index<0||index>length()) {
            System.out.println("位置不对");
            return;
        }else if(index ==0) {
            head=head.next;
        }
        else {
            for(int i=1;i<index;i++) {
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
    }

    public static void main(String[] args) {
        A4 four = new A4();
        //添加数据
      /*  four.addListNodeR(1);
        four.addListNodeR(2);
        four.addListNodeR(3);*/
        four.addListNodeF(1);
        four.addListNodeF(3);
        /*four.addListNodeF(2);*/
        four.deleteByIndex(0);
        //打印链表
        four.printLink();
        /*int[] ints = fourZJP(four.head);
        System.out.println("翻转后的数组为："+ Arrays.toString(ints));*/
    }


    private static int[] fourZJP(ListNode listNode){
        //把链表数据放到栈里面  栈的特点是 先进后出
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = listNode;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size=stack.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = stack.pop().val;
        }
        return array;
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
     *                   进来的人，放弃一切希望                   *
     *                     MCP出品、必属废品                      *
     **************************************************************
     */

    /***
     * @Author  MCP
     * @Description  递归方式
     * @Date  2021/4/26 15:21
     * @Param  [head]
     * @return int[]
     **/
    ArrayList<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int size = list.size();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    void recur(ListNode node) {
        if(node == null) return;
        recur(node.next);
        list.add(node.val);
    }


}
