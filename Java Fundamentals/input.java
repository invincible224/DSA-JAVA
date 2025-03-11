import java.util.*;

public class input {
    public static void main(String[] args) {
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name :");
        name = sc.next();

        System.out.println("Your name is : "+name);
        
        sc.close();

    }
}
