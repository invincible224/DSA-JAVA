package Stack;
import java.util.ArrayDeque;
import java.util.Deque;

// most prefered way to do the job
public class StackEffi {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>(); // Better choice

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop()); // Output: 30
        System.out.println(stack.peek()); // Output: 20
    }
}


