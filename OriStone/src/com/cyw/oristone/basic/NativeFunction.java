package com.cyw.oristone.basic;

import java.lang.reflect.Method;

import com.cyw.oristone.OriStoneException;
import com.cyw.oristone.ast.ASTree;

public class NativeFunction {
	// java.lang.reflect.Method  提供反射功能
    protected Method method;
    protected String name;
    protected int numParams;
    public NativeFunction(String n, Method m) {
        name = n;
        method = m;
        numParams = m.getParameterTypes().length;
    }
    @Override 
    public String toString() { return "<native:" + hashCode() + ">"; }
    
    public int numOfParameters() { return numParams; } 
    
    public Object invoke(Object[] args, ASTree tree) {
        try {
        	//第一参数 执行该方法的对象 若是static方法，则为null，第二参数是实参序列
            return method.invoke(null, args);
        } catch (Exception e) {
            throw new OriStoneException("bad native function call: " + name, tree);
        }
    }
}

