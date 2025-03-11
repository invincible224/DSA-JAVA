 /*
        Step-by-step execution: *+ABC
        
       i        stack
       C        C
       B        CB
       A        CBA
       +        CAB+
       *        AB+C*
        
        Final result: "AB+C*"

        Trverse from back
        if operand then push onto the stack
        else push top1 + top2 + operartor
        */

import java.util.Stack;

public class PrefixToPostfix {
    static String preToPost(String pre_exp) {
        // Get the length of the prefix expression
        int n = pre_exp.length();
        
        // Create a stack to store intermediate results (sub-expressions)
        Stack<String> st = new Stack<>();
        
        // Traverse the prefix expression from right to left (reverse order)
        for (int i = n - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i); // Get the current character
            String chh = Character.toString(ch); // Convert it to a string
            
            // If the character is an operand (A-Z, a-z, or 0-9), push it onto the stack
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                st.push(chh);
            }
            // If the character is an operator, pop two operands from the stack
            else {
                String t1 = st.pop(); // Pop the first operand (get and pop)
                String t2 = st.pop(); // Pop the second operand
                
                // Form a new postfix expression by placing operands before the operator
                String s = t1 + t2 + chh;
                
                // Push the new expression back onto the stack
                st.push(s);
            }
        }
        
        // The final result (postfix expression) is at the top of the stack
        return st.peek();
    }

    public static void main(String[] args) {
        // Example input: Prefix expression
        String prefixExp = "*+ABC";
        
        // Convert prefix to postfix
        String postfixExp = preToPost(prefixExp);
        
        // Print the result
        System.out.println("Prefix Expression: " + prefixExp);
        System.out.println("Postfix Expression: " + postfixExp);
    }
}
