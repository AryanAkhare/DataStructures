package Hashing;
import java.util.ArrayList;
import java.util.HashMap;

public class MajElement {
    // Get all elements that appear more than n/3 times
    public static int[] majorityElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        ArrayList<Integer> solution = new ArrayList<>();

        // Count frequencies
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        // Check if frequency > n/3
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++) {
            int key = keys.get(i);
            if (map.get(key) > n / 3) {
                solution.add(key);
            }
        }

        // Convert result to int[]
        int[] result = new int[solution.size()];
        for (int i = 0; i < solution.size(); i++) {
            result[i] = solution.get(i);
        }

        return result;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3, 2, 1, 1, 1, 2};
        int[] result = majorityElement(arr);
        System.out.print("Elements > n/3 times: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
