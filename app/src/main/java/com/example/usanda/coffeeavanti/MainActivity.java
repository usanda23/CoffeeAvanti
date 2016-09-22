package com.example.usanda.coffeeavanti;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    Button button2;
    Button button1;
    TextView view5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1 = (Button) findViewById(R.id.logonBTN);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText usernameTXT = (EditText) findViewById(R.id.editText);
                EditText passwordTXT = (EditText) findViewById(R.id.editText2);


                String username = usernameTXT.getText().toString();
                String password = passwordTXT.getText().toString();
                Order.setUsername(username);
                final ProgressDialog dlg = new ProgressDialog(MainActivity.this);
                dlg.setTitle("please wait");
                dlg.setMessage("signing up. please wait");
                dlg.show();

                ParseQuery<ParseObject> query = ParseQuery.getQuery("UserInformation");
                query.whereEqualTo("Username", username);
                query.whereEqualTo("Password", password);
                query.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> results, ParseException e) {
                        if (e == null) {
                            if (results.size() > 0) {
                                // query found a user

                                Intent intent = (new Intent(MainActivity.this, Order.class));
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);

                            } else {


                            }
                        } else {
                            // error
                        }
                    }

                });

                /*ParseUser.logInInBackground(username, password, new LogInCallback() {
                    public void done(ParseUser UserInformation, ParseException e) {
                        if (UserInformation != null) {

                               dlg.dismiss();
                               Intent intent = (new Intent(MainActivity.this, Order.class));
                               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                               startActivity(intent);
                        } else {
                            // Signup failed.  ----------ParseException
                        }
                    }
                });*/
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
        view5 = (TextView) findViewById(R.id.textView3);
        view5.setOnClickListener(new View.OnClickListener() {

                                     @Override
                                     public void onClick(View v) {
                                         Intent intent = (new Intent(MainActivity.this, Forgot.class));
                                         startActivity(intent);


                                     }

                                 }
        );
    }

}
