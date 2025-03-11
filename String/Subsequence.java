public class Subsequence {
        public boolean isSubsequence(String s, String t) {
            if (s.isEmpty()) {  // Edge case: an empty string is always a subsequence
                return true;
            }
    
            int ptr1 = 0;  // Pointer for string s
            int ptr2 = 0;  // Pointer for string t
    
            int str1 = s.length();  // Length of string s
            int str2 = t.length();  // Length of string t
    
            while (ptr1 < str1 && ptr2 < str2) {
                if (s.charAt(ptr1) == t.charAt(ptr2)) {
                    ptr1++;  // Move pointer in s
                }
                ptr2++;  // Move pointer in t
    
                if (ptr1 == str1) {
                    return true;
                }
            }
    
            return false;
        }
    }
    
