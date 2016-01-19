package com.cyw.oristone.basic;

import java.lang.reflect.Method;

import com.cyw.oristone.OriStoneException;
import com.cyw.oristone.ast.ASTree;

public class NativeFunction {
	// java.lang.reflect.Method  �ṩ���书��
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
        	//��һ���� ִ�и÷����Ķ��� ����static��������Ϊnull���ڶ�������ʵ������
            return method.invoke(null, args);
        } catch (Exception e) {
            throw new OriStoneException("bad native function call: " + name, tree);
        }
    }
}

