package pattern1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temps) {
        int[] result = new int[temps.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temps.length; i++) {
            int currentNum = temps[i];
            while (!stack.isEmpty() && temps[stack.peek()] < currentNum) {
                int largeIndex = stack.pop();
                result[largeIndex] = i - largeIndex;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temps = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = dailyTemperatures(temps);

        System.out.println("Temperatures: " + Arrays.toString(temps));
        System.out.println("Days to wait: " + Arrays.toString(result));
        // Output: [1, 1, 4, 2, 1, 1, 0, 0]

        System.out.println("\nExplanation:");
        for (int i = 0; i < temps.length; i++) {
            if (result[i] == 0) {
                System.out.println("Day " + i + " (" + temps[i] + "°): No warmer day ahead");
            } else {
                System.out.println("Day " + i + " (" + temps[i] + "°): Wait " +
                        result[i] + " day(s) for " + temps[i + result[i]] + "°");
            }
        }
    }
}
