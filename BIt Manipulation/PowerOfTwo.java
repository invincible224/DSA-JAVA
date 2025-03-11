public class PowerOfTwo {
    // Brute force
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;

        for (int i = 0; Math.pow(2, i) <= n; i++) {
            if (n == Math.pow(2, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean PowerOfT(int n) {

        // if both are true then it will return the true else false
        // for 16: (10000)
        //  (1 0 0 0 0 ) & ( 0 1 1 1 1 ) == 0
        // since power of two only have one set binary
        // if we flip the bits of it and compare it it will give zero 
        
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
