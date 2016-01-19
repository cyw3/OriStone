package com.cyw.oristone;

import com.cyw.oristone.basic.Natives;
import com.cyw.oristone.basic.NestedEnv;

public class NativeInterpreter extends BasicInterpreter {
	
	/**
	 * 一开始先将原生函数，存入环境之中
	 * 当运行时遇到原生函数，在识别，
	 * 从环境中调用原生函数，invoke()，在调用到Natives类中的static方法
	 * @param args
	 * @throws ParseException
	 */
    public static void main(String[] args) throws ParseException {
        run(new ClosureParser(),
            new Natives().environment(new NestedEnv()));
    }
}
