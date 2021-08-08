package com.example.stockapp;


import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Stock.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("icwjtzXiGyaSo1ZISDrlBkNawJ87NVlu1bF2dk8J")
                .clientKey("yLLx7yP2N95vQnzEIvjrpi7CVnieDNiYSxLE1yPt")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
