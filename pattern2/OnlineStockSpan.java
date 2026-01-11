import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {
    public static void main(String[] args) {
        // Test 1
        int[] prices1 = { 100, 80, 60, 70, 60, 75, 85 };
        // Expected outputs: 1, 1, 1, 2, 1, 4, 6

        // Test 2
        int[] prices2 = { 30, 20, 10 };
        // Expected outputs: 1, 1, 1

        // Test 3
        int[] prices3 = { 10, 20, 30 };
        // Expected outputs: 1, 2, 3

        // Test 4
        int[] prices4 = { 5, 5, 5, 5 };
        // Expected outputs: 1, 2, 3, 4

        testStockSpan(prices1);
        testStockSpan(prices2);
        testStockSpan(prices3);
        testStockSpan(prices4);
    }

    static void testStockSpan(int[] prices) {
        StockSpanner spanner = new StockSpanner();
        System.out.print("[");
        for (int i = 0; i < prices.length; i++) {
            int span = spanner.next(prices[i]);
            System.out.print(span + (i < prices.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}

class StockSpanner {
    Deque<int[]> stack;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            int spanCount = stack.pop()[1];
            span = span + spanCount;
        }
        stack.push(new int[] { price, span });
        return span;
    }
}