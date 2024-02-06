
// Substitution class extends Cipher and represents a substitution cipher where each 
// character is replaced with another character based on a predefined mapping.


import java.util.HashMap;
import java.util.HashSet;

public class Substitution extends Cipher{
    
    private String shifter;
    private HashMap<Character, Character> charMap;

    // Constructs new Substitution object
    //
    // Parameters: N/A
    // 
    // Returns: N/A
    public Substitution() {
    }

    // Constructs new Substition object
    //
    // Parameters: 
    //  String shifter: The substitution pattern to be used.
    //
    // Returns: N/A
    public Substitution(String shifter) { 
        setShifter(shifter);
    }

    // Sets the substitution pattern for the cipher.
    // 
    // Parameters:
    //  String shifter: The substitution pattern to be set.
    // 
    // Throws:
    //  IllegalArgumentException if the pattern length is not equal to Cipher.TOTAL_CHARS
    //                             or if it contains duplicate characters,
    //                             or if any individual character falls outside the encodable range.
    public void setShifter(String shifter) {
        // add contains a duplicate character, or any individual character falls outside the encodable range
        if (shifter.length() != Cipher.TOTAL_CHARS ) {
            throw new IllegalArgumentException();
        }

        HashSet<Character> charSet = new HashSet<>(); // used to account for duplicate characters
        for (int i = 0; i < shifter.length(); i++) {
            char ch = shifter.charAt(i);
            if (ch < Cipher.MIN_CHAR || ch > Cipher.MAX_CHAR || !charSet.add(ch)) {
                 throw new IllegalArgumentException();
            }
        }
        this.shifter = shifter;
        this.charMap = new HashMap<>();

        // Populate charMap
        for (int i = 0; i < shifter.length(); i++) {
            charMap.put((char)(i + MIN_CHAR), shifter.charAt(i));
            
        }
    }

    // Encrypts the given input using the substitution cipher.
    //
    // Parameters:
    //  String input: The input string to be encrypted.
    // Throws:
    //  IllegalStateException if the substitution pattern is not set.
    // Returns:
    //  The encrypted string.
    public String encrypt(String input) {
        if (shifter == null || shifter.isEmpty()) {
            throw new IllegalStateException();
        }

        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            for (char chars : charMap.keySet()) {
                if (chars == ch) {
                    result += (charMap.get(chars));
                }
            }
        }
        return result;
    }

    // Decrypts the given input using the substitution cipher.
    // 
    // Parameters:
    //  String input: The input string to be decrypted.
    // Throws:
    //  IllegalStateException if the substitution pattern is not set.
    // Returns:
    //  The decrypted string.
    public String decrypt(String input) {
        if (shifter.isEmpty() || shifter == null) {
            throw new IllegalStateException();
        }

        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            for (char chars : charMap.keySet()) {
                if (charMap.get(chars) == ch) {
                    result += chars;
                }
            }
        }
        return result;
    }
}