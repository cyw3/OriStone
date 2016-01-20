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
     * 即是说，对象的方法还有字段，都将记录在该对象的环境之中
     */
    protected Environment env;
    public OriStoneObject(Environment e) { env = e; }
    
    @Override 
    public String toString() { 
    	return "<object:" + hashCode() + ">";
    }
    
    /**
     * 当read或者write的时候，都会首先通过getEnv方法查找记录了字段键值对的环境
     * 如果记录没有保存在任何环境之中，或者查找到的环境不是OriStone对象的成员（e==env不成立）
     * 解释器将会认为目标字段不存在并报错
     * e==env不成立，是说，搜索到的环境不是保存全局变量的环境（因为是嵌套的环境）
     * @param member
     * @return
     * @throws AccessException
     */
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
