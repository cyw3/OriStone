package com.cyw.oristone.runner;

import javassist.gluonj.util.Loader;

import com.cyw.oristone.FuncInterpreter;
import com.cyw.oristone.basic.FuncEvaluator;

public class FuncRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(FuncInterpreter.class, args, FuncEvaluator.class);
    }
    
/**ÊµÀý¡£ì³²¨ÄÇÆõÊý
def fib(n){
	if n<2 {
		n
	}else{
		fib(n-1)+fib(n-2)
	}
}

fib(10)
fib

 */
}
