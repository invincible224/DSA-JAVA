public class RansomNote {

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Create an integer array of size 26 to store the frequency of each letter (a-z).
        int[] charCount = new int[26]; 
        
        // Iterate over each character in the 'magazine' string
        // and count its occurrences in the charCount array.
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++; // Convert character to array index (0-25) and increment its count.
        }

        // Iterate over each character in the 'ransomNote' string.
        for (char c : ransomNote.toCharArray()) {
            // If the required character is not available in 'charCount', return false.
            if (charCount[c - 'a'] == 0) {
                return false; 
            }
            // Decrease the count of the character in 'charCount' since it is being used.
            charCount[c - 'a']--; 
        }

        // If we successfully check all characters in 'ransomNote', return true.
        return true;
    }
}

}
