package com.example.usanda.coffeeavanti;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.ArrayList;

public class Register extends AppCompatActivity {

    String name;
    String surname;
    String username;
    String password;
    String confirm;
    String empNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);





        Button submit1 = (Button) findViewById(R.id.button3);

        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText surnameTXT=(EditText) findViewById(R.id.editText6) ;
                EditText usernameTXT=(EditText) findViewById(R.id.editText5) ;
                EditText passwordTXT=(EditText) findViewById(R.id.editText3) ;
                EditText confirmTXT=(EditText) findViewById(R.id.editText4) ;
                EditText empTXT=(EditText) findViewById(R.id.editText8) ;


                surname=surnameTXT.getText().toString();
                username=usernameTXT.getText().toString();
                password=passwordTXT.getText().toString();
                confirm=confirmTXT.getText().toString();
                empNo=empTXT.getText().toString();
                EditText nameTXT=(EditText) findViewById(R.id.editText7) ;
                name=nameTXT.getText().toString();
               ParseObject faka= new ParseObject("UserInformation");

                final ProgressDialog dlg= new ProgressDialog(Register.this);
                dlg.setTitle("please wait");
                dlg.setMessage("Signing up. please wait.");
                dlg.show();

                            faka.put("Username",username);
                            faka.put("Password",password);
                            faka.put("Name",name);
                            faka.put("Password",password);
                            faka.put("Email",empNo);
                            faka.put("Vouchers",23);
                            faka.put("Surname",surname);
                                faka.saveInBackground(new SaveCallback() {
                                    @Override
                                    public void done(ParseException e) {

                                    }
                                });
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


    public static class Home extends AppCompatActivity {

        Button user ;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.home);

           user = (Button) findViewById(R.id.button10);
            user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = (new Intent(Home.this, MainActivity.class));
                    startActivity(intent);

                }


            });


        }

    }
}


