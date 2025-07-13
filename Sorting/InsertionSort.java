

class InsertionSort{
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 23, 7, 8, 3, 2};

        // Insertion Sort Algorithm:
        // Pick each element one by one from index 1 to end.
        // Place it in the correct position in the sorted part of the array on the left.
        // Shift elements to make space if needed.

        for(int i=1; i<arr.length;i++){
            int curr=arr[i];
            int j=i-1; //sorted ka last index
            while(j>=0 && curr<arr[j]){ //comparing sorted to unsorted part until curr gets smaller so it makes space
            
                arr[j+1]=arr[j];
                j--;
            }

            //placement
            arr[j+1]=curr;

        }
        printArray(arr);
    }
}