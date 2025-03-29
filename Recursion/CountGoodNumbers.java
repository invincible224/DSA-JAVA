package Recursion;

public class CountGoodNumbers {
    class Solution {
        // Define the modulo value as a constant (10^9 + 7) to avoid overflow
        long MOD = 1_000_000_007; 
    
        /**
         * Function to count the number of good digit strings of length n.
         */
        public int countGoodNumbers(long n) {
            // Count of positions at even indices (0-based) - These positions can have 5 choices (0, 2, 4, 6, 8)
            long evenCount = (n + 1) / 2;  // Equivalent to ceil(n / 2)
    
            // Count of positions at odd indices (0-based) - These positions can have 4 choices (2, 3, 5, 7)
            long oddCount = n / 2; // Equivalent to floor(n / 2)
    
            // Compute (5^evenCount) % MOD using modular exponentiation
            long powerEven = powerMod(5, evenCount);
    
            // Compute (4^oddCount) % MOD using modular exponentiation
            long powerOdd = powerMod(4, oddCount);    
    
            // Multiply the results and take modulo to avoid overflow
            return (int) ((powerEven * powerOdd) % MOD);
        }
    
        /**
         * Function to calculate (base^exp) % MOD using Modular Exponentiation
         */
        public long powerMod(long base, long exp) {
            long ans = 1; // Initialize the result as 1
    
            while (exp > 0) { // Continue until exponent becomes 0
                if (exp % 2 == 1) { // If the exponent is odd
                    ans = (ans * base) % MOD; // Multiply ans by base and take modulo
                }
                base = (base * base) % MOD; // Square the base and take modulo
                exp = exp / 2; // Reduce exponent by half
            }
            return ans; // Return the final computed result
        }
    }
    
}
