package com.cyw.oristone.oriclass;

import com.cyw.oristone.BasicInterpreter;
import com.cyw.oristone.ParseException;
import com.cyw.oristone.basic.Natives;
import com.cyw.oristone.basic.NestedEnv;

public class ClassInterpreter extends BasicInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new ClassParser(), new Natives().environment(new NestedEnv())); 
    }
}

