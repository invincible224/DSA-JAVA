

public class PascalTriangle {
    
    // for finding number at specific position in the triangle
    // formula for this is : nCr => where  n-1Cr-1 = n!/ r! * (n-r)!
    // we modifies it bit => n=10 r=3 then since (n-r)! will cancel the next terms of n! 
    // ex: (10*9*8*[7*6*5*4*3*2*1]) / (3*2*1) * (7*6*5*4*3*2*1)
    // the observation says the no. of r is the same number n will go up to ie 3 in above case
    // but while dividing we do 10/1 * 9/2 *8/3
    public int findNum(int n,int r){
        int res = 1;

        for(int i=0;i<r;i++){
            res = res*(n-i);
            res = res/(i+1);
        }
        return res;
    }


      // for printing given row
    //   int ans = 1;
    //   for(int =0;i<n;i++){
    //       ans = ans * (n-i);
    //       ans = ans / i;
    //       System.out.print(ans);
    //   }
   
}
