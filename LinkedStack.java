// A stack implemented with an internal linked structure.

public class LinkedStack<T> {
    private static class Node<U> {    // 泛型内部类
        U item;
        Node<U> next;

        Node() {
            item = null, next = null;
        }
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>(); // End sentinel

    public void push(T item) {
        // 每调用一次push()，都会创建一个Node<T>对象，并将其链接到前一个Node<T>对象。
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if(!top.end()) {
            // 丢弃当前的Node<T>对象，并将top指向下一个Node<T>。
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<String>();
        for(String s : "Phasers on stun!".split(" ")) {
            lss.push(s);
        }
        String s;
        while(null != (s = lss.pop())) {
            System.out.println(s);
        }
    }
}/* Output:
stun!
on
Phasers
*///:~
