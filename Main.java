/** Prince Anuglo
*   Jafet Oidor Ortega
*   Lab 6
*   Goal: Encrypt or decrypt in two different formats
*/
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
class Main 
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Scanner in = new Scanner(System.in);
      final int MIN_VAL = 1;
      final int MAX_VAL = 2;
  
      System.out.println("Secret Decoder Ring:");
      System.out.println("1. Encrypt");
      System.out.println("2. Decrypt");
      int choice = getIntRange(MIN_VAL, MAX_VAL);
  
      if(choice == 1) /** Check to see if user wants to encrypt */
      {
         System.out.println("Enter Encryption Type: ");
         System.out.println("1.Atbash");
         System.out.println("2.Caesar ");
         
         choice = getIntRange(MIN_VAL, MAX_VAL);
         
         System.out.println("Enter message: ");

         String messageToEncrypt = in.nextLine();
         messageToEncrypt = messageToEncrypt.toUpperCase(); /** ensure that input is all Upper Case */
         String encryptedMsg = "";

         if(choice == 1) /** Check to see if user wants AtBash Cipher */
         {
            Cipher cipherObj = new Cipher();
            encryptedMsg = cipherObj.encrypt(messageToEncrypt);
            PrintWriter writer = new PrintWriter("message.txt");
            writer.write(encryptedMsg);
            writer.close();  
         }
         else /** Check to see if user wants Caesar Cipher */
         {
            System.out.println("Enter shift value: ");
            int shift = in.nextInt();
            CaesarCipher cCObj = new CaesarCipher(shift);
            encryptedMsg = cCObj.encrypt(messageToEncrypt);
            PrintWriter writer = new PrintWriter("message.txt");
            writer.write(encryptedMsg);
            writer.close();
         }
      
      }
      else /** Check to see if user wants to decrypt */
      {
        
         System.out.println("Enter Decryption Type:");
         System.out.println("1. Atbash");
         System.out.println("2. Caesar");
         choice = getIntRange(MIN_VAL, MAX_VAL);
         /** Read from file. */
         String decryptedMsg = readFile();
       
         if(choice == 1) /** Check to see if user wants AtBash Cipher */
         {
            Cipher cObj = new Cipher();
            System.out.println("Decrypted message: "+ cObj.decrypt(decryptedMsg));
         }  
         else /** Check to see if user wants Caesar Cipher */
         {
            System.out.println("Enter Shift: ");
            int shift = in.nextInt();
            CaesarCipher cCObj = new CaesarCipher(shift);
            System.out.println("Decrypted message: "+ cCObj.decrypt(decryptedMsg));
         }

      }
  }
  /**
    *   This function ensures that the input for the menus is between two soecified values
    *
    *   @param startNum - The lowest possible valid value
    *   @param endNum - The largest possible valid value
    *   @return returnVal - returns the verified input
    */
   public static int getIntRange(int startNum, int endNum)
   {
      Scanner input = new Scanner(System.in);
      boolean repeat = true;
      int returnVal = 0;
      while (repeat)
      {
         returnVal = 0;
         try
         {
            returnVal = input.nextInt();
            if (returnVal <= endNum && returnVal >= startNum)
            {
               repeat = false;
            }
            else
            {
               System.out.println("Invalid Input ");
            }
         }catch(InputMismatchException e)
          {
            if (input.hasNext())
            {
               String stuff = input.next();
            }
            System.out.println("Invalid Input.");
          }

       }
      return returnVal; 
   }
   
   /**
   *  The readFile method will try to see if there us a readable file, if there isn't it throws an exception
   */

   public static String readFile() throws FileNotFoundException
   {
      String decryptedMsg = "";
      try
      { 
       Scanner read = new Scanner(new File("message.txt"));
       decryptedMsg = read.nextLine();
      }
      catch(FileNotFoundException e)
      {                              
        System.out.println("File Not Found - place in project folder");
      }
      return decryptedMsg;
   }

}