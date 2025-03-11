// if an operand is found pick last two elements from the stack (top) and place the sign in between them

/*input: ab+c*     

 i          stack
 a            a
 b            b
 +           (a+b)
 c           (a+b),c
 *           ((a+b) * c)
 
 */
import java.util.Stack;

public class PostfixToInfix {
    // User function Template for Java

    class Solution {

        static String postToInfix(String exp) {
            int i = 0; // Index to traverse the postfix expression
            Stack<String> st = new Stack<>(); // Stack to store operands and expressions
            int n = exp.length(); // Length of the input expression

            while (i < n) { // Iterating through the postfix expression
                char ch = exp.charAt(i); // Extracting the current character

                // Check if the character is an operand (letter or digit)
                if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                    st.push(Character.toString(ch)); // Push operand as a string onto the stack
                } else { // If the character is an operator (+, -, *, /, etc.)
                    // Popping two operands from the stack
                    String t1 = st.pop(); // First operand (right-hand side)
                    String t2 = st.pop(); // Second operand (left-hand side)

                    // Creating an infix expression with parentheses
                    String s = '(' + t2 + ch + t1 + ')';

                    // Pushing the newly formed expression back onto the stack
                    st.push(s);
                }
                i++; // Move to the next character in the postfix expression
            }

            return st.peek(); // The final expression at the top of the stack is the result
        }
    }

}
