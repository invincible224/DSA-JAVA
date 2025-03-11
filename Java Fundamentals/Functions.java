import java.util.*;

class Functions{

    public static void printMyName(String name){
        System.out.println("Your name is "+name);
        return;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println("Enter name:");
        name = sc.nextLine();

        printMyName(name);
        sc.close();
    }
}