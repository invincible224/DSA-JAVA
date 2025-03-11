// import java.util.*;

class BubbleSort{

    static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]){
        // Bubble sort 
        // Time complexity = O(n^2)
        int arr[] = {12,10,56,34,90};

        for(int i=0;i<arr.length-1;i++){
            for(int j=0; j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }
            }
        }


        printArray(arr);
        
    }
}