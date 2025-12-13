package Medium;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger{

    public static int rtoI(String s){
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);


        int num=mp.get(s.charAt(s.length()-1));

        for(int i=s.length()-2;i>=0;i--){
            if(mp.get(s.charAt(i))<mp.get(s.charAt(i+1))){
                num-=mp.get(s.charAt(i));
            }else{
                num+=mp.get(s.charAt(i));
            }
        }
        return num;

    }
    public static void main(String[] args) {
        System.out.println(rtoI("IX"));
    }
}