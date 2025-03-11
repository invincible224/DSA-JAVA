

import java.util.ArrayList;
import java.util.List;

class PascalTri {
    // Generate a specific row of Pascal's Triangle
    List<Integer> generateRows(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add((int) ans); // Add the first element (always 1)
        
        // Generate remaining elements of the row
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans); // Add the calculated element
        }
        
        return ansRow;
    }

    // Generate Pascal's Triangle up to numRows
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        // Add each row to the list
        for (int i = 1; i <= numRows; i++) {
            list.add(generateRows(i));
        }
        
        return list;
    }
}
