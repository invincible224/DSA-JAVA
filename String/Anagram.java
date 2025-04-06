import java.util.HashMap;

public class Anagram {


    // ____________Optimal____________
    class Solution1 {
        public boolean isAnagram(String s, String t) {
            
            // Step 1: Length check
            if (s.length() != t.length()) {
                return false;
            }
    
            // Step 2: Create array of size 26 for a-z characters
            int[] freq = new int[26];
    
            // Step 3: Increase frequency for s and decrease for t
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;  // Count for s
                freq[t.charAt(i) - 'a']--;  // Reduce for t
            }
    
            // Step 4: Check if all counts are zero
            for (int count : freq) {
                if (count != 0) {
                    return false;  // Mismatch found
                }
            }
    
            return true;  // All matched
        }
    }
    
    class Solution {

        // Function to check whether two strings are anagrams or not
        public boolean isAnagram(String s, String t) {

            // Step 1: If lengths of both strings are not equal → they can't be anagrams
            if (s.length() != t.length()) {
                return false;
            }

            // Step 2: Create a HashMap to store frequency of characters of string 's'
            HashMap<Character, Integer> map = new HashMap<>();

            // Step 3: Traverse string 's' and count frequency of each character
            for (char ch : s.toCharArray()) {

                // If character already exists in map → increase its frequency by 1
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                }
                // If character does not exist → add it with frequency 1
                else {
                    map.put(ch, 1);
                }
            }

            // Step 4: Traverse string 't' and check with the map
            for (int i = 0; i < t.length(); i++) {

                char ch = t.charAt(i); // get character from string 't'

                // If character exists in map and its frequency is >= 1
                if (map.containsKey(ch) && map.get(ch) >= 1) {

                    // Decrease frequency by 1 (since we found a matching character)
                    map.put(ch, map.get(ch) - 1);
                }
                // If character does not exist or frequency is already 0 → Not Anagram
                else {
                    return false;
                }
            }

            // Step 5: If all conditions passed → Strings are Anagrams
            return true;
        }
    }

}
