package pattern1;

import java.util.ArrayDeque;
import java.util.Deque;

class BasicStackOperations {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);

        int top = stack.peek();
        System.out.println(top);

        int popped = stack.pop();
        System.out.println(popped);

        System.out.println(stack.isEmpty());

        System.out.println(stack.size());
    }
}