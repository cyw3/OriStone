package com.cyw.oristone.oriclass;

import java.util.List;

import javassist.gluonj.Require;
import javassist.gluonj.Reviser;

import com.cyw.oristone.OriStoneException;
import com.cyw.oristone.ast.ASTree;
import com.cyw.oristone.ast.ClassBody;
import com.cyw.oristone.ast.ClassStmnt;
import com.cyw.oristone.ast.Dot;
import com.cyw.oristone.ast.PrimaryExpr;
import com.cyw.oristone.basic.BasicEvaluator;
import com.cyw.oristone.basic.BasicEvaluator.ASTreeEx;
import com.cyw.oristone.basic.Environment;
import com.cyw.oristone.basic.FuncEvaluator;
import com.cyw.oristone.basic.FuncEvaluator.EnvEx;
import com.cyw.oristone.basic.FuncEvaluator.PrimaryEx;
import com.cyw.oristone.basic.NestedEnv;
import com.cyw.oristone.oriclass.OriStoneObject.AccessException;

/**
 * 对解释器的个对象的eval方法进行修改
 * @author cyw
 *
 */
@Require(FuncEvaluator.class)
@Reviser public class ClassEvaluator {
    @Reviser public static class ClassStmntEx extends ClassStmnt {
        public ClassStmntEx(List<ASTree> c) { super(c); }
        public Object eval(Environment env) {
            ClassInfo ci = new ClassInfo(this, env);
            ((EnvEx)env).put(name(), ci);
            return name();
        }
    }
    @Reviser public static class ClassBodyEx extends ClassBody {
        public ClassBodyEx(List<ASTree> c) { super(c); }
        public Object eval(Environment env) {
            for (ASTree t: this)
                ((ASTreeEx)t).eval(env);
            return null;
        }
    }
    @Reviser public static class DotEx extends Dot {
        public DotEx(List<ASTree> c) { super(c); }
        public Object eval(Environment env, Object value) {
            String member = name();
            if (value instanceof ClassInfo) {
                if ("new".equals(member)) {
                    ClassInfo ci = (ClassInfo)value;
                    NestedEnv e = new NestedEnv(ci.environment());
                    OriStoneObject so = new OriStoneObject(e);
                    e.putNew("this", so);
                    initObject(ci, e);
                    return so;
                }
            }
            else if (value instanceof OriStoneObject) {
                try {
					return ((OriStoneObject)value).read(member);
				} catch (AccessException e) {
					e.printStackTrace();
				}
            }
            throw new OriStoneException("bad member access: " + member, this);
        }
        protected void initObject(ClassInfo ci, Environment env) {
            if (ci.superClass() != null)
                initObject(ci.superClass(), env);
            ((ClassBodyEx)ci.body()).eval(env);
        }
    }
    @Reviser public static class AssignEx extends BasicEvaluator.BinaryEx {
        public AssignEx(List<ASTree> c) { super(c); }
        @Override
        protected Object computeAssign(Environment env, Object rvalue) {
            ASTree le = left();
            if (le instanceof PrimaryExpr) {
                PrimaryEx p = (PrimaryEx)le;
                if (p.hasPostfix(0) && p.postfix(0) instanceof Dot) {
                    Object t = ((PrimaryEx)le).evalSubExpr(env, 1);
                    if (t instanceof OriStoneObject)
                        return setField((OriStoneObject)t, (Dot)p.postfix(0),
                                        rvalue);
                }
            }
            return super.computeAssign(env, rvalue);
        }
        protected Object setField(OriStoneObject obj, Dot expr, Object rvalue) {
            String name = expr.name();
            try {
                obj.write(name, rvalue);
                return rvalue;
            } catch (AccessException e) {
                throw new OriStoneException("bad member access " + location()
                                         + ": " + name);
            }
        }
    }
}
