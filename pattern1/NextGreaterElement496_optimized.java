package pattern1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement496_optimized {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int currentNum = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= currentNum) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(currentNum, -1);
            } else {
                map.put(currentNum, stack.peek());
            }
            stack.push(currentNum);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][][] tests = {
                { { 4, 1, 2 }, { 1, 3, 4, 2 } }, // [-1, 3, -1]
                // { { 2, 4 }, { 1, 2, 3, 4 } }, // [3, -1]
                // { { 1, 3, 5, 2, 4 }, { 6, 5, 4, 3, 2, 1, 7 } }, // [7, 7, 7, 7, 7]
                // { { 4 }, { 1, 2, 3, 4 } }, // [-1]
                // { { 1 }, { 1, 2, 3, 4 } }, // [2]
                // { { 2, 1, 3 }, { 3, 2, 1 } }, // [-1, -1, -1]
                // { { 1, 2 }, { 1, 2 } }, // [2, -1]
        };

        int[][] expected = {
                { -1, 3, -1 },
                { 3, -1 },
                { 7, 7, 7, 7, 7 },
                { -1 },
                { 2 },
                { -1, -1, -1 },
                { 2, -1 }
        };

        System.out.println("Next Greater Element I Tests");
        System.out.println("============================");

        for (int i = 0; i < tests.length; i++) {
            int[] result = nextGreaterElement(tests[i][0], tests[i][1]);
            boolean pass = Arrays.equals(result, expected[i]);
            String status = pass ? "✓ PASS" : "✗ FAIL";

            System.out.printf("Test %d: nums1=%-16s nums2=%-20s%n",
                    i + 1, Arrays.toString(tests[i][0]), Arrays.toString(tests[i][1]));
            System.out.printf("        Result=%-16s Expected=%-16s %s%n%n",
                    Arrays.toString(result), Arrays.toString(expected[i]), status);
        }
    }
}
