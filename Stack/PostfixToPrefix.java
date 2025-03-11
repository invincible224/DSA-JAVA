/*
 input: AB+C*

 i      stack
 A       A
 B       AB
 +       +AB
 C       +AB,C
 *       *+ABC
 
 traverse from start
 if operand push onto the stack
 else take top two and place the sign before them
 */

import java.util.Stack;

public class PostfixToPrefix {

    class Solution {

        static String postToPre(String post_exp) {
            // Get the length of the postfix expression
            int n = post_exp.length();

            // Create a stack to store intermediate results (sub-expressions)
            Stack<String> st = new Stack<>();

            // Iterate through each character in the postfix expression
            for (int i = 0; i < n; i++) {
                char ch = post_exp.charAt(i); // Get the current character
                String chh = Character.toString(ch); // Convert the character to a string

                // If the character is an operand (A-Z, a-z, or 0-9), push it onto the stack
                if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                    st.push(chh);
                } // If the character is an operator, pop two operands from the stack
                else {
                    String t1 = st.pop(); // Pop the first operand
                    String t2 = st.pop(); // Pop the second operand

                    // Form a new prefix expression by placing the operator before the operands
                    String s = chh + t2 + t1;

                    // Push the new expression back onto the stack
                    st.push(s);
                }
            }

            // The final result (prefix expression) is at the top of the stack
            return st.peek();
        }
    }

}
