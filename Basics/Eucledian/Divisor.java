import java.util.*;
//My code
// class Divisor{
//     public static void main(String[] args){
//         int n=36;
//         for(int i=1 ; i< Math.sqrt(n);i++){
//             if(n%i==0){
//                 System.out.println(i+"\t");
//                 if((n/i)!=i){
//                     System.out.println(n/i+"\t");
//                 }
//             }
//         }
//     }
// }



class Divisor {
    public static void divisors(int n){
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);           // First divisor
                if (n / i != i) {
                    divisors.add(n / i);   // Paired divisor
                }
            }
        }
        Collections.sort(divisors);
        System.out.print(divisors);

    }
    public static boolean isPrime(int n){
        int count=0;
        //prime has 1 and itself as divisor thus divisors cant exceed 2
        for( int i=1 ; i<Math.sqrt(n); i++){
            if (n % i == 0) {
                count++;          
                if (n / i != i) {
                    count++;
                }
            }
        }
        if(count>2){ return false ;}
        return true;
    }
    public static void main(String[] args) {
        int n = 18;
        divisors(n);
        System.out.println("\n"+isPrime(n));
    }
}


