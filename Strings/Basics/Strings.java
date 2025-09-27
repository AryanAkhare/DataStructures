import java.util.*;

class Strings {
    public static void main(String[] args) {
        // -----------------------------
        // STRING DECLARATION & CONCATENATION
        // -----------------------------
        String name1 = "Aryan";
        String name2 = "Akhare";

        // Concatenation
        String fullname = name1 + " " + name2;
        System.out.println("Full Name: " + fullname);

        // -----------------------------
        // STRING METHODS
        // -----------------------------

        // 1. Length of string
        System.out.println("Length of name1: " + name1.length());

        // 2. Character at a specific index
        System.out.println("Char at index 4 of name1: " + name1.charAt(4));

        // 3. Uppercase and Lowercase
        System.out.println("Uppercase Fullname: " + fullname.toUpperCase());
        System.out.println("Lowercase Fullname: " + fullname.toLowerCase());

        // 4. Iterating through string characters
        System.out.print("Characters in name1: ");
        for (int i = 0; i < name1.length(); i++) {
            System.out.print(name1.charAt(i) + " ");
        }
        System.out.println();

        // 5. Compare Strings
        // compareTo returns: s1>s2 -> +ve, s1=s2 -> 0, s1<s2 -> -ve
        System.out.println("Comparing name1 with name2: " + name1.compareTo(name2));
        System.out.println("Comparing name2 with name1: " + name2.compareTo(name1));

        // 6. Compare ignoring case
        String s1 = "abc";
        String s2 = "ABC";
        System.out.println("Compare ignoring case: " + s1.compareToIgnoreCase(s2));

        // 7. Substring
        String sentence = "My name is Aryan";
        String sub = sentence.substring(11); // from index 11 to end
        System.out.println("Substring: " + sub);

        // 8. Index of character or substring
        System.out.println("Index of 'Aryan': " + sentence.indexOf("Aryan"));
        System.out.println("Index of 'z' (not found): " + sentence.indexOf("z")); // -1 if not found

        // 9. Starts with / Ends with
        System.out.println("Starts with 'My': " + sentence.startsWith("My"));
        System.out.println("Ends with 'Aryan': " + sentence.endsWith("Aryan"));

        // 10. Contains
        System.out.println("Contains 'name': " + sentence.contains("name"));

        // 11. Replace
        System.out.println("Replace 'Aryan' with 'Tony': " + sentence.replace("Aryan", "Tony"));

        // 12. Trim (removes leading/trailing spaces)
        String spaced = "   Hello World   ";
        System.out.println("Trimmed String: '" + spaced.trim() + "'");

        // 13. Split (useful in parsing input)
        String csv = "apple,banana,cherry";
        String[] fruits = csv.split(",");
        System.out.println("Fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 14. String to Char Array
        char[] chars = name1.toCharArray();
        System.out.println("Chars array of name1: " + Arrays.toString(chars));

        // 15. StringBuilder for mutable operations (DSA often uses this for efficiency)
        StringBuilders sb = new StringBuilders("Aryan");
        sb.append(" Akhare");
        sb.insert(5, ",");
        sb.deleteCharAt(5);
        sb.reverse();
        System.out.println("StringBuilder example (reversed): " + sb);

        // 16. Check if string is empty or blank
        String empty = "";
        String blank = "   ";
        System.out.println("Is empty string empty? " + empty.isEmpty());
        System.out.println("Is blank string blank? " + blank.isBlank());

        // 17. Equality
        String a = "Aryan";
        String b = "Aryan";
        String c = new String("Aryan");
        System.out.println("a == b? " + (a == b)); // true, same literal
        System.out.println("a == c? " + (a == c)); // false, different object
        System.out.println("a.equals(c)? " + a.equals(c)); // true, content equal
    }
}
