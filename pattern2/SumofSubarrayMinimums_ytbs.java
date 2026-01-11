import java.util.ArrayList;
import java.util.List;

public class SumofSubarrayMinimums_ytbs {
    public static int sumSubarrayMins(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                List<Integer> subarray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subarray.add(arr[k]);
                }
                list.add(subarray);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] test1 = { 3, 1, 2, 4 }; // Expected: 17
        int[] test2 = { 11, 81, 94, 43, 3 }; // Expected: 444
        int[] test3 = { 1, 1, 1 }; // Expected: 6
        int[] test4 = { 5 }; // Expected: 5
        int[] test5 = { 1, 2, 3 }; // Expected: 10

        System.out.println(sumSubarrayMins(test1));
        System.out.println(sumSubarrayMins(test2));
        System.out.println(sumSubarrayMins(test3));
        System.out.println(sumSubarrayMins(test4));
        System.out.println(sumSubarrayMins(test5));
    }
}
