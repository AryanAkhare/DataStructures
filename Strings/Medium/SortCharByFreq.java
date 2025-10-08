package Medium;
import java.util.*;  // Importing HashMap, ArrayList, Map, List, etc.

public class SortCharByFreq {

    /**
     * Method to sort characters in a string by their frequency in descending order.
     * Uses Bucket Sort technique for optimal performance.
     * 
     * @param s Input string
     * @return String with characters sorted by frequency
     */
    public String frequencySort(String s) {
        
        // ---------------- Step 1: Count frequency of each character ----------------
        Map<Character, Integer> mp = new HashMap<>();
        for (char c : s.toCharArray()) {
            // getOrDefault(c, 0) returns current count or 0 if character is not yet in map
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        // At this point, mp contains: key = character, value = frequency
        // Example: "tree" → mp = {t=1, r=1, e=2}

        // ---------------- Step 2: Create buckets ----------------
        // Each index represents frequency; each bucket[index] contains characters with that frequency
        // Maximum possible frequency = length of the string
        List<Character>[] buckets = new ArrayList[s.length() + 1];

        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            int freq = entry.getValue();   // frequency of the character
            char c = entry.getKey();       // the character itself

            // Initialize the bucket if it's null
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            // Add character to the corresponding frequency bucket
            buckets[freq].add(c);
        }
        // Example for "tree":
        // buckets[1] = ['t','r']
        // buckets[2] = ['e']

        // ---------------- Step 3: Build result string from high to low frequency ----------------
        StringBuilder sb = new StringBuilder();

        // Iterate from highest frequency to lowest (bucket.length-1 to 0)
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {           // Only process non-empty buckets
                for (char c : buckets[i]) {     // For each character in the bucket
                    for (int j = 0; j < i; j++) { // Append character 'i' times (its frequency)
                        sb.append(c);
                    }
                }
            }
        }
        // Example "tree":
        // i=2 → append 'e' 2 times → sb = "ee"
        // i=1 → append 't' 1 time → sb = "eet"
        // i=1 → append 'r' 1 time → sb = "eetr"

        return sb.toString();  // Return the final string
    }

    /*
     * Time Complexity:
     * Step 1: O(n) → counting frequencies in HashMap
     * Step 2: O(k) → creating buckets, where k = number of unique characters ≤ 26 for lowercase letters
     * Step 3: O(n) → building result string from buckets
     * Overall: O(n)
     *
     * Space Complexity:
     * - HashMap: O(k), k = number of unique characters
     * - Buckets array: O(n) (maximum n lists, each storing characters)
     * - StringBuilder: O(n)
     * Total: O(n + k) ≈ O(n)
     */
}
