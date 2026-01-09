package pattern1;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseballGame {
    public static int calPoints(String[] operations) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("C")) {
                stack.pop();
            } else if (operations[i].equals("D")) {
                int num1 = 2 * stack.peek();
                stack.push(num1);
            } else if (operations[i].equals("+")) {
                int num = stack.pop();
                int peek = stack.peek();
                stack.push(num);
                stack.push(num + peek);
            } else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }
        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String[][] tests = {
                { "5", "2", "C", "D", "+" }, // 30
                { "5", "-2", "4", "C", "D", "9", "+", "+" }, // 27
                { "1" }, // 1
                { "1", "C" }, // 0 (added then removed)
                { "5", "10", "+" }, // 30 (5 + 10 + 15)
                { "10", "D", "D" }, // 70 (10 + 20 + 40)
                { "5", "10", "D", "C" }, // 15 (5 + 10, D then C cancel)
                { "-5", "-10", "+" }, // -30 (negative numbers)
        };

        int[] expected = { 30, 27, 1, 0, 30, 70, 15, -30 };

        System.out.println("Baseball Game Tests");
        System.out.println("===================");

        for (int i = 0; i < tests.length; i++) {
            int result = calPoints(tests[i]);
            String status = (result == expected[i]) ? "✓ PASS" : "✗ FAIL";
            String testStr = String.join(",", tests[i]);
            System.out.printf("Test %d: [%-28s] -> %4d (expected: %4d) %s%n",
                    i + 1, testStr, result, expected[i], status);
        }
    }
}
