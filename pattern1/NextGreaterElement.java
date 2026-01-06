package pattern1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {
    public static int[] findNextGreater(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] < currentNum) {
                int indexOfSmaller = stack.pop();
                result[indexOfSmaller] = currentNum;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 10, 8 };
        int[] result = findNextGreater(arr);

        System.out.println("Array:        " + Arrays.toString(arr));
        System.out.println("Next Greater: " + Arrays.toString(result));

        // Detailed output
        System.out.println("\nDetailed:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " → " + (result[i] == -1 ? "none" : result[i]));
        }
    }
}
