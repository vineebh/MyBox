package com.example.login;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.login.CreateFolderInBox;

public class MainActivity extends AppCompatActivity {

    private Button downloadButton;
    private ImageButton downloadImage,uploadImage;
    private Button uploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadButton = findViewById(R.id.downloadButton);
        downloadImage =(ImageButton)findViewById(R.id.DownloadImage);
        uploadButton = findViewById(R.id.uploadButton);
        uploadImage =(ImageButton)findViewById(R.id.UploadImage);

        downloadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadFromBox();
            }
        });

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadFromBox();
            }
        });


        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadToBox();
            }
        });
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadToBox();
            }
        });
        CreateFolderInBox box =new CreateFolderInBox();
    }

    private void downloadFromBox() {
        // Placeholder for download from Box logic
        Intent i=new Intent(MainActivity.this,downloadFile.class);
        i.putExtra("path", "null");
        startActivity(i);
    }

    private void uploadToBox() {
        // Placeholder for upload to Box logic
        startActivity(new Intent( MainActivity.this, uploadFile.class));
    }

}