package Medium;

public class SumOfAllBeauty {

    // Problem:
    // Given a string s consisting of lowercase English letters,
    // the beauty of a substring is defined as:
    // (maximum frequency of any character) − (minimum frequency of any character),
    // considering only characters that appear at least once.
    // Return the sum of beauty of all possible substrings of s.

    public static int sumOfAllBeauty(String s){
        int sum = 0; // stores total beauty sum of all substrings

        // Fix the starting index of the substring
        for(int i = 0; i < s.length(); i++){
            
            // Frequency array to count characters in current substring
            int freq[] = new int[26];

            // Extend substring from index i to j
            for(int j = i; j < s.length(); j++){
                
                // Update frequency of the newly added character
                int k = s.charAt(j) - 'a';
                freq[k]++;

                // Beauty = max frequency - min non-zero frequency
                int beauty = getMax(freq) - getMin(freq);

                // Add beauty of current substring
                sum += beauty;
            }
        }
        return sum;
    }

    // Finds maximum frequency among all characters
    public static int getMax(int[] freq){
        int max = 0;
        for(int i = 0; i < 26; i++){
            max = Math.max(max, freq[i]);
        }
        return max;
    }

    // Finds minimum non-zero frequency among all characters
    public static int getMin(int[] freq){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                min = Math.min(min, freq[i]);
            }
        }
        return min;
    }
}
