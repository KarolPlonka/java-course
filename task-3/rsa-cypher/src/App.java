import java.security.*;
import javax.crypto.*;
import java.io.*;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

// write rsa class
public class App {
    public static void main(String[] args) throws Exception {

        // taking input from user and saving it into notes.txt file
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input_from_user = br.readLine();
        PrintWriter notes = new PrintWriter("notes.txt", "UTF-8");
        notes.println(input_from_user);
        notes.close();

        // generate key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        // get public key
        PublicKey publicKey = keyPair.getPublic();

        // get private key
        PrivateKey privateKey = keyPair.getPrivate();

        // get instance of cipher
        Cipher cipher = Cipher.getInstance("RSA");

        // encrypt the text read from file
        byte[] input = Files.readAllBytes(Paths.get("notes.txt"));
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        
        byte[] cipherText = cipher.doFinal(input);
        Files.write(Paths.get("notes_encrypted.txt"), cipherText);

        // decrypt the text from file
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] plainText = cipher.doFinal(cipherText);

        // save decrypted text to file
        Files.write(Paths.get("notes.txt"), plainText);
        new String(plainText, StandardCharsets.UTF_8);
        
        System.out.println("Encrypted text: " + new String(cipherText, StandardCharsets.UTF_8));
        System.out.println("\n");
        System.out.println("Decrypted text: " + new String(plainText, StandardCharsets.UTF_8));
        

    }
}