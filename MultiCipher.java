
/**
 * MultiCipher class extends Cipher and represents a composite cipher that applies multiple ciphers
 * in a specified order for encryption and decryption.
 */

import java.util.*;

public class MultiCipher extends Cipher{
    
    private List<Cipher> cipherArr;
    
      /**
     * Constructs a new MultiCipher object with the specified list of ciphers.
     * 
     * Parameters:
     *  List<Cipher> ciphers: The list of ciphers to be applied in order.
     * Throws:
     *  IllegalArgumentException if the provided list of ciphers is null.
     */
    public MultiCipher(List<Cipher> ciphers) {
        if(ciphers == null) {
            throw new IllegalArgumentException();
        }
        cipherArr = new ArrayList<>(ciphers);
    }
    
     /**
     * Encrypts the given input by applying each cipher in the specified order.
     * 
     * Parameters:
     *  String input: The input string to be encrypted.
     * Returns:
     *  The final encrypted string after applying all ciphers.
     */
    public String encrypt(String input) {
        for (int i = 0; i < cipherArr.size(); i++) {
            String result = cipherArr.get(i).encrypt(input);
            input = result;
            System.out.println((i + 1) + ": " + input);
        }
        return input;
    }
    
    /**
     * Decrypts the given input by applying each cipher in reverse order.
     * 
     * Parameters:
     *  String input: The input string to be decrypted.
     * Returns:
     *  The final decrypted string after applying all ciphers in reverse order.
     */
    public String decrypt(String input) {
        for (int i = cipherArr.size() - 1; i >= 0; i--) { 
            String result = cipherArr.get(i).decrypt(input);
            input = result;
            System.out.println((i + 1) + ": " + input);
        }
        return input;
    }
}
