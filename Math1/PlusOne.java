package Math1;
// Add one to the num: [1,2,3] => [1,2,4]    [9] => [1,0];

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        // If we're here, it means every digit was 9 (e.g., 999)
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
