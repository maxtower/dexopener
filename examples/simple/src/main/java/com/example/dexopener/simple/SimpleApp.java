package com.example.dexopener.simple;

import android.app.Application;

public class SimpleApp extends Application {

    public String getName() {
        return "SimpleApp";
    }

    public Integer getData() {
        return 17;
    }
}
