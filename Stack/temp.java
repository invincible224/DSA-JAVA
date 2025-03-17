
import java.util.Stack;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class Solution{
    public int[] prevSmaller(int[] A) {
        Stack st = new Stack();
        int[] ans = new int[A.length];
        
        for(int i=0;i<A.length;i++){
            while(!st.isEmpty() && st.peek()< A[i]){
                int x = st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = x;
            }
            else{
                ans[i] = -1;
            }
            
            st.push(A[i]);
        }
        return ans;
    }
}
public class temp {
    

   public static void main(String[] args) {
    Solution solution = new Solution();
    
    // Example custom input
    int[] A = {4, 5, 2, 10, 8};
    
    // Call your function
    int[] result = solution.prevSmaller(A);
    
    // Print the result
    System.out.print("Input:  ");
    for (int num : A) {
        System.out.print(num + " ");
    }
    System.out.println();
    
    System.out.print("Output: ");
    for (int num : result) {
        System.out.print(num + " ");
    }
    System.out.println();
}
}