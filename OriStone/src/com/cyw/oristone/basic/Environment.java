package com.cyw.oristone.basic;

/**
 * 环境对象（environment），类似于变量管理器
 * @author cyw
 *
 */
public interface Environment {
    void put(String name, Object value);
    Object get(String name);
}
