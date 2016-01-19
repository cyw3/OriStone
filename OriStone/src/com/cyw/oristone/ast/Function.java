package com.cyw.oristone.ast;

import com.cyw.oristone.basic.Environment;
import com.cyw.oristone.basic.NestedEnv;

public class Function {
    protected ParameterList parameters;
    protected BlockStmnt body;
    //外部环境。
    protected Environment env;
    public Function(ParameterList parameters, BlockStmnt body, Environment env) {
        this.parameters = parameters;
        this.body = body;
        this.env = env;
    }
    public ParameterList parameters() { return parameters; }
    
    /**
     * 返回子程序中的子程序构成的 AST
     * @return
     */
    public BlockStmnt body() { return body; }
    
    /**
     * 调用函数时创建新的环境
     * @return
     */
    public Environment makeEnv() { return new NestedEnv(env); }
    @Override public String toString() { return "<fun:" + hashCode() + ">"; }
}
