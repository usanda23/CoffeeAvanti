package com.example.usanda.coffeeavanti;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forgot extends AppCompatActivity {



    Button proccedButton ;
    Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//         procced=(Button)findViewById(R.id.button);
//        procced.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = (new Intent(Forgot.this, MainActivity.class));
//                startActivity(intent);
//
//            }
//        });

         cancel = (Button) findViewById(R.id.button2);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Forgot.this, Register.Home.class));
                startActivity(intent);

            }


        });

        proccedButton = (Button) findViewById(R.id.button);
        proccedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Forgot.this, MainActivity.class));
                startActivity(intent);

            }


        });


    }

}
