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

public class Hashing {
    public static String hash(String method, String input) {
        try {
            MessageDigest md = MessageDigest.getInstance(method);
            md.update(input.getBytes());
            byte[] bytes = md.digest();
            StringBuilder output = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                output.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return String.valueOf(output);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String hash(String method, File file) throws IOException {
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
            for(int i=0; i< bytes.length ;i++)
            {
                output.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return String.valueOf(output);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hash value of Hello World is "+hash("SHA3-512","Hello World"));
        File file = new File("/home/prk/Documents/trimester-8/IS/hello.txt");
        System.out.println("Hash value of hello.txt is "+hash("SHA-512", file));
    }
}
