
/**
 * CaesarKey class extends Substitution and represents a Caesar key substitution cipher,
 * which is a type of substitution cipher where each character is shifted by a fixed amount.
 */
import java.util.*;

public class CaesarKey extends Substitution{
    
    private String shifter;

    /**
     * Constructs a new CaesarKey object with the specified key.
     * 
     * Parameters:
     *  String key: The key to be used for the Caesar key substitution.
     * Throws:
     *  IllegalArgumentException if the key is empty,
     *                             or if it contains duplicate characters,
     *                             or if any individual character falls outside the encodable range.
     */
    public CaesarKey(String key) {
        super();
        HashSet<Character> charSet = new HashSet<>(); // used to account for duplicate characters
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (ch < Cipher.MIN_CHAR || ch > Cipher.MAX_CHAR || !charSet.add(ch)) {
                 throw new IllegalArgumentException();
            }
        }
        if (key.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.shifter = "";
        
          // input key into front of shifter
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            shifter += ch;
        }

        // this section of code works but is very inefficient lol
        // iterate through encodable range
        for (int i = MIN_CHAR; i <= MAX_CHAR; i++) { 
            char ch = (char) i;
            for (int j = 0; j < shifter.length(); j++) {
               if (shifter.indexOf(ch) == -1) {
                shifter += (char) ch;
               }
            }
        }
        setShifter(shifter);
    }
}