import java.util.*;

class Arrays{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("Enter the size of the array:");
        size = sc.nextInt();

        int marks[] = new int[size];

        for(int i=0; i<size;i++){
            System.out.println("Enter the marks of the student : "+(i+1));
            marks[i] = sc.nextInt();
        }

        for(int j=0; j<size;j++){
            System.out.println("Marks of student "+(j+1) + " is "+ marks[j]);
        }

        // Another way to write an array
        // int nums[] = {12,45,78,90};

        sc.close();
    }
}