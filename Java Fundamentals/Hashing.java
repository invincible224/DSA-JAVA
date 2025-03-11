
import java.util.*;
public class Hashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n;
        System.out.println("size of the array:");
        n= sc.nextInt();

        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            int num;
            System.out.println("number");
            num=sc.nextInt();
            arr[i]=num;
        }

        int hashArr[] = new int[n+1];
        for(int j=0;j<n;j++){
            hashArr[arr[j]] +=1;
        }

        int q;
        System.out.println("enter quries num:");
        q=sc.nextInt();

        while(q!=0) {
            int num;
            System.out.println("enter  num:");
            num = sc.nextInt();
            System.out.println(num + " appears "+hashArr[num]);
            q--;
         }
        

    }
}

