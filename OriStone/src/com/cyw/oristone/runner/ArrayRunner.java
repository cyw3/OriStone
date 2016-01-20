package com.cyw.oristone.runner;

import javassist.gluonj.util.Loader;

import com.cyw.oristone.ClosureEvaluator;
import com.cyw.oristone.array.ArrayEvaluator;
import com.cyw.oristone.basic.NativeEvaluator;
import com.cyw.oristone.oriclass.ClassEvaluator;
import com.cyw.oristone.oriclass.ClassInterpreter;

public class ArrayRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(ClassInterpreter.class, args, ClassEvaluator.class,
                   ArrayEvaluator.class, NativeEvaluator.class,
                   ClosureEvaluator.class);
    }
/**
a =[2,3,4]
print a[1]
a[1]="three"
print "a[1]:"+a[1]
b=[["one",1],["two",2]]
print b[1][0]+": "+b[1][1]
 */
}
