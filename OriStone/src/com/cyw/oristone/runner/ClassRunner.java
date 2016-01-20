package com.cyw.oristone.runner;

import javassist.gluonj.util.Loader;

import com.cyw.oristone.ClosureEvaluator;
import com.cyw.oristone.basic.NativeEvaluator;
import com.cyw.oristone.oriclass.ClassEvaluator;
import com.cyw.oristone.oriclass.ClassInterpreter;

public class ClassRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(ClassInterpreter.class, args, ClassEvaluator.class,
                   NativeEvaluator.class, ClosureEvaluator.class);
    }
}
/**ÊµÀý´úÂë
class Position{
	x=y=0
	def move(nx,ny){
		x=nx;y=nu
	}
}
 */

