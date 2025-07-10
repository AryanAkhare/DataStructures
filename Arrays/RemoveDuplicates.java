package Arrays;

public class RemoveDuplicates {
    
    public static int removeDuplicates(int[] nums) {
        int i=0;
        for ( int j=0 ; j<nums.length; j++){
            if(nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int a[]={1,1,2};
        int b[]={1,2,2,3,3,4,4,5,5,6,7};
        System.out.println(removeDuplicates(a));
        System.out.println(removeDuplicates(b));
    }

}
