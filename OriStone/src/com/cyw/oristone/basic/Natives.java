package com.cyw.oristone.basic;

import java.lang.reflect.Method;

import javax.swing.JOptionPane;

import com.cyw.oristone.OriStoneException;

/**
 * 此处为添加的原生函数
 * @author cyw
 *
 */
public class Natives {
    public Environment environment(Environment env) {
        appendNatives(env);
        return env;
    }
    
    /**
     * 添加的原生函数
     * @param env
     */
    protected void appendNatives(Environment env) {
        append(env, "print", Natives.class, "print", Object.class);
        append(env, "read", Natives.class, "read");
        append(env, "length", Natives.class, "length", String.class);
        append(env, "toInt", Natives.class, "toInt", Object.class);
        append(env, "currentTime", Natives.class, "currentTime");
        //
        append(env, "cyw", Natives.class, "cyw");
    }
    
    /**
     * 
     * @param env
     * @param name
     * @param clazz 需要添加的static方法的类
     * @param methodName  该方法的名称
     * @param params  该方法的参数类型
     */
    protected void append(Environment env, String name, Class<?> clazz,
                          String methodName, Class<?> ... params) {
        Method m;
        try {
            m = clazz.getMethod(methodName, params);
        } catch (Exception e) {
            throw new OriStoneException("cannot find a native function: "
                                     + methodName);
        }
        //创建NativeFunction，然后存入环境之中。
        //当使用到该函数是，判定为NativeFunction，然后invoke()
        env.put(name, new NativeFunction(methodName, m));
    }

    /**
     * native methods 要添加的类
     * @param obj
     * @return
     */
    public static int print(Object obj) {
        System.out.println(obj.toString());
        return 0;
    }
    public static String read() {
        return JOptionPane.showInputDialog(null);
    }
    public static int length(String s) { return s.length(); }
    public static int toInt(Object value) {
        if (value instanceof String)
            return Integer.parseInt((String)value);
        else if (value instanceof Integer)
            return ((Integer)value).intValue();
        else
            throw new NumberFormatException(value.toString());
    }
    private static long startTime = System.currentTimeMillis();
    public static int currentTime() {
        return (int)(System.currentTimeMillis() - startTime);
    }
    
    //test
    public static void cyw(){
    	System.out.println("cccccccccccccyyyyyyyyyyyyywwwwwwwww");
    }
}

