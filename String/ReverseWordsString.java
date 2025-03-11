public class ReverseWordsString {
    class Solution {
        public String reverseWords(String s) {
            s = s.trim(); // Remove leading and trailing spaces
            String[] words = s.split("\\s+"); // Split by one or more spaces
            StringBuilder ans = new StringBuilder();
    
            // It add the entire word from the end and add  space if i>0
            for (int i = words.length - 1; i >= 0; i--) {
                ans.append(words[i]);
                if (i > 0) ans.append(" "); // Add space between words
            }
    
            return ans.toString();
        }
    }
    
}
