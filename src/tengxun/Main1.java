package tengxun;

import java.util.Scanner;

/**
 * @Author Baker.chen
 * @create 2020/8/23 20:04
 *
 * 删除节点：
 *
 * case通过75%，超时
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = n-1; i >= 0; i--) {
            linkedList.addNode(arr[i]);
        }
        if (k < n) {
            linkedList.delNode(k);
        }
        //linkedList.ListNode();
    }
}

class LinkedList {
    Node head = new Node(0);
    /**
     * 添加节点:头插法
     * @param val
     */
    public void addNode(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        /*if (head.next == null) {
            head.next = node;
            return;
        }
        Node temp = head.next;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;*/
    }

    /**
     * 遍历单链表
     */
    public void ListNode() {
        if (head.next == null) {
            return;
        }
        Node temp = head.next;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    /**
     * 删除第k个节点
     * @param k
     */
    public void delNode(int k) {
        if (head.next == null) {
            return;
        }
        Node temp = head;
        // 找到第k-1个节点
        for (int i = 0; i < k - 1; i++) {
            temp = temp.next;
            System.out.print(temp.val + " ");
        }
        temp.next = temp.next.next;
        while (temp.next != null) {
            System.out.print(temp.next.val + " ");
            temp = temp.next;
        }
    }
}

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}
