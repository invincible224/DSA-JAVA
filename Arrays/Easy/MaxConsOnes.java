public class MaxConsOnes {
        public int findMaxConsecutiveOnes(int[] nums) {
            int maxCount =0;
            int currCount =0;
    
            for(int num:nums){
                if(num==1){
                    currCount+=1;
                }
                else{
                    currCount=0;
                }
                maxCount = Math.max(maxCount,currCount);
            }
            return maxCount;
        }
}
