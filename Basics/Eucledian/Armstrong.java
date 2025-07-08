import java.lang.Math;

// For a number with k digits:
// abcd... = aᵏ + bᵏ + cᵏ + dᵏ + ...
class Armstrong {
    public static boolean isArmstrong(int n) {
        int dup = n;
        int digit = Countdigits.OptimizedCount(n);
        int sum = 0;

        while (n != 0) {
            int ld = n % 10;
            sum += Math.pow(ld, digit);
            n = n / 10;
        }

        if (sum == dup) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 1634;
        System.out.println(isArmstrong(n));
    }
}
