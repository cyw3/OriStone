package com.cyw.oristone.runner;

import javassist.gluonj.util.Loader;

import com.cyw.oristone.ClosureEvaluator;
import com.cyw.oristone.NativeInterpreter;
import com.cyw.oristone.basic.NativeEvaluator;

public class NativeRunner {
    public static void main(String[] args) throws Throwable {
    	/**
    	 * 此处传入两个修改器
    	 * 当只传一个时，就只修改这一个。
    	 * 以此实现分割修改器，应需而用
    	 */
        Loader.run(NativeInterpreter.class, args, NativeEvaluator.class,
                   ClosureEvaluator.class);
    }
/**实例代码
def fib (n){
	if n<2 {
		n
	}else{
		fib(n-1)+fib(n-2)
	}
}

t = currentTime()
fib 15
print currentTime()-t+"msec"
 */
}

