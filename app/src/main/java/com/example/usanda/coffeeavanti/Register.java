package com.example.usanda.coffeeavanti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button submit1 = (Button) findViewById(R.id.button3);
        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Register.this, MainActivity.class));
                startActivity(intent);

            }


        });

        Button cancel = (Button) findViewById(R.id.button4);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Register.this, Home.class));
                startActivity(intent);

            }


        });
    }
    }


