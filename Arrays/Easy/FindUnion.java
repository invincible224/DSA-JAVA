import java.util.ArrayList;

public class FindUnion {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        
        // Traverse both arrays
        while (i < a.length && j < b.length) {
            // Skip duplicates in first array
            if (i > 0 && a[i] == a[i-1]) {
                i++;
                continue;
            }
            
            // Skip duplicates in second array
            if (j > 0 && b[j] == b[j-1]) {
                j++;
                continue;
            }
            
            // Compare and add elements
            if (a[i] < b[j]) {
                union.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                union.add(b[j]);
                j++;
            } else {
                // Elements are equal
                union.add(a[i]);
                i++;
                j++;
            }
        }
        
        // Add remaining elements from first array
        while (i < a.length) {
            if (union.isEmpty() || a[i] != union.get(union.size() - 1)) {
                union.add(a[i]);
            }
            i++;
        }
        
        // Add remaining elements from second array
        while (j < b.length) {
            if (union.isEmpty() || b[j] != union.get(union.size() - 1)) {
                union.add(b[j]);
            }
            j++;
        }
        
        return union;
    }
}
