package Arrays.Easy;

public class BasicQuestions {
    

    
public static int sumOfDigits(int n){
    int sum=0;
    while(n!=0){
        int last=n%10;
        sum+=last;
        n/=10;
    }
    return sum;
}

public static int recursiveSumOfDigits(int n){
    if(n==0) return 0;

    return n%10+sumOfDigits(n/10);
}

public static int optimalSumofDigits(int n){
    String s=Integer.toString(n);
    int sum=0;

    for(char ch:s.toCharArray()){
        sum+=ch-'0';
    }
    return sum;
}
public static void main(String[] args) {
    System.out.println(sumOfDigits(123));
    System.out.println(recursiveSumOfDigits(123));
}
    
}
