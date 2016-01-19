package com.cyw.oristone;

import javassist.gluonj.util.Loader;

public class ClosureRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(ClosureInterpreter.class, args, ClosureEvaluator.class);
    }

/**ÊµÀý´úÂë
inc=fun(x){ x+1}
inc(3)
 */
}
