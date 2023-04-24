package leetcode.list;

/**
 * @program: Thread
 * @description: 链表反转
 * @author: liuhao
 * @date: 2023-04-03 13:51
 */
public class ListReverse {
    private static Node head;
    private static DoubleNode head2;

    static {
        Node a = new Node("a");
        head = a;
        Node b = new Node("b");
        a.next = b;
        Node c = new Node("c");
        b.next = c;

        DoubleNode ad = new DoubleNode("ad");
        head2 = ad;
        DoubleNode bd = new DoubleNode("bd");
        ad.next = bd;
        bd.pred = ad;
        DoubleNode cd = new DoubleNode("cd");
        bd.next = cd;
        cd.pred = bd;
        DoubleNode dd = new DoubleNode("dd");
        dd.pred = cd;
        cd.next = dd;


    }

    public static void main(String[] args) {
        /*System.out.println(each(head));
        Node reverse = reverse2(head);
        System.out.println(each(reverse));*/


        System.out.println(each(head2));
//        DoubleNode reverse = reverseDoubleItr(head2);
        DoubleNode reverse = recursion(head2);
        System.out.println(each(reverse));


    }

    /**
     * a - > b next
     * a < - b pred
     */

    private static DoubleNode reverseDouble(DoubleNode head) {
        if (head == null || head.next == null) {
            // last node
            head.pred = null;
            return head;
        }
        DoubleNode doubleNode = reverseDouble(head.next);

        // 当前节点下一个节点的  下一个节点 指向当前节点
        head.next.next = head;
        head.next.pred = head.next;
        head.next = null;

        // 返回的永远是第一个节点
        return doubleNode;


    }

    //双向链表反转，递归反转
    public static DoubleNode recursion(DoubleNode head) {  //参数传入链表的头指针（不带头结点）
        if (head == null)
            return head;
        // 最后一个元素单独处理
        if (head.next == null) {
            head.next = head.pred;
            head.pred = null;
            return head;
        }
        DoubleNode newHead = recursion(head.next);
        DoubleNode next = head.next;
        //  当前节点的下一个节点为 上一个节点
        head.next = head.pred;
        //  当前节点的上一个节点为  下一个节点
        head.pred = next;
        return newHead;
    }

    private static DoubleNode reverseDoubleItr(DoubleNode head) {
        DoubleNode curr = head;
        DoubleNode pred = null; // 前一个节点
        DoubleNode next = null; //  后一个节点

        while (curr != null) {
            // 下一个节点
            next = curr.next;
            // 下一个节点指向前一个节点
            curr.next = pred;
            // 前一个指针原本指向上一个节点，此时指向下一个节点
            curr.pred = next;

            // 前一个指针前移
            pred = curr;
            // 当前指针后裔
            curr = next;

        }
        return pred;
    }


    private static String each(Node head) {
        StringBuilder result = new StringBuilder();
        result.append(head.data).append("->");
        Node next = head.next;
        while (true) {
            if (next != null) {
                result.append(next.data).append("->");
                next = next.next;
            } else {
                break;
            }
        }
        return result.toString();
    }

    private static String each(DoubleNode head) {
        StringBuilder result = new StringBuilder();
        result.append(head.data).append("->");
        DoubleNode next = head.next;
        while (true) {
            if (next != null) {
                result.append(next.data).append("->");
                next = next.next;
            } else {
                break;
            }
        }
        return result.toString();
    }


    //    a -> b -> c   a <- b <- c

    /**
     * 链表反转
     */
    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            // 仅一个元素
            return head;
        }
        Node newHead = reverse(head.next);
        // 下一个节点 关联到 上一个节点
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    static Node reverse2(Node head) {
        Node pred = null; // 前一个节点
        Node next;          // 后一个节点
        Node curr = head;   // 当前节点
        while (curr != null) {
            next = curr.next; // 下一个
            curr.next = pred;// 指向前一个
            pred = curr;    // 前指针后移动
            curr = next;    // 当前指针后移

        }
        return pred;
    }
}


class Node {
    Node next;
    String data;

    public Node(String data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class DoubleNode {
    /**
     * 前一个节点
     */
    DoubleNode pred;
    DoubleNode next;

    String data;

    public DoubleNode(String data) {
        this.data = data;
    }

    public DoubleNode getPred() {
        return pred;
    }

    public void setPred(DoubleNode pred) {
        this.pred = pred;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}