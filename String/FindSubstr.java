public class FindSubstr {
        public static int strStr(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();
    
            for (int i = 0; i <= n - m; i++) {
                if (haystack.substring(i, i + m).equals(needle)) {
                    return i; // Found the first occurrence
                }
            }
            return -1; // Not found
        }
    
        public static void main(String[] args) {
            String haystack = "sadbutsad";
            String needle = "sad";
            System.out.println(strStr(haystack, needle)); // Output: 0
        }
    }
    

