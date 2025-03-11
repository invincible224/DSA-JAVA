package Math1;

public class IntegerPalindrome {
    /*  Extract the last digit:
     * remainder = x % 10 (e.g., if x = 123, then remainder = 3).
     * Build the reversed number:
     * rev = rev * 10 + remainder (e.g., rev = 0 * 10 + 3 = 3).
     * Remove the last digit:
     * x = x / 10 (e.g., x = 123 / 10 = 12).
     */
        public boolean isPalindrome(int x) {
            int rev = 0;
            int temp = x;  // to store original number
    
            if (x < 0) {
                return false;
            }
    
            while (x != 0) {
                int remainder = x % 10;   // extract the last digit
                rev = rev * 10 + remainder; // add it to the rev number
                x = x / 10;  // cut the last digit from the num
            }
    
            return temp == rev;
        }
    }
    

