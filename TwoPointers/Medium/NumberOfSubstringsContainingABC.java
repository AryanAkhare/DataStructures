public class NumberOfSubstringsContainingABC {

    // =========================
    // 1. BRUTE FORCE - O(n^2)
    // =========================
    public static int brute(String s) {

        // Intuition:
        // Generate all substrings and check if they contain a, b, c

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            int[] hash = new int[3]; // tracks presence of a,b,c

            for (int j = i; j < s.length(); j++) {

                // mark current char
                hash[s.charAt(j) - 'a'] = 1;

                // if all 3 present → valid substring
                if (hash[0] + hash[1] + hash[2] == 3) {
                    count++;
                }
            }
        }

        return count;
    }

    // TC: O(n^2)
    // SC: O(1)



    // =========================
    // 2. BETTER - SLIDING WINDOW (O(n))
    // =========================
    public static int better(String s) {

        // Intuition:
        // Expand right pointer.
        // Once window has all a,b,c → shrink from left
        // and count valid substrings.

        int[] freq = new int[3];
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {

            // include current char
            freq[s.charAt(right) - 'a']++;

            // while window contains all 3 chars
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                // all substrings from right to end are valid
                count += s.length() - right;

                // shrink window
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }

    // TC: O(n)
    // SC: O(1)



    // =========================
    // 3. OPTIMAL - LAST SEEN (O(n))
    // =========================
    public static int optimal(String s) {

        // Intuition:
        // Track last seen index of a, b, c
        // At each index, find the minimum of last seen positions
        // → gives how many valid substrings end here

        int[] lastSeen = {-1, -1, -1};
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // update last seen index
            lastSeen[s.charAt(i) - 'a'] = i;

            // if all characters seen at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {

                int minIndex = Math.min(lastSeen[0],
                               Math.min(lastSeen[1], lastSeen[2]));

                // count substrings ending at i
                count += 1 + minIndex;
            }
        }

        return count;
    }

    // TC: O(n)
    // SC: O(1)



    // =========================
    // MAIN (for testing)
    // =========================
    public static void main(String[] args) {

        String s = "aaabc";

        System.out.println("Brute: " + brute(s));
        System.out.println("Better: " + better(s));
        System.out.println("Optimal: " + optimal(s));
    }
}