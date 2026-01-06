package pattern1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextSmallerElement {
    public static int[] findNextSmaller(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            int currentNum = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] > currentNum) {
                int greaterIndex = stack.pop();
                result[greaterIndex] = currentNum;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 10, 8 };
        int[] result = findNextSmaller(arr);

        System.out.println("Array:         " + Arrays.toString(arr));
        System.out.println("Next Smaller:  " + Arrays.toString(result));
    }
}
