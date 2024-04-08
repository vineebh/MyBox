package com.example.login;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import android.view.View;

public class CreateFolderInBox extends AppCompatActivity {

    // Method to handle button click to create a folder in storage
    public void createFolderInStorage(View view) {
        String username = "User1"; // You can get the username from user input
        String folderName = username + "_SecureFolder";

        // Get the external storage directory
        File externalStorageDir = Environment.getExternalStorageDirectory();

        // Create a File object representing the new folder
        File folder = new File(externalStorageDir, folderName);

        // Check if the folder already exists
        if (!folder.exists()) {
            // Create the folder
            if (folder.mkdir()) {
                // Encrypt the folder with user-provided password
                encryptFolder(folder, "userPassword");
                Toast.makeText(this, "Folder created successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failed to create folder", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Folder already exists", Toast.LENGTH_SHORT).show();
        }
    }


    // Method to encrypt the folder with a password
    private void encryptFolder(File folder, String password) {
        try {
            // Generate a secret key using the password
            Key secretKey = new SecretKeySpec(password.getBytes(), "AES");

            // Initialize the cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Get the list of files in the folder
            File[] files = folder.listFiles();
            if (files != null) {
                // Encrypt each file in the folder
                for (File file : files) {
                    FileInputStream fis = new FileInputStream(file);
                    FileOutputStream fos = new FileOutputStream(file.getPath() + ".encrypted");
                    CipherOutputStream cos = new CipherOutputStream(fos, cipher);

                    byte[] buffer = new byte[8192];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        cos.write(buffer, 0, bytesRead);
                    }

                    cos.flush();
                    cos.close();
                    fis.close();

                    // Delete the original file
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error encrypting folder", Toast.LENGTH_SHORT).show();
        }
    }
}
