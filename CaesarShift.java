
/**
 * CaesarShift class extends Cipher and represents a Caesar shift cipher,
 * where each character is shifted by a fixed amount in both encryption and decryption.
 */

import java.util.*;

 public class CaesarShift extends Substitution {
    
     /**
     * Constructs a new CaesarShift object with the specified shift value.
     * 
     * Parameters:
     *  int shift: The amount by which characters should be shifted.
     * Throws:
     *  IllegalArgumentException if the shift value is less than or equal to 0.
     */
     public CaesarShift(int shift) {
         super(); 
         if (shift <= 0) {
             throw new IllegalArgumentException("Error in CaesarShift!");
         }
         Queue<Character> charQ = new LinkedList<>(); 
         for (int i = (int) MIN_CHAR; i <= (int) MAX_CHAR; i++) { 
            charQ.add((char) i); 
         }
         for (int i = 0; i < shift; i++) {
            charQ.add(charQ.remove()); 
         }
         String shifter = "";
         while (!charQ.isEmpty()) { 
             shifter += charQ.poll();
         }
         setShifter(shifter); 
     }

    /**
     * Encrypts the given input using the Caesar shift substitution cipher by shifting each character.
     * 
     * Parameters:
     *  String input: The input string to be encrypted.
     * Returns:
     *  The encrypted string.
     */
     public String encrypt(String input) { 
         return super.encrypt(input); 
     }

    /**
     * Decrypts the given input using the Caesar shift substitution cipher by shifting each character in reverse.
     * 
     * Parameters:
     *  String input: The input string to be decrypted.
     * Returns:
     *  The decrypted string.
     */
     public String decrypt(String input) { 
         return super.decrypt(input); 
     }
 }