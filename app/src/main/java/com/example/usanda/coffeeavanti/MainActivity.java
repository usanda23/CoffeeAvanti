package com.example.usanda.coffeeavanti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.logonBTN);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(MainActivity.this, Order.class));
                startActivity(intent);

//efdfefsdz
            }

        });
        button2 = (Button) findViewById(R.id.registerBTN);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(MainActivity.this, Register.class));
                startActivity(intent);

            }


        });
        final TextView view = (TextView) findViewById(R.id.textView3);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = (new Intent(MainActivity.this, Forgot.class));
                startActivity(intent);


            }

        }
        );
    }
    }
