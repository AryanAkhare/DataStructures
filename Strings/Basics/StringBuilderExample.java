import java.util.*;

public class StringBuilderExample {  // Renamed class to avoid conflict with java.lang.StringBuilder
    public static void main(String[] args) {

        // ====================================================
        // 1. Strings are Immutable
        // ====================================================
        String s = "Hello";
        s = s + " World"; // creates a new String object
        System.out.println("Immutable String: " + s);

        // ====================================================
        // 2. StringBuilder is Mutable
        // ====================================================
        StringBuilder sb = new StringBuilder("Hello");

        // Append
        sb.append(" World"); // Hello World
        System.out.println("After append: " + sb);

        // Insert
        sb.insert(5, ",");   // Hello, World
        System.out.println("After insert: " + sb);

        // Delete
        sb.delete(5, 6);     // Hello World
        System.out.println("After delete: " + sb);

        // Replace
        sb.replace(6, 11, "Java"); // Hello Java
        System.out.println("After replace: " + sb);

        // Reverse
        sb.reverse(); // avaJ olleH
        System.out.println("After reverse: " + sb);

        // Length
        int len = sb.length();
        System.out.println("Length of StringBuilder: " + len);

        // Convert to String
        String result = sb.toString();
        System.out.println("Converted to String: " + result);

        // ====================================================
        // 3. String vs StringBuilder in a Loop
        // ====================================================

        // Using String (inefficient)
        String str = "";
        for (int i = 0; i < 1000; i++) {
            str += i; // creates a new object every time
        }
        System.out.println("Final String length (inefficient): " + str.length());

        // Using StringBuilder (efficient)
        StringBuilder sbLoop = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sbLoop.append(i); // modifies the same object
        }
        String efficientResult = sbLoop.toString();
        System.out.println("Final StringBuilder length (efficient): " + efficientResult.length());

        // ====================================================
        // 4. DSA-focused StringBuilder operations
        // ====================================================
        System.out.println("\n--- DSA-focused StringBuilder Operations ---");

        StringBuilder sbDSA = new StringBuilder("ABCDE");

        // Access character at index
        char ch = sbDSA.charAt(2); // C
        System.out.println("Character at index 2: " + ch);

        // Modify character at index
        sbDSA.setCharAt(1, 'X'); // AXCDE
        System.out.println("After setCharAt(1, 'X'): " + sbDSA);

        // Delete character at index
        sbDSA.deleteCharAt(3); // AXCE
        System.out.println("After deleteCharAt(3): " + sbDSA);

        // Extract substring
        String sub = sbDSA.substring(1, 4); // XC
        System.out.println("Substring(1,4): " + sub);

        // Build a string in a loop efficiently
        StringBuilder loopSB = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            loopSB.append(i); // 12345
        }
        System.out.println("Efficient string built with append in loop: " + loopSB);

        // ====================================================
        // Takeaway:
        // Use StringBuilder whenever you expect multiple modifications to a string.
        // For small or single concatenation, normal String is fine.
        // ====================================================
    }
}
