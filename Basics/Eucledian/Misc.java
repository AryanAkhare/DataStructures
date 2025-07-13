import java.util.*;

class Misc {



    public static void oddSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }
        System.out.println("Sum of odd numbers up to " + n + " is: " + sum);
    }


    //factorial
    public static long fact(int n) {
        if (n == 0) return 1;
        long fact = 1;
        for (int i = n; i >= 1; i--) {
            fact *= i;
        }
        return fact;
    }
    public static int sumOfDigits(int n) {
        int sum=0;
        while(n>0){
            int ld=n%10;
            sum+=ld;
            n=n/10;
        }
        return sum;
    }
    public static void fibonacci(int n) {
        if (n < 0) return;
        int a = 0, b = 1;
        System.out.print(a + " ");
        if (n == 0) return;
        System.out.print(b + " ");
        while (a + b <= n) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
    }
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        // oddSum(num);
        // System.out.print(fact(num));
        System.out.print(sumOfDigits(num)+"\n");
        fibonacci(num);
        sc.close();

    }
}
