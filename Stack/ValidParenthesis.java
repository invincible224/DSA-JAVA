package Stack;

import java.util.Stack;

class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is an opening bracket, push it to the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                // If stack is empty but we get a closing bracket, it's invalid
                if (st.isEmpty()) {
                    return false;
                }

                // Pop and check if it matches the correct opening bracket
                char top = st.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty at the end, brackets were valid
        return st.isEmpty();
    }
}
