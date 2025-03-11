package Stack;

/*
 String pre_exp = "*+AB-CD";
 
    i          stack
    D           D
    C           C
    -           (C-D)
    B           (C-D),B
    A           (C-D),B,A
    +           (C-D),(A+B)
    *           ((C-D)*(A+B))

 */

import java.util.Stack;
public class PrefixToInfix {
    // Importing the Stack class from the Java utility package

    
    // Function to convert a prefix expression to an infix expression
    static String preToInfix(String pre_exp) {
        
        // Get the length of the prefix expression
        int n = pre_exp.length();
        
        // Create a stack to store intermediate expressions
        Stack<String> st = new Stack<>();
        
        // Iterate over the prefix expression from right to left
        for (int i = n - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i); // Get the current character
            
            // If the character is an operand (A-Z, a-z, 0-9), push it to the stack
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9')) {
                st.push(Character.toString(ch));
            } 
            else { 
                // If the character is an operator (+, -, *, /, etc.)
                
                // Pop two operands from the stack
                String t1 = st.pop();
                String t2 = st.pop();
                
                // Convert the character to a string
                String chh = Character.toString(ch);
                
                // Form the infix expression by surrounding it with parentheses
                String s = '(' + t1 + chh + t2 + ')';
                
                // Push the newly formed infix expression back into the stack
                st.push(s);
            }
        }
        
        // The final infix expression is on top of the stack
        return st.peek();
    }
}

