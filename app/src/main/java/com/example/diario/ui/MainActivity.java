package com.example.diario.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.diario.R;
import com.example.diario.crud.CRUPProfesor;

public class MainActivity extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.imageView);

        image.setImageResource(R.drawable.julio);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Don Julio",Toast.LENGTH_SHORT).show();

                Intent numbersIntent = new Intent(MainActivity.this, reportaje.class);

                startActivity(numbersIntent);



            }
        });

    }
}