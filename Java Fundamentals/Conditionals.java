import java.util.*;

public class Conditionals{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int choice;
        System.out.println("Enter the button:");
        choice = sc.nextInt(); 
        switch (choice){
            case 1:
                System.out.println("Hello");
                break;
            case 2:
                System.out.println("Zdravstvuyte");
                break;
            case 3:
                System.out.println("Ciao");
                break;
            default:
                System.out.println("Invalid");
        }
        sc.close();
    }
}