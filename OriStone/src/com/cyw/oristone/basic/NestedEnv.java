package com.cyw.oristone.basic;

import java.util.HashMap;

import com.cyw.oristone.basic.FuncEvaluator.EnvEx;

/**
 * ʵ�ֻ���Ƕ�׽ṹ
 * @author cyw
 *
 */
public class NestedEnv implements Environment {
    protected HashMap<String,Object> values;
    
    /**
     * outer���õ��������һ���������Ӧ�Ļ���
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
     * ����޸ģ��Ա����������������еı���
     */
    public Object get(String name) {
        Object v = values.get(name);
        if (v == null && outer != null)
            return outer.get(name);
        else
            return v;
    }
    
    /**
     * ����±�������ǰ�����У�������ӵ��ⲿ������
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
     * ���Ұ���ָ���������Ļ������������ڻ���
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
