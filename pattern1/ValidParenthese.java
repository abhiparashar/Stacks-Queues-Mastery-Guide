package pattern1;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthese {
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(')
                    return false;
                if (c == '}' && top != '{')
                    return false;
                if (c == ']' && top != '[')
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
                "()", // true - simple match
                "()[]{}", // true - multiple types
                "(]", // false - mismatch
                "([)]", // false - wrong order
                "{[]}", // true - nested
                "", // true - empty string
                "[", // false - unclosed
                "]", // false - no opening
                "((()))", // true - deeply nested
                "{[()()]}" // true - complex nested
        };

        boolean[] expected = { true, true, false, false, true, true, false, false, true, true };

        for (int i = 0; i < tests.length; i++) {
            boolean result = isValid(tests[i]);
            String status = (result == expected[i]) ? "✓ PASS" : "✗ FAIL";
            System.out.printf("Test %2d: %-12s -> %-5b (expected: %-5b) %s%n",
                    i + 1, "\"" + tests[i] + "\"", result, expected[i], status);
        }
    }
}
