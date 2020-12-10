import java.util.Scanner;
public class Cipher
{
   //private instance var.
   private char [] reversedAlphabet = {'Z','Y','X','W','V','U','T','S','R','Q','P','O','N','M','L','K','J','I','H','G','F','E','D','C','B','A'};
   protected char [] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
   /** Constructor */
   Cipher()
   {
  
   }
  
    /**
    * This method facilitates the encryption by encrypting each individual character and adding it to a String
    * 
    * @param msg - The String inputted by the user to be encrypted
    * @return temp - a temporary variable that stores the encrypted String 
    */
   public String encrypt(String msg)
   {
      String temp = "";
      for (int i = 0; i < msg.length();i++)
      {
         temp = temp + encryptLetter(msg.charAt(i));
      }
      return temp;
   }

   /**
    * This method facilitates the decryption by decrypting each individual character and adding it to a String
    * 
    * @param msg - The String inputted by the user to be decrypted
    * @return temp - a temporary variable that stores the decrypted String 
    */
   public String decrypt(String msg)
   {
      String temp = "";
      for (int i = 0; i < msg.length();i++)
      {
         temp = temp + decryptLetter(msg.charAt(i));
      }
      return temp;
   }

   /**
   * This method shifts the character being encrypted by an amount speficied by the user.
   * 
   * @param c - a character that is to be encrypted
   * @return c - returns the encrypted character
   */
   protected char encryptLetter(char c)
   {
    //Atbash Cipher 
    //loop through message input. 
      for(int i = 0; i < alphabet.length-1;i++)
      {
         if (c==alphabet[i])
         {
            c = reversedAlphabet[i];
            break;
         }
   
      }
      return c;
   }

   /**
   * This method shifts the character being decrypted by an amount speficied by the user.
   * 
   * @param c - a character that is to be decrypted
   * @return c - returns the decrypted character
   */
   protected char decryptLetter(char c)
   {
      for(int i = 0; i < alphabet.length-1;i++)
      {
         if (c==reversedAlphabet[i])
         {
            c = alphabet[i];
            break;
         }
      }
      return c;
   }

}