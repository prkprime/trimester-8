/*
Name : Pratik Gorade
Year : T.Y. B.Tech
Panel : 2
Batch : B2
Roll No. : PB02
Usage : java RSA_API.java
*/

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

public class RSA_API {

    public static KeyPair generateKeys() throws NoSuchAlgorithmException {
      //This function creates pair of public and prvate keys for RSA
       try {
           KeyPairGenerator mypair = KeyPairGenerator.getInstance("RSA");
           SecureRandom random = new SecureRandom();
           mypair.initialize(2048, random);
           return mypair.generateKeyPair();
       } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
       }
        return null;
    }

    public static String encrypt(String message, java.security.PublicKey key) {
      //function takes plain text and public key and returns encrypted text
        try {
            final Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            String ciphertext = new String(Base64.getEncoder().encode(encryptedBytes));
            return ciphertext;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String message, java.security.PrivateKey key) {
      //takes encrypted text and private key and returns decrypted text
        try {
            final Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] ciphertextBytes = Base64.getDecoder().decode(message.getBytes());
            byte[] decryptedBytes = cipher.doFinal(ciphertextBytes);
            String decryptedString = new String(decryptedBytes);
            return decryptedString;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPair keyPair = generateKeys();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter message to  send : ");
        String message = scan.nextLine();
        System.out.println("Plain Text : "+message);
        String ciphertext = encrypt(message, keyPair.getPublic());
        System.out.println("Encrypted Text : "+ciphertext);
        String plaintext2 = decrypt(ciphertext, keyPair.getPrivate());
        System.out.println("Decrypted Text : "+plaintext2);
    }
}
