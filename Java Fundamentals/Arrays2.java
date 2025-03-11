import java.util.*;

class Arrays2{
    public static void main(String args[]){
        // int[][] myArray = new myArray[3][3]; 
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] array = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0; j<cols;j++){
                System.out.println("Enter the element:");
                array[i][j] = sc.nextInt();
            }
        }

        System.out.println("Elements:");
         for(int i=0;i<rows;i++){
            for(int j=0; j<cols;j++){
                System.out.print(" "+ array[i][j]);
            }
            System.out.println();
        }
        sc.close();

    }
}