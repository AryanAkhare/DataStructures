package BitManipulation.Basics;

public class convertToDecimal {
    // User function Template for C

int binary_to_decimal(int B) {
    // code here
    int result=0;
    int base=1;
    
    
    while(B>0){
       int rem=B%10;
       result=result+rem*base;
       base=base*2;
       B=B/10;
    }
    return result;
}
}
