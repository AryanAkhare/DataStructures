package OnAnswers;



/*
Question:
-----------
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone, and Koko has H hours to finish all the bananas. 

Koko eats at a constant speed of K bananas per hour. If the pile has less than K bananas, 
she eats all of them and will not eat any more bananas during that hour.

Return the minimum integer K such that she can eat all the bananas within H hours.

Example:
---------
Input: piles = [3,6,7,11], h = 8
Output: 4

Explanation:
- If K = 4: 
  Hour 1: 3 (pile 1) → done early but still counts as 1 hour
  Hour 2: 4 (from pile 2, 2 left)
  Hour 3: 2 (from pile 2) → pile finished
  Hour 4: 4 (from pile 3, 3 left)
  Hour 5: 3 (from pile 3) → pile finished
  Hour 6: 4 (from pile 4, 7 left)
  Hour 7: 4 (from pile 4, 3 left)
  Hour 8: 3 (from pile 4) → finished exactly in 8 hours

---------------------------------------------------------------
Complexity Intuition:
---------------------
- Binary search between 1 and max(piles) → O(log(maxPile)).
- For each mid speed, calculate total hours needed → O(n).
- Total Time Complexity: O(n * log(maxPile)).
- Space Complexity: O(1).
---------------------------------------------------------------
*/

public class KokoEatingBananas {
    
        public int minEatingSpeed(int[] piles, int h) {
            int low = 1;                // minimum possible speed
            int high = max(piles);      // maximum possible speed (eat largest pile in one hour)
            int ans = high;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                int totalHours = totalTime(piles, mid);

                if (totalHours <= h) {
                    ans = mid;          // try smaller speed
                    high = mid - 1;
                } else {
                    low = mid + 1;      // need faster eating speed
                }
            }
            return ans;
        }

        // Helper function: total hours needed for given speed
        public int totalTime(int[] piles, int speed) {
            int hours = 0;
            for (int bananas : piles) {
                hours += (int) Math.ceil((double) bananas / speed);
            }
            return hours;
        }

        // Helper function: max element in array
        public int max(int[] arr) {
            int max = Integer.MIN_VALUE;
            for (int x : arr) if (x > max) max = x;
            return max;
        }
}
    

