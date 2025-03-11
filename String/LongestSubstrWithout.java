// Given a string s, find the length of the longest substring without repeating characters.
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

import java.util.HashSet;

public class LongestSubstrWithout {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                HashSet<Character> set = new HashSet<>();
                int len = 0;

                for (int j = i; j < s.length(); j++) {
                    char ch = s.charAt(j);

                    // If character is already in the set, break the loop
                    if (set.contains(ch)) {
                        break;
                    }

                    set.add(ch);
                    len++;
                    maxLen = Math.max(maxLen, len);
                }
            }
            return maxLen;
        }
    }

}

// Optimal solution
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));  // Remove leftmost character
                left++;  // Shrink window
            }
            set.add(s.charAt(right));  // Add new character
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

