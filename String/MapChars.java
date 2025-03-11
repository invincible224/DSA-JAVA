public class MapChars {
        public static boolean areCharsMappedConsistently(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false; // Lengths must be equal
            }
            
            // since there are total 256 ASCII characters
            int[] map1 = new int[256]; // ASCII mapping for s1 -> s2
            int[] map2 = new int[256]; // ASCII mapping for s2 -> s1
    
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
    
                // if it is not mapped with anything so we map it
                if (map1[c1] == 0 && map2[c2] == 0) {
                    map1[c1] = c2; // Store mapping
                    map2[c2] = c1; // Store reverse mapping
                } else if (map1[c1] != c2 || map2[c2] != c1) {
                    return false; // Mismatch found
                }
            }
    
            return true;
        }
    
        public static void main(String[] args) {
            System.out.println(areCharsMappedConsistently("egg", "add")); // true
            System.out.println(areCharsMappedConsistently("foo", "bar")); // false
            System.out.println(areCharsMappedConsistently("paper", "title")); // true
            System.out.println(areCharsMappedConsistently("ab", "aa")); // false
        }
    }
    
