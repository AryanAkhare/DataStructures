class Countdigits{

    public static int bruteCount(int n){
        int digits=0;
        while(n>0){
            n=n/10;
            digits++;
        }
        return digits;
    }

    public static int OptimizedCount(int n){
        int digits=(int)Math.log10(n)+1;
        return digits;
    }
    public static void main(String[] args){
        int n=10032321;
        System.out.print(bruteCount(n));
        System.out.println("\n"+ OptimizedCount(n));
    }
}