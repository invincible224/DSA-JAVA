public class RotationString {
    class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) {
                return false;
            }
            // ANy string concatenated contains the rotation of itself
            // ex  s = "abcde" - goal = "bcdea" 
            // "abcdeabcde" -> this contains "bcdea"
            String doubledS = s + s;
            return doubledS.contains(goal);
        }
    }
}
