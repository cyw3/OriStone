package com.cyw.oristone;

import java.util.List;

import javassist.gluonj.Require;
import javassist.gluonj.Reviser;

import com.cyw.oristone.ast.ASTree;
import com.cyw.oristone.ast.Fun;
import com.cyw.oristone.ast.Function;
import com.cyw.oristone.basic.Environment;
import com.cyw.oristone.basic.FuncEvaluator;

@Require(FuncEvaluator.class)
@Reviser public class ClosureEvaluator {
    @Reviser public static class FunEx extends Fun {
        public FunEx(List<ASTree> c) { super(c); }
        public Object eval(Environment env) {
        	//ֱ�ӷ���һ��function�����Դ�ʵ�ָ�ֵ���������ߴ��ݸ������Ĺ���
            return new Function(parameters(), body(), env);
        }
    }
}
