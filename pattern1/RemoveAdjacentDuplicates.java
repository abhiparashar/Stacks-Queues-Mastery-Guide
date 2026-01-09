package pattern1;

public class RemoveAdjacentDuplicates {
    public static String removeDuplicates(String str) {
        if (str.length() == 0) {
            return "";
        }
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int len = stack.length();
            if (len > 0) {
                if (stack.charAt(len - 1) == ch) {
                    stack.deleteCharAt(len - 1);
                } else {
                    stack.append(ch);
                }
            } else
                stack.append(ch);
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        String[] tests = {
                "abbaca", // "ca"
                "azxxzy", // "ay" (xx removed -> azzy -> zz removed -> ay)
                "aaaaaaaaa", // "a" (odd count remains)
                "aab", // "b"
                "aba", // "aba" (no adjacent duplicates)
                "", // ""
                "a", // "a"
                "aa", // ""
                "abba", // "" (bb -> aa -> empty)
                "abccba", // "" (cc -> abba -> bb -> aa -> empty)
        };

        String[] expected = { "ca", "ay", "a", "b", "aba", "", "a", "", "", "" };

        System.out.println("Remove All Adjacent Duplicates Tests");
        System.out.println("====================================");

        for (int i = 0; i < tests.length; i++) {
            String result = removeDuplicates(tests[i]);
            String status = result.equals(expected[i]) ? "✓ PASS" : "✗ FAIL";
            System.out.printf("Test %2d: %-14s -> %-6s (expected: %-6s) %s%n",
                    i + 1, "\"" + tests[i] + "\"", "\"" + result + "\"", "\"" + expected[i] + "\"", status);
        }
    }
}
