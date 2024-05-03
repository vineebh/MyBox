package com.example.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class uploadFile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_file);


        Button uploadbtn = findViewById(R.id.uploadbtn);
        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //MediaStore.Files.getContentUri("external"), MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                startActivityForResult(intent, 3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && data!= null){
            Uri selectedFile = data.getData();
            ImageView preview = findViewById(R.id.filePreview);
            preview.setImageURI(selectedFile);
            Button upbtn = findViewById(R.id.uploadbtn);
            upbtn.setText("Upload");
            upbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(uploadFile.this,"uploding", Toast.LENGTH_SHORT).show();
                    upbtn.setText("Uploaded");

                    //Intent i=new Intent(MainActivity.this,uploadFile.class);
                    //i.putExtra("hy","hello");
                    //startActivity(i);

                    Intent intent = new Intent(uploadFile.this, downloadFile.class);
                    if( selectedFile != null) {
                        intent.putExtra("path", selectedFile.toString());
                        //intent.putExtras(data);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }
}