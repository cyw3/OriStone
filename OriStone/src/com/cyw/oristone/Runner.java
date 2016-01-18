package com.cyw.oristone;

import com.cyw.oristone.basic.BasicEvaluator;

import javassist.gluonj.util.Loader;

/**
 * 解释器的启动程序
 * @author cyw
 *
 */
public class Runner {
    public static void main(String[] args) throws Throwable {
    	/*
    	 * 因为使用了GluonJ，所以在启动时执行以下代码，用修改器修改相关的类，最后执行解释器
    	 * run方法将调用第一个参数接受的类中的main方法，执行程序。
    	 * 第二参数是第一参数中main方法的参数
    	 * 第三参数是执行程序所需的修改器，是个可变长参数，能指定任意多个修改器，
    	 * 所有指定修改器都执行完毕之后，main方法才被调用。
    	 */
        Loader.run(BasicInterpreter.class, args, BasicEvaluator.class);
    }
//    以下是示例代码
//    sum = 0
//    		i = 1
//    		while i<10 {
//    			sum = sum +i;
//    			i = i+1;
//    		}
//    		sum
}
