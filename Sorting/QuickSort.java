package Sorting;

//{ Driver Code Starts
import java.io.*;

class QuickSort {
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().quickSort(arr, 0, n - 1);
            printArray(arr);
        }
    }
}
//driver code ends


//Main Solution
class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        // code here
        if(low<high){
          int  loc = partition(arr,low,high);
          quickSort(arr,low,loc-1);
          quickSort(arr,loc+1,high);
          
        }
    }

    static int partition(int arr[], int low, int high) {
        // your code here
        
        int pivot = arr[low];
        int start = low+1;
        int end = high;
        
         while (start <= end) {
           
            while (start <= end && arr[start] <= pivot) {
                start++;
            }
           
            while (start <= end && arr[end] > pivot) {
                end--;
            }
        
            if (start < end) {
                swap(arr, start, end);
            }
        }
        
        swap(arr, low, end);
        return end; 
    }
    
    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
