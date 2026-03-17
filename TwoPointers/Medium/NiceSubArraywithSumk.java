public class NiceSubArraywithSumk {

    // ===================== BRUTE FORCE =====================
    // Intuition:
    // Generate all subarrays and count odds in each.
    // If odds == k → increment count.

    // TC: O(n^2)
    // SC: O(1)
    public int brute(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int odd = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 1) odd++;
                if (odd == k) count++;
            }
        }
        return count;
    }


    // ===================== BETTER (Prefix Sum + HashMap) =====================
    // Intuition:
    // Convert array → 1 if odd, 0 if even
    // Now problem becomes: count subarrays with sum = k
    // Use prefix sum + hashmap (same as subarray sum equals k)

    // TC: O(n)
    // SC: O(n)
    public int better(int[] nums, int k) {
        int count = 0;
        int prefix = 0;

        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            if (num % 2 == 1) prefix++;

            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }


    // ===================== OPTIMAL (Sliding Window) =====================
    // Intuition:
    // Count subarrays with at most k odds
    // Answer = atMost(k) - atMost(k - 1)

    // TC: O(n)
    // SC: O(1)
    public int optimal(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int l = 0, count = 0, odd = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % 2 == 1) odd++;

            while (odd > k) {
                if (nums[l] % 2 == 1) odd--;
                l++;
            }

            count += (r - l + 1);
        }

        return count;
    }


    // ===================== MAIN (for testing) =====================
    public static void main(String[] args) {
        NiceSubArraywithSumk obj = new NiceSubArraywithSumk();

        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;

        System.out.println("Brute: " + obj.brute(nums, k));
        System.out.println("Better: " + obj.better(nums, k));
        System.out.println("Optimal: " + obj.optimal(nums, k));
    }
}