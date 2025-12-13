package Medium;

import static java.util.Collections.list;

public class Atoi {
    public static int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        long num = 0;
        
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        if(i==n) return 0;
        
        if(s.charAt(i)=='-' || s.charAt(i)=='+'){
            sign=(s.charAt(i)=='-') ? -1 : 1;
            i++;
            
        }
        
        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
            num=num*10+(s.charAt(i)-'0');
            if(sign*num<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(sign*num>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
            i++;
        }
        return (int)(sign*num);
        
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("-13sb"));
    }
}
