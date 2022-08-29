package leetcode.link;

/**
 * @program: Thread
 * @description: 链表，双向链表 单向链表  列表逆序
 * @author: liuhao
 * @date: 2022-07-19 14:38
 */
public class LinkedListLearn {
    public static void main(String[] args) {
        // 双向链表
        Links<String> links = new Links<String>();



    }

    public static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T data;
    }

    public static class Links<T> {
        private Node<T> first;
        private Node<T> last;
        private int size;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

    }
}
