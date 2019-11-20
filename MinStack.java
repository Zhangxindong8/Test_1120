package package1103;

import java.util.Stack;

public class MinStack {
    // A 用来表示正常的栈中的数据.
    // B 用来存储每一层 A 栈帧中对应的最小值
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    public void push(int x) {
        // 1. 先把元素插入到 A 之中
        A.push(x);
        // 2. 把当前最小值插入到 B 之中
        if (B.isEmpty()) {
            B.push(x);
            return;
        }
        // 如果 B 不为空, 当前 B 的栈顶元素就是之前的最小值
        // 之前的最小值和当前的新元素对比一下, 看看新的最小值是啥
        int min = B.peek();
        if (x < min) {
            min = x;
        }
        B.push(min);
    }

    public void pop() {
        if (A.isEmpty()) {
            return;
        }
        A.pop();
        B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int getMin() {
        return B.peek();
    }
}
