package com.cyw.oristone;

import com.cyw.oristone.basic.NestedEnv;

public class ClosureInterpreter extends BasicInterpreter{
    public static void main(String[] args) throws ParseException {
        run(new ClosureParser(), new NestedEnv());
    }
}
