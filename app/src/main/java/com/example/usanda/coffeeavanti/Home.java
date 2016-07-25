package com.example.usanda.coffeeavanti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Button admin = (Button) findViewById(R.id.button9);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Home.this, Home.class));
                startActivity(intent);

            }


        });

        Button user = (Button) findViewById(R.id.button10);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Home.this, MainActivity.class));
                startActivity(intent);

            }


        });

        Button guest = (Button) findViewById(R.id.button11);
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Home.this, Risk.class));
                startActivity(intent);

            }


        });
    }

}
