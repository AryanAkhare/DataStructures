

class SelectionSort {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 23, 7, 8, 3, 2};

        // Selection Sort Algorithm:
        // For each index, find the smallest element in the rest of the array.
        // Swap it with the current index.

        for (int i=0;i<arr.length-1;i++){
            int small=i;
            for (int j=i+1; j<arr.length ; j++){
                if(arr[small]>arr[j]){
                    small=j;
                }
            }
            //after getting smallest we swap with i
            int temp=arr[small];
            arr[small]=arr[i];
            arr[i]=temp;
        }

        printArray(arr);
    }
}
