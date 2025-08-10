package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajElement {

    /**
     * Function to find all elements in the array that appear more than ⌊n/3⌋ times.
     * 
     * Intuition:
     * - We need to count how many times each element appears in the array.
     * - If an element appears more than n/3 times, it qualifies for our result list.
     * - Using a HashMap allows O(1) average time for counting each element.
     * - After counting, we iterate over the map to collect qualifying elements.
     * 
     * Time Complexity: O(n)  → One pass for counting, one pass for collecting.
     * Space Complexity: O(n) → Storing counts in the map.
     */
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores element -> frequency
        int n = nums.length;
        List<Integer> solution = new ArrayList<>();

        // Count frequency of each element
        for (int num : nums) {
            // Increment count if already present, else start with 1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Collect elements that appear more than n/3 times
        for (int key : map.keySet()) {
            if (map.get(key) > n / 3) {
                solution.add(key);
            }
        }

        return solution;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3, 2, 1, 1, 1, 2};

        MajElement obj = new MajElement(); // Create object to call non-static method
        List<Integer> result = obj.majorityElement(arr);

        System.out.print("Elements > n/3 times: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
