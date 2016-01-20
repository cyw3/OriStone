package com.cyw.oristone.oriclass;

import com.cyw.oristone.basic.Environment;
import com.cyw.oristone.basic.FuncEvaluator.EnvEx;

/**
 * OriStone的超父类，如同java之中的Object
 * 主要是用于保存OriStone语言对象的字段值，是字段名称与字段值的对应关系表
 * 采用闭包的方式
 * @author cyw
 *
 */
public class OriStoneObject {
	
    public static class AccessException extends Exception {}
    
    /**
     * 在通过.new方法创建新的OriStone对象时，解释器将首先创建新的环境。OriStone对象
     * 将保存这一环境，并向该环境添加有名称this与自身组成的键值对
     */
    protected Environment env;
    public OriStoneObject(Environment e) { env = e; }
    
    @Override 
    public String toString() { 
    	return "<object:" + hashCode() + ">";
    }
    
    public Object read(String member) throws AccessException {
        return getEnv(member).get(member);
    }
    /**
     * 实现赋值操作
     * @param member
     * @param value
     * @throws AccessException
     */
    public void write(String member, Object value) throws AccessException {
        ((EnvEx)getEnv(member)).putNew(member, value);
    }
    
    /**
     * 嵌套的环境
     * @param member
     * @return
     * @throws AccessException
     */
    protected Environment getEnv(String member) throws AccessException {
        Environment e = ((EnvEx)env).where(member);
        if (e != null && e == env)
            return e;
        else
            throw new AccessException();
    }
}
