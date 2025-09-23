package OnAnswers;

import java.util.ArrayList;

public class MedianOfTwoSortedArrays {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        ArrayList<Integer> arr = new ArrayList<>();
        
        int i = 0, j = 0;

        // Merge the two arrays
        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                arr.add(nums1[i++]);
            } else {
                arr.add(nums2[j++]);
            }
        }

        while(i < n1){
            arr.add(nums1[i++]);
        }
        while(j < n2){
            arr.add(nums2[j++]);
        }

        // Find median
        if(n % 2 == 1){
            return (double) arr.get(n/2);
        } else {
            return (arr.get(n/2 - 1) + arr.get(n/2)) / 2.0;
        }
    }
}

