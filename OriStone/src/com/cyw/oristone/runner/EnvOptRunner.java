package com.cyw.oristone.runner;

import javassist.gluonj.util.Loader;

import com.cyw.oristone.basic.EnvOptInterpreter;
import com.cyw.oristone.basic.EnvOptimizer;
import com.cyw.oristone.basic.NativeEvaluator;

public class EnvOptRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(EnvOptInterpreter.class, args, EnvOptimizer.class,
                                                  NativeEvaluator.class);
    }
}
