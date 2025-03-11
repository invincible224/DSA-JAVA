public class StringToInteger {
        public int myAtoi(String s) {
            // Step 1: Ignore leading whitespaces
            int i = 0, n = s.length();
            while (i < n && s.charAt(i) == ' ') {
                i++;  // Skip spaces
            }
    
            // Step 2: Handle optional '+' or '-' sign
            int sign = 1;  // Default is positive
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                sign = (s.charAt(i) == '-') ? -1 : 1;
                i++;  // Move to next character after the sign
            }
    
            // Step 3: Convert digits to integer
            int result = 0;
            while (i < n && Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i) - '0'; // Convert character to integer
    
                /**
                 * Why subtract '0'?
                 *  - Each character (e.g., '3') has an ASCII value.
                 *  - '0' has an ASCII value of 48.
                 *  - '3' has an ASCII value of 51.
                 *  - So, '3' - '0' = 51 - 48 = 3 (correct integer value).
                 */
    
                // Step 4: Handle integer overflow
                if (result > (Integer.MAX_VALUE - digit) / 10) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
    
                // Accumulate result
                result = result * 10 + digit; // Shift previous result left by 1 place (multiply by 10) and add new digit
                i++; // Move to next character
            }
    
            // Step 5: Apply sign and return result
            return result * sign;
        }
    
    }
    

