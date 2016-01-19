package com.cyw.oristone.basic;

import java.util.List;

import javassist.gluonj.Require;
import javassist.gluonj.Reviser;

import com.cyw.oristone.OriStoneException;
import com.cyw.oristone.ast.ASTree;
import com.cyw.oristone.basic.BasicEvaluator.ASTreeEx;

@Require(FuncEvaluator.class)
@Reviser public class NativeEvaluator {
    @Reviser public static class NativeArgEx extends FuncEvaluator.ArgumentsEx {
        public NativeArgEx(List<ASTree> c) { super(c); }
        @Override public Object eval(Environment callerEnv, Object value) {
        	//判断是否是原生函数
            if (!(value instanceof NativeFunction))
                return super.eval(callerEnv, value);

            NativeFunction func = (NativeFunction)value;
            int nparams = func.numOfParameters();
            if (size() != nparams)
                throw new OriStoneException("bad number of arguments", this);
            Object[] args = new Object[nparams];
            int num = 0;
            for (ASTree a: this) {
                ASTreeEx ae = (ASTreeEx)a;
                args[num++] = ae.eval(callerEnv);
            }
            return func.invoke(args, this);
        }
    }
}

