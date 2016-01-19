package com.cyw.oristone;

import com.cyw.oristone.basic.NestedEnv;

public class FuncInterpreter extends BasicInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new FuncParser(), new NestedEnv());
    }
}

