package Arrays;
//LEETCODE-1752 Given an array nums, 
//check if it is a sorted array that has been rotated (circularly) at most once.

// Given an array nums, check if it is a non-decreasing 
// sorted array that has been rotated (possibly 0 times).
//  Rotation Definition:
// Array [a, b, c] rotated = [c, a, b] or [b, c, a], etc.
// Intuition
public class SortedandRotated {
    private static boolean check(int a[]){
        int count =0;
        int n=a.length;
        for (int i=0 ; i<n; i++){
            if(a[i]>a[(i+1)%n]){  //to make circular
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int a[]={3,4,5,1,2}; //sorted 1 2 3 4 5
        int b[]={2,1,3,4}; // sprted 1 2 3 4
        System.out.println(check(a)); //true
        System.out.println(check(b));   //false
    }
}
