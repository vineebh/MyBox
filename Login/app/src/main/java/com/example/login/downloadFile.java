package com.example.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class downloadFile extends AppCompatActivity {

    ImageView I1,I2,I3,I4,I5,I6,I7,I8;
    String address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_download_file);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        I1=findViewById(R.id.filePreview1);
        I2=findViewById(R.id.filePreview2);
        I3=findViewById(R.id.filePreview3);
        I4=findViewById(R.id.filePreview4);
        I5=findViewById(R.id.filePreview5);
        I6=findViewById(R.id.filePreview6);
        I7=findViewById(R.id.filePreview7);
        I8=findViewById(R.id.filePreview8);


        //String st= Objects.requireNonNull(getIntent().getExtras()).getString("hy","null");
        //Toast.makeText(uploadFile.this,st,Toast.LENGTH_SHORT).show();

        address = Objects.requireNonNull(getIntent().getExtras()).getString("path");
        if ( !(address.equals("null"))) {
            I1.setImageURI(Uri.parse(address));
        }

        I1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
        /*
        I2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
        I3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
        I4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
        I5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
        I6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
        I7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
        I8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });*/
    }
    private void download(){
        if (!address.isEmpty() && address!= null) {
            Intent intent = new Intent(downloadFile.this, download.class);
            intent.putExtra("path", address);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(downloadFile.this, download.class);
            intent.putExtra("path", "@drawable/img1");
            startActivity(intent);
        }
    }
}