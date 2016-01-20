package com.cyw.oristone.oriclass;

import com.cyw.oristone.OriStoneException;
import com.cyw.oristone.ast.ClassBody;
import com.cyw.oristone.ast.ClassStmnt;
import com.cyw.oristone.basic.Environment;

/**
 * 保存类定义的信息
 * 其对象保存了class语句的抽象语法树
 * @author cyw
 *
 */
public class ClassInfo {
	//保存类定义的语句
    protected ClassStmnt definition;
    protected Environment environment;
    protected ClassInfo superClass;
    
    public ClassInfo(ClassStmnt cs, Environment env) {
        definition = cs;
        environment = env;
        Object obj = env.get(cs.superClass());
        if (obj == null)
            superClass = null;
        else if (obj instanceof ClassInfo)
            superClass = (ClassInfo)obj;
        else
            throw new OriStoneException("unknown super class: " + cs.superClass(),
                                     cs);
    }
    public String name() { return definition.name(); }
    public ClassInfo superClass() { return superClass; }
    public ClassBody body() { return definition.body(); }
    public Environment environment() { return environment; }
    @Override 
    public String toString() { return "<class " + name() + ">"; }
}
