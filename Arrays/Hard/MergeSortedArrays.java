// import java.util.Arrays;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // ------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>
        // Brute force approach:=> T.C. = O(n*logn) and S.C.= O(1)
       /*  int j = 0;
        for (int i = m; i < nums1.length; i++) {

        nums1[i] = nums2[j];
        j++;

        }
        Arrays.sort(nums1);*/
        // --------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>

        
        
        // Optimal solution:=> T.C. = O(m+n) and S.C. = O(1)
        // Pointers for nums1 and nums2
        int i = m - 1; // Last element in nums1's valid range
        int j = n - 1; // Last element in nums2
        int k = m + n - 1; // Last position in nums1

        // Start merging from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // Copy any remaining elements from nums2 (if any)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

}
// ------------------>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
// Another optimal solution (Gap method)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Copy nums2 into nums1 after m
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        // Start with the initial gap
        int totalLength = m + n;
        int gap = (totalLength + 1) / 2; // Initial gap

        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < totalLength) {
                // Compare and swap if needed
                if (j < m && nums1[i] > nums1[j]) { // Both in nums1
                    swap(nums1, i, j);
                } else if (i < m && j >= m && nums1[i] > nums1[j]) { // nums1 and nums2 overlap
                    swap(nums1, i, j);
                }
                i++;
                j++;
            }

            // Reduce the gap for the next iteration
            if (gap == 1) {
                gap = 0; // End the loop
            } else {
                gap = (gap + 1) / 2; // Reduce the gap
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
