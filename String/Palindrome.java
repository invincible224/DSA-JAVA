public class Palindrome {
        public boolean isPalindrome(String s) {
            // Convert the string to lowercase
            String lower = s.toLowerCase();
            
            // Remove all non-alphanumeric characters
            String str1 = lower.replaceAll("[^a-z0-9]", "");
            
            // Initialize two pointers, one at the start and one at the end
            int left = 0;
            int right = str1.length() - 1;
    
            // Compare characters from both ends moving toward the center
            while (left < right) {
                if (str1.charAt(left) != str1.charAt(right)) {
                    return false; // If characters don't match, it's not a palindrome
                }
                left++;
                right--;
            }
            
            // If we get through the loop without returning false, it's a palindrome
            return true;
        }     
}
