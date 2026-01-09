package pattern1;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String str1, String str2) {
        return processString(str1).equals(processString(str2));
    }

    private static String processString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[][] tests = {
                { "ab#c", "ad#c" }, // true (both = "ac")
                { "ab##", "c#d#" }, // true (both = "")
                { "a#c", "b" }, // false ("c" vs "b")
                { "a##c", "#a#c" }, // true (both = "c")
                { "", "" }, // true (both empty)
                { "a", "a" }, // true
                { "a", "b" }, // false
                { "###", "###" }, // true (both = "")
                { "abc###", "" }, // true (both = "")
                { "abc###d", "d" }, // true (both = "d")
        };

        boolean[] expected = { true, true, false, true, true, true, false, true, true, true };

        System.out.println("Backspace String Compare Tests");
        System.out.println("==============================");

        for (int i = 0; i < tests.length; i++) {
            boolean result = backspaceCompare(tests[i][0], tests[i][1]);
            String status = (result == expected[i]) ? "✓ PASS" : "✗ FAIL";
            System.out.printf("Test %2d: s=%-8s t=%-8s -> %-5b (expected: %-5b) %s%n",
                    i + 1, "\"" + tests[i][0] + "\"", "\"" + tests[i][1] + "\"",
                    result, expected[i], status);
        }
    }
}
