package Easy;

import java.util.HashMap;

/*
Problem Statement:
------------------
Given two strings s and t, determine if t is an anagram of s.
An anagram is formed by rearranging the letters of a string using all original letters exactly once.

Example:
Input: s = "listen", t = "silent"
Output: true

Intuition:
----------
- Two strings are anagrams if they have the same characters with the same frequency.
- We can count character frequencies using an array (for lowercase letters) or a HashMap (for any characters).

Approaches:
-----------

1. Brute Force:
   - Generate all permutations of s and check if t exists among them.
   - Time Complexity: O(n!) → Not feasible for large strings.
   - Space Complexity: O(n)

2. Better:
   - Sort both strings and check if sorted strings are equal.
   - Time Complexity: O(n log n)
   - Space Complexity: O(n)

3. Optimal (Counting Array):
   - Use an array of size 26 to count frequencies for lowercase letters.
   - Time Complexity: O(n)
   - Space Complexity: O(1)

4. Using HashMap:
   - Use a HashMap<Character, Integer> to store frequencies of all characters.
   - Increment for s and decrement for t.
   - If all counts are zero or map is empty at the end, strings are anagrams.
   - Time Complexity: O(n)
   - Space Complexity: O(k) where k = number of unique characters
*/

public class Anagram {

    class Solution {

        // Optimal approach for lowercase letters
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                count[t.charAt(i) - 'a']--;
            }
            for (int c : count) if (c != 0) return false;
            return true;
        }

        public boolean isAna(String s,String t){
            if(s.length()!=t.length()) return false;
            int[] count=new int[26];
            for(int i=0;i<s.length();i++){
                count[s.charAt(i)-'a']++;
                count[t.charAt(i)-'a']--;
            }
            for(int c:count) if(c!=0) return false;
            return true;
        }

        // HashMap approach for all characters
        public boolean isAnagramHashMap(String s, String t) {
            if (s.length() != t.length()) return false;

            HashMap<Character, Integer> map = new HashMap<>();

            // Count characters in s
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            // Decrement counts based on t
            for (char c : t.toCharArray()) {
                if (!map.containsKey(c)) return false;
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) map.remove(c);
            }

            // If map is empty, all counts matched
            return map.isEmpty();
        }
    }
}
