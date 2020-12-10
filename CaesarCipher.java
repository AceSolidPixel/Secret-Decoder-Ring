

public class CaesarCipher extends Cipher
{
  /** Represents how much the alphabet will shift */
  private static int shift;

  /** Constructor */
   CaesarCipher(int s)
   {
      shift = s;
   }

   /**
   * This method shifts the character being encrypted by an amount speficied by the user.
   * 
   * @param c - a character that is to be encrypted
   * @return c - returns the encrypted character
   */
   @Override
   protected char encryptLetter(char c)
   {
      for(int i = 0; i < alphabet.length-1;i++)
      {
         if (c==alphabet[i]){
         c = alphabet[(i + shift)%26];
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
         if (c==alphabet[i])
         {
            c = alphabet[(i - shift)%26];
            break;
         }
      }
      return c;
   }
}