package Medium;
class minBloomDays{

    // Function to check if it's possible to make m bouquets in 'day' days
    public boolean possible(int[] arr, int day, int k, int m) {
        int count = 0;
        int num = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                num += (count / k); // no of bouquets
                count = 0;
            }
        }
        num += (count / k);
        return num >= m;
    }

    // Function to find the minimum element in the array
    private int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
        }
        return min;
    }

    // Function to find the maximum element in the array
    private int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;

        int low = findMin(arr);  // smallest bloom day
        int high = findMax(arr); // largest bloom day
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(arr, mid, k, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

/*
 Helper functions written separately:
 
 // Function to find the minimum element in the array
 private int findMin(int[] arr) {
     int min = Integer.MAX_VALUE;
     for (int num : arr) {
         min = Math.min(min, num);
     }
     return min;
 }

 // Function to find the maximum element in the array
 private int findMax(int[] arr) {
     int max = Integer.MIN_VALUE;
     for (int num : arr) {
         max = Math.max(max, num);
     }
     return max;
 }
*/
