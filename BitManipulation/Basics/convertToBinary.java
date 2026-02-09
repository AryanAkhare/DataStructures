public class convertToBinary {
    static String decToBinary(int n) {

        if (n == 0) return "0";

        String result = "";

        while (n > 0) {
            result += (n % 2);
            n = n / 2;
        }

        // reverse result
        String rev = "";
        for (int i = result.length() - 1; i >= 0; i--) {
            rev += result.charAt(i);
        }

        return rev;
    }
}
