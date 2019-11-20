package package1103;

import java.util.Stack;

public class QueueBy2Stack {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 把 B 中的元素都往 A 中倒腾, 倒腾完了之后再把新元素
        // 插入到 A 之中
        while (!B.isEmpty()) {
            int tmp = B.pop();
            A.push(tmp);
        }
        A.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 如果是空的队列, 不需要进行出队列
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        // 要把 A 中的元素先都倒腾到 B 中
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.pop();
    }

    /** Get the front element. */
    public int peek() {
        // 如果是空的队列, 不需要进行出队列
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        // 要把 A 中的元素先都倒腾到 B 中
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
