import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            int currentNum = nums[idx];
            while (!stack.isEmpty() && nums[stack.peek()] < currentNum) {
                int index = stack.pop();
                result[index] = currentNum;
            }
            if (i < n)
                stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = { 1, 2, 1 }; // Expected: [2, -1, 2]
        int[] test2 = { 1, 2, 3, 4, 3 }; // Expected: [2, 3, 4, -1, 4]
        int[] test3 = { 5, 4, 3, 2, 1 }; // Expected: [-1, 5, 5, 5, 5]
        int[] test4 = { 1, 1, 1, 1 }; // Expected: [-1, -1, -1, -1]
        int[] test5 = { 100 }; // Expected: [-1]

        print(nextGreaterElements(test1));
        print(nextGreaterElements(test2));
        print(nextGreaterElements(test3));
        print(nextGreaterElements(test4));
        print(nextGreaterElements(test5));
    }

    static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
