package com.cyw.oristone.runner;

import javassist.gluonj.util.Loader;

import com.cyw.oristone.ClosureEvaluator;
import com.cyw.oristone.NativeInterpreter;
import com.cyw.oristone.basic.NativeEvaluator;

public class NativeRunner {
    public static void main(String[] args) throws Throwable {
    	/**
    	 * �˴����������޸���
    	 * ��ֻ��һ��ʱ����ֻ�޸���һ����
    	 * �Դ�ʵ�ַָ��޸�����Ӧ�����
    	 */
        Loader.run(NativeInterpreter.class, args, NativeEvaluator.class,
                   ClosureEvaluator.class);
    }
/**ʵ������
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

