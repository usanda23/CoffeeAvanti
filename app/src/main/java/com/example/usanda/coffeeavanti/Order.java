package com.example.usanda.coffeeavanti;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.app.Activity;
import android.view.Menu;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.util.ArrayList;

public class Order extends AppCompatActivity {
    final Context context = this;
    String[] mobileArray = {"Espresso","Cafe Americano","Cappuccino","Latte","Flavoured Capuccino","Red Latte","Red Cappuccino","Hot Chocolate","Cafe Mocha",""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
     final   ArrayList<String> arr=new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<>(this,  R.layout.listitem, R.id.textview, mobileArray);
      final  ListView listView = (ListView) findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
       // listView.setItemsCanFocus(false);
        listView.setItemChecked(2, true);
        listView.setAdapter(adapter);
       final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        final ParseObject insert= new ParseObject("Orders");


        Button hook = (Button) findViewById(R.id.button5);
        hook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {

// Dialog box
                        arr.add(mobileArray[position]);


                        // TODO Auto-generated method stub
                        // Toast.makeText(Order.this, mobileArray[position], Toast.LENGTH_SHORT).show();
                    }
                });

                String temp = "";
                for(String elementItems : arr){
temp += elementItems +"\n";

                }
                alertDialogBuilder.setMessage(temp.trim());

                alertDialogBuilder.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                               String username= getusername();
                                System.out.println("Hello");
                                System.out.println(username);
                                insert.put("PersonOrdered",username);
                                insert.put("OrderList",arr);
                                insert.put("Price","false");
                                insert.saveInBackground(new SaveCallback() {
                                    @Override
                                    public void done(ParseException e) {

                                    }
                                });
                            }
                        });

                alertDialogBuilder.setNegativeButton("cancel",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                             arr.clear();
                            }
                        });

                dialogBox();
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


               // Intent intent = (new Intent(Order.this, Home.class));
               // startActivity(intent);

            }
            public void dialogBox() {

            }

        });





        Button cancel = (Button) findViewById(R.id.button6);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = (new Intent(Order.this, Register.Home.class));
                startActivity(intent);

            }


        });


    }
   static String user = "";
   static public  void setUsername(String user){
       Order.user = user;
    }
   static public String getusername(){
        return  user;
    }

}
