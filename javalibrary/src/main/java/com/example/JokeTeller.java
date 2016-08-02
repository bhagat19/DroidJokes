package com.example;

import java.util.logging.Logger;


import sun.rmi.runtime.Log;

public class JokeTeller {
    public final String LOG_TAG = JokeTeller.class.getSimpleName();

    public String tellAJoke(){
        return "A lame joke from java lib";
    }

}
