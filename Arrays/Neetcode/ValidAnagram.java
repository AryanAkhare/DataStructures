public class ValidAnagram {
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        // one pass, increment for s and decrement for t
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // check if all counts are zero
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}


