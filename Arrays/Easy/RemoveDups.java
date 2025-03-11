import java.util.ArrayList;
import java.util.List;

class removeDuplicates {
    public static void removeDuplicate(int[] nums) {
       List<Integer> list  = new ArrayList<>(); 

      int count =0;
      for(int i=0;i<nums.length;i++){
        if(i<nums.length-1 && nums[i]==nums[i+1] ){
            continue;
        }
        else{
            nums[count]=nums[i];
            list.add(nums[i]);
            count++;
        } 
      }
      System.out.println(list);
        
    } 

    public static void main(String[] args) {
        int[] arr = {3,4,4,7,7,7};
        removeDuplicate(arr);
        
    }
}

// Two pointers method first item in the array always be unique so we have to move from 2nd position then we will check if nums[1] != nums[2] if yes then we will modify the nums array by putting the nums[j]=nums[i] (with that unique element)