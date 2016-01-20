package com.cyw.oristone.oriclass;

import com.cyw.oristone.basic.Environment;
import com.cyw.oristone.basic.FuncEvaluator.EnvEx;

/**
 * OriStone�ĳ����࣬��ͬjava֮�е�Object
 * ��Ҫ�����ڱ���OriStone���Զ�����ֶ�ֵ�����ֶ��������ֶ�ֵ�Ķ�Ӧ��ϵ��
 * ���ñհ��ķ�ʽ
 * @author cyw
 *
 */
public class OriStoneObject {
	
    public static class AccessException extends Exception {}
    
    /**
     * ��ͨ��.new���������µ�OriStone����ʱ�������������ȴ����µĻ�����OriStone����
     * ��������һ����������û������������this��������ɵļ�ֵ��
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
     * ʵ�ָ�ֵ����
     * @param member
     * @param value
     * @throws AccessException
     */
    public void write(String member, Object value) throws AccessException {
        ((EnvEx)getEnv(member)).putNew(member, value);
    }
    
    /**
     * Ƕ�׵Ļ���
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
