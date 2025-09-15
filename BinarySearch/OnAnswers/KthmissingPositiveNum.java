package OnAnswers;

public class KthmissingPositiveNum {

    /*
    Problem Statement:
    -----------------
    Given a sorted array of distinct positive integers (arr[]) and an integer k, 
    find the kth missing positive number in the natural number sequence.

    Example:
    arr = [2, 3, 4, 7, 11], k = 5
    Missing numbers = [1, 5, 6, 8, 9, 10, ...]
    The 5th missing number = 9
    */

    /*
    Intuition (Brute Force):
    ------------------------
    - Traverse through the array.
    - If arr[i] is less than or equal to k, it means this number is not missing,
      so we increment k to account for the missing numbers shifting further.
    - Else, stop the loop because we've found our answer.
    - Return k.
    Time Complexity: O(n), because we may traverse the whole array once.
    */

    public int kthmissingPositiveNumBrute(int arr[], int k) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) k++;
            else break;
        }
        return k;
    }

    /*
    Intuition (Optimal - Binary Search):
    -----------------------------------
    - Missing numbers before index mid = arr[mid] - (mid+1).
      Example: if arr[mid] = 7 and mid = 3 → missing = 7 - (3+1) = 3.
    - If the number of missing numbers up to mid <= k, then the kth missing lies 
      on the right side, so we move low = mid+1.
    - Otherwise, move high = mid-1.
    - At the end, low will give the correct position and the answer is low + k.
    
    Time Complexity: O(log n), because we use binary search.
    Space Complexity: O(1), no extra space used.
    */

    public int kthmissingPositiveNumOptimal(int arr[], int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing <= k) low = mid + 1;
            else high = mid - 1;
        }
        return low + k;
    }
    public static void main(String[] args) {
      int a[]={2,5,6,7,10};
      System.out.println(kthmissingPositiveNumOptimal(a));
    }
}

