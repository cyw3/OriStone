package com.cyw.oristone.basic;

/**
 * ��������environment���������ڱ���������
 * @author cyw
 *
 */
public interface Environment {
    void put(String name, Object value);
    Object get(String name);
}
