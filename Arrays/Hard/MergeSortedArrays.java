package Arrays.Hard;

public class MergeSortedArrays {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointers:
        int indexNums1 = m - 1;         // points to the last valid element in nums1
        int indexNums2 = n - 1;         // points to the last element in nums2
        int mergeIndex = m + n - 1;     // points to the last available slot in nums1 (which has extra space)

        // Merge from the end (largest elements first)
        while (indexNums1 >= 0 && indexNums2 >= 0) {
            if (nums1[indexNums1] > nums2[indexNums2]) {
                nums1[mergeIndex] = nums1[indexNums1];
                indexNums1--;
            } else {
                nums1[mergeIndex] = nums2[indexNums2];
                indexNums2--;
            }
            mergeIndex--;
        }

        // Copy any remaining elements from nums2
        // (No need to copy nums1's leftovers, they are already in place)
        while (indexNums2 >= 0) {
            nums1[mergeIndex] = nums2[indexNums2];
            indexNums2--;
            mergeIndex--;
        }
    }
}


