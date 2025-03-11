
import java.util.Stack;

public class InfixToPostfix {

    class Solution {
        // Function to convert an infix expression to a postfix expression.

        public static String infixToPostfix(String s) {
            Stack<Character> st = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int n = s.length();

            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);

                // If the character is an operand (A-Z, a-z, 0-9)
                if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                    sb.append(ch);
                } // If the character is an opening parenthesis
                else if (ch == '(') {
                    st.push(ch);
                } // If the character is a closing parenthesis
                else if (ch == ')') {
                    while (!st.isEmpty() && st.peek() != '(') {
                        sb.append(st.pop());
                    }
                    st.pop(); // Remove '(' from stack
                } // If the character is an operator
                else {
                    while (!st.isEmpty() && priority(ch) <= priority(st.peek())) {
                        sb.append(st.pop());
                    }
                    st.push(ch);
                }
            }

            // Pop remaining operators from the stack
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }

            return sb.toString();
        }

        // Function to define operator precedence
        public static int priority(char ch) {
            switch (ch) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '^':
                    return 3;
            }
            return -1;
        }
    }

}
