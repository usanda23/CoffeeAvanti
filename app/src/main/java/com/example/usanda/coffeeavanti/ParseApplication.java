package com.example.usanda.coffeeavanti;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
    public static final String YOUR_APPLICATION_ID = "G7S25vITx0tfeOhODauYKwtauCvzityLwJFGYHPw";
    public static final String YOUR_CLIENT_KEY = "A14vvfQB1kLY5KMpucrWc2CoR7583zW6dZrOHiAQ";

    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, YOUR_APPLICATION_ID, YOUR_CLIENT_KEY);

        // ...
    }
}