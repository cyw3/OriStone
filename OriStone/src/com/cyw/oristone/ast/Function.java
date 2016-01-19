package com.cyw.oristone.ast;

import com.cyw.oristone.basic.Environment;
import com.cyw.oristone.basic.NestedEnv;

public class Function {
    protected ParameterList parameters;
    protected BlockStmnt body;
    //�ⲿ������
    protected Environment env;
    public Function(ParameterList parameters, BlockStmnt body, Environment env) {
        this.parameters = parameters;
        this.body = body;
        this.env = env;
    }
    public ParameterList parameters() { return parameters; }
    
    /**
     * �����ӳ����е��ӳ��򹹳ɵ� AST
     * @return
     */
    public BlockStmnt body() { return body; }
    
    /**
     * ���ú���ʱ�����µĻ���
     * @return
     */
    public Environment makeEnv() { return new NestedEnv(env); }
    @Override public String toString() { return "<fun:" + hashCode() + ">"; }
}
