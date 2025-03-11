// import java.util.*;

class CustomStringBuilder {
    public static void main(String args[]) {
        StringBuilder st = new StringBuilder("Vipul");
        // // st.setCharAt(1, 'Z');
        // st.insert(0, 'E');

        // System.out.println(st);

        // // Delete:  .delete(start,end(non inclusive))
        // st.delete(0,1);
        // System.out.println(st);

        // reverse the string

        for(int i=0;i<st.length()/2;i++){
            // get index of characters
            int front = i;
            int back = st.length() -1 -i;
            // get the front and back chars
            char frontChar = st.charAt(front);
            char backChar = st.charAt(back);
            // replace them
            st.setCharAt(back,frontChar);
            st.setCharAt(front,backChar);
        }
        

    }
}
