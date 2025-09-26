package Arrays.Hard;

import java.util.*;

public class MergeOverlappingSub {

    /**
     * Problem:
     * Given a collection of intervals, merge all overlapping intervals and return 
     * an array of the merged intervals.
     * 
     * Example:
     * Input:  [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Intervals [1,3] and [2,6] overlap and are merged into [1,6].
     * 
     * Approach:
     * 1. Sort the intervals by their start times.
     * 2. Initialize an empty list 'ans' to store merged intervals.
     * 3. Iterate over each interval:
     *    - If 'ans' is empty or current interval does not overlap with the last merged interval,
     *      add the current interval to 'ans'.
     *    - If there is overlap, merge the current interval with the last interval in 'ans' by 
     *      updating the end time to the maximum of both ends.
     * 4. Convert the list 'ans' back to a 2D array and return it.
     * 
     * Time Complexity:
     * - Sorting takes O(n log n), where n is the number of intervals.
     * - Merging takes O(n) as we traverse all intervals once.
     * - Overall: O(n log n)
     * 
     * Space Complexity:
     * - O(n) for the result list in the worst case (no intervals overlap).
     */
    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: List to store merged intervals
        List<int[]> ans = new ArrayList<>();

        // Step 3: Iterate over each interval
        for (int i = 0; i < intervals.length; i++) {
            // If no overlap, add interval
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(intervals[i]);
            } 
            // If overlap, merge with last interval
            else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }
        }

        // Step 4: Convert list back to array and return
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        // Example test case
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = merge(intervals);

        System.out.println("Merged intervals:");
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
