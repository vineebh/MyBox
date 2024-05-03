package com.example.login;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class download extends AppCompatActivity {

    ImageView I1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_download);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Toast.makeText(this, "Downloading...", Toast.LENGTH_SHORT).show();

        I1=findViewById(R.id.filePreview);
        String address;
        address = Objects.requireNonNull(getIntent().getExtras()).getString("path");
        if ( !(address.equals("null"))) {
            I1.setImageURI(Uri.parse(address));
            Toast.makeText(this, address, Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, address, Toast.LENGTH_SHORT).show();
    }
}