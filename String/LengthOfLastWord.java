// Example 1:
/* 
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4. */

public class LengthOfLastWord {

        public int lengthOfLastWord(String s) {
            s = s.trim(); //remove spaces from the first and last (not from words)
            int ans = 0;
            for(int i=s.length()-1;i>= 0;i--){
                if(s.charAt(i) == ' '){
                    break;
                }
                ans++;
            }
            return ans;
        }
    }
