import java.util.ArrayDeque;
import java.util.Deque;

public class DiscountedPrice1475 {
    public static int[] finalPrices(int[] prices) {
        int[] ans = prices.clone();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            int currentNum = prices[i];
            while (!stack.isEmpty() && prices[stack.peek()] >= currentNum) {
                int idx = stack.pop();
                ans[idx] = prices[idx] - currentNum;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard case
        int[] prices1 = { 8, 4, 6, 2, 3 };
        // Expected: [4, 2, 4, 2, 3]
        printResult("Test 1", prices1);

        // Test Case 2: Decreasing prices (each gets discount from next)
        int[] prices2 = { 10, 5, 3, 1 };
        // Expected: [5, 2, 2, 1]
        printResult("Test 2", prices2);

        // Test Case 3: Increasing prices (no discounts)
        int[] prices3 = { 1, 2, 3, 4 };
        // Expected: [1, 2, 3, 4]
        printResult("Test 3", prices3);

        // Test Case 4: All same prices
        int[] prices4 = { 5, 5, 5, 5 };
        // Expected: [0, 0, 0, 5]
        printResult("Test 4", prices4);

        // Test Case 5: Single element
        int[] prices5 = { 10 };
        // Expected: [10]
        printResult("Test 5", prices5);
    }

    static void printResult(String testName, int[] prices) {
        System.out.print(testName + ": Input = ");
        printArray(prices);

        int[] result = finalPrices(prices.clone());

        System.out.print("         Output = ");
        printArray(result);
        System.out.println();
    }

    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
