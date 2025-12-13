package Easy;
import java.util.HashMap;


/*
Problem: Isomorphic Strings

Two strings s and t are isomorphic if the characters in s can be replaced to get t, 
while preserving the order of characters. Each character must map to exactly one character, 
and no two characters may map to the same character.

Example:
s = "egg", t = "add" → true
s = "foo", t = "bar" → false
s = "paper", t = "title" → true

Constraints:
- 1 <= s.length, t.length <= 5 * 10^4
- s and t consist of any valid ASCII characters
*/

public class IsIsomorphic {

    class Solution {
        public boolean areIsomorphic(String s, String t) {
            // Step 0: Problem check
            // Two strings are isomorphic if characters in s can map to t uniquely
            // preserving the order, and no two characters map to the same char
            if (s.length() != t.length()) return false;

            // Step 1: Create maps for forward and backward mapping
            HashMap<Character, Character> sToT = new HashMap<>(); // s -> t
            HashMap<Character, Character> tToS = new HashMap<>(); // t -> s

            // Step 2: Traverse both strings together
            for (int i = 0; i < s.length(); i++) {
                char charS = s.charAt(i); // current char in s
                char charT = t.charAt(i); // current char in t

                // Step 3: Check if mapping conflicts
                // If s->t mapping exists but not equal to current t char OR
                // If t->s mapping exists but not equal to current s char
                if ((sToT.containsKey(charS) && sToT.get(charS) != charT) ||
                    (tToS.containsKey(charT) && tToS.get(charT) != charS)) {
                    return false; // conflict found → not isomorphic
                }

                // Step 4: Add/update mappings
                sToT.put(charS, charT);
                tToS.put(charT, charS);
            }

            // Step 5: All characters mapped without conflict → strings are isomorphic
            return true;
        }
    }
}
