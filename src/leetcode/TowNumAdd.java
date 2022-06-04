package leetcode;

import java.util.Arrays;

/**
 * @program: pay-router
 * @description:
 * @author: xiamu
 * @create: 2021-03-15 20:10
 */
public class TowNumAdd {

    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};

        //System.out.println(descSort(a) + descSort(b));

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode3.next = listNode2;
        listNode2.next = listNode1;
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode8 = new ListNode(8);
        listNode8.next = listNode6;
        listNode6.next = listNode5;
        listNode5.next = listNode4;
       // ListNode listNode = addTwoNumbers2(listNode3, listNode6);

        ListNode  listNode = addTwoNumbersC(listNode3, listNode8);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
        System.out.println(listNode.next.next.next.val);


    }

    public static int descSort(int[] params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= params.length / 2; i++) {
            int f = params[i];
            params[i] = params[params.length - 1 - i];
            params[params.length - 1 - i] = f;
        }
        Arrays.stream(params).forEach((a) -> {
            stringBuilder.append(a);
        });
        return Integer.parseInt(stringBuilder.toString());
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean liHasNext = true;
        boolean l2HasNext = true;

        int sum = 0;
        ListNode listNode = new ListNode(0);
        ListNode endlistNode = new ListNode(0);
        listNode.next = endlistNode;
        while (liHasNext || l2HasNext || sum > 0) {
            int val = 0;
            int va2 = 0;
            if (liHasNext) {
                val = l1.val;
                l1 = l1.next;
                if (l1 == null) {
                    liHasNext = false;
                }
            } else {
                liHasNext = false;
            }
            if (l2HasNext) {
                va2 = l2.val;
                l2 = l2.next;
                if (l2 == null) {
                    l2HasNext = false;
                }
            } else {
                l2HasNext = false;
            }

            sum += val + va2;
            ListNode listNode1 = new ListNode(sum % 10);
            endlistNode.next = listNode1;
            endlistNode = listNode1;
            sum /= 10;
        }
        return listNode.next.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1.val;
            int l2Val = l2.val;
            //总和
            int sumVal = l1Val + l2Val + carry;
            //判断是否需要进位
            carry = sumVal / 10;
            //创建一个子节点
            ListNode sumNode = new ListNode(sumVal % 10);
            //子节点关联到父节点
            cursor.next = sumNode;
            //当前节点声明为父节点
            cursor = sumNode;
            //计算下一个节点的和
            l1 = l1.next;
            l2 = l2.next;
        }

        return root.next;
    }

    public static ListNode addTwoNumbersC(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode model = new ListNode(0);
        ListNode cursor = model;
        while (l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum =l1Val + l2Val + carry;
            //子节点
            ListNode result = new ListNode(sum % 10);
            cursor.next = result;
            cursor = result;
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return model.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
