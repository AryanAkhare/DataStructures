
public class OddEvenIndex {
    
    public void reArrange(int[] arr, int N) {
        int i = 0, j = 1;

        while (i < N && j < N) {
            // find wrong even index (contains odd number)
            while (i < N && arr[i] % 2 == 0) {
                i += 2;
            }

            // find wrong odd index (contains even number)
            while (j < N && arr[j] % 2 == 1) {
                j += 2;
            }

            // swap misplaced elements
            if (i < N && j < N) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}


