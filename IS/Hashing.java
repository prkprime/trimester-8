/*
Name : Pratik Gorade
Year : T.Y. B.Tech
Panel : 2
Batch : B2
Roll No. : PB02
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Set;

public class Hashing {
    public static String hash(String method, String input) {
        //This function Takes a hashing String containing method like SHA-512 or SHA3-512
        //and a input string and returns a hash value as a string
        try {
            MessageDigest md = MessageDigest.getInstance(method);
            md.update(input.getBytes());
            byte[] bytes = md.digest();
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                output.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return String.valueOf(output);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm");
        }
        return null;
    }

    public static String hash(String method, File file) throws IOException {
        //This function Takes a hashing String containing method like SHA-512 or SHA3-512
        //and a input file and returns a hash value as a string
        try {
            MessageDigest md = MessageDigest.getInstance(method);
            FileInputStream fis = new FileInputStream(file);
            byte[] byteArray = new byte[1024];
            int bytesCount = 0;
            while ((bytesCount = fis.read(byteArray)) != -1) {
                md.update(byteArray, 0, bytesCount);
            }
            fis.close();
            byte[] bytes = md.digest();
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                output.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return String.valueOf(output);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm");
        } catch (IOException e) {
            System.out.println("404 file not found");
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("Invalid number of arguments \nTry 'java Hashing <Algorithm name> <String/File> <File name/Path / String>'");
        }
        else if(args[1].toUpperCase().equals("FILE")) {
            File file = new File(args[2]);
            System.out.println("Hash value of hello.txt is "+hash(args[0], file));
        }
        else {
            System.out.println("Hash value of Hello World is "+hash(args[0],args[2]));
        }
    }
}
