package com.cyw.oristone.basic;

import java.util.HashMap;

import com.cyw.oristone.basic.FuncEvaluator.EnvEx;

/**
 * 实现环境嵌套结构
 * @author cyw
 *
 */
public class NestedEnv implements Environment {
    protected HashMap<String,Object> values;
    
    /**
     * outer引用的是与外侧一层作用域对应的环境
     */
    protected Environment outer;
    
    public NestedEnv() { this(null); }
    public NestedEnv(Environment e) {
        values = new HashMap<String,Object>();
        outer = e;
    }
    
    public void setOuter(Environment e) { 
    	outer = e;
    }
    
    /**
     * 添加修改，以便查找与外层作用域中的变量
     */
    public Object get(String name) {
        Object v = values.get(name);
        if (v == null && outer != null)
            return outer.get(name);
        else
            return v;
    }
    
    /**
     * 添加新变量到当前环境中，不会添加到外部环境中
     * @param name
     * @param value
     */
    public void putNew(String name, Object value) { 
    	values.put(name, value); 
    }
    
    public void put(String name, Object value) {
        Environment e = where(name);
        if (e == null)
            e = this;
        ((EnvEx) e).putNew(name, value);
    }
    
    /**
     * 查找包含指定变量名的环境并返回所在环境
     * @param name
     * @return
     */
    public Environment where(String name) {
        if (values.get(name) != null)
            return this;
        else if (outer == null)
            return null;
        else
            return ((EnvEx) outer).where(name);
    }
}
