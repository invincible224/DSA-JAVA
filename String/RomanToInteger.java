public class RomanToInteger {
    // Why prev = 0?
    // When we process the rightmost character (the last numeral in the original string), there is no previous numeral yet.
    // By setting prev = 0, the condition curr < prev (subtraction condition) never applies to the first numeral, ensuring it is always added.
    class Solution {
        public int romanToInt(String s) {
            int num = 0;
            int prev = 0; // Keeps track of the previous numeral value

            for (int i = s.length() - 1; i >= 0; i--) {
                int curr = getValue(s.charAt(i));

                if (curr < prev) {
                    num -= curr; // Subtract if smaller than the previous value
                } else {
                    num += curr; // Otherwise, add
                }

                prev = curr; // Update previous numeral value
            }

            return num;
        }

        private int getValue(char ch) {
            return switch (ch) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0; // Invalid character case
            };
        }
    }

}
