package com.cyw.oristone.array;

import java.util.List;

import javassist.gluonj.Require;
import javassist.gluonj.Reviser;

import com.cyw.oristone.OriStoneException;
import com.cyw.oristone.ast.ASTree;
import com.cyw.oristone.ast.ArrayLiteral;
import com.cyw.oristone.ast.PrimaryExpr;
import com.cyw.oristone.basic.BasicEvaluator;
import com.cyw.oristone.basic.BasicEvaluator.ASTreeEx;
import com.cyw.oristone.basic.Environment;
import com.cyw.oristone.basic.FuncEvaluator;
import com.cyw.oristone.basic.FuncEvaluator.PrimaryEx;

@Require({FuncEvaluator.class, ArrayParser.class})
@Reviser public class ArrayEvaluator {
	
	/**
	 * ������ClassEvaluator�޸���
	 * �����޸�������������ʱ�򣬿���ͬʱ��ӣ�ͬʱ�޸�
	 * ����ͨ���޸������������
	 * @author cyw
	 *
	 */
    @Reviser public static class ArrayLitEx extends ArrayLiteral {
        public ArrayLitEx(List<ASTree> list) { super(list); }
        
        /**
         * OriStone���齫ͨ��java�����е�Object���͵�������ʵ��
         * eval�������ζ�Ԫ�ر�ʾ�ı��ʽ����eval������Ȼ�󴴽�һ���з���ֵ��ɵ�Object��������
         * ������
         * @param env
         * @return
         */
        public Object eval(Environment env) {
            int s = numChildren();
            Object[] res = new Object[s];
            int i = 0;
            for (ASTree t: this)
                res[i++] = ((ASTreeEx)t).eval(env);
            return res;
        }
    }
    
    
    @Reviser public static class ArrayRefEx extends ArrayRef {
        public ArrayRefEx(List<ASTree> c) { super(c); }
        
        /**
         * ���Ӳ���valueָ��������Object�����л�ȡ�ĸ��±��Ӧ��Ԫ�صķ���ֵ������
         * @param env
         * @param value
         * @return
         */
        public Object eval(Environment env, Object value) {
            if (value instanceof Object[]) {
                Object index = ((ASTreeEx)index()).eval(env);
                if (index instanceof Integer)
                    return ((Object[])value)[(Integer)index];
            }

            throw new OriStoneException("bad array access", this);
        }
    }
    
    /**
     * �����鸳ֵ
     * @author cyw
     *
     */
    @Reviser public static class AssignEx extends BasicEvaluator.BinaryEx {
        public AssignEx(List<ASTree> c) { super(c); }
        @Override
        protected Object computeAssign(Environment env, Object rvalue) {
            ASTree le = left();
            if (le instanceof PrimaryExpr) {
                PrimaryEx p = (PrimaryEx)le;
                if (p.hasPostfix(0) && p.postfix(0) instanceof ArrayRef) {
                    Object a = ((PrimaryEx)le).evalSubExpr(env, 1);
                    if (a instanceof Object[]) {
                        ArrayRef aref = (ArrayRef)p.postfix(0);
                        Object index = ((ASTreeEx)aref.index()).eval(env);
                        if (index instanceof Integer) {
                            ((Object[])a)[(Integer)index] = rvalue;
                            return rvalue;
                        }
                    }
                    throw new OriStoneException("bad array access", this);
                }
            }
            return super.computeAssign(env, rvalue);
        }
    }       
}

