package com.cyw.oristone;

import com.cyw.oristone.basic.BasicEvaluator;

import javassist.gluonj.util.Loader;

/**
 * ����������������
 * @author cyw
 *
 */
public class Runner {
    public static void main(String[] args) throws Throwable {
    	/*
    	 * ��Ϊʹ����GluonJ������������ʱִ�����´��룬���޸����޸���ص��࣬���ִ�н�����
    	 * run���������õ�һ���������ܵ����е�main������ִ�г���
    	 * �ڶ������ǵ�һ������main�����Ĳ���
    	 * ����������ִ�г���������޸������Ǹ��ɱ䳤��������ָ���������޸�����
    	 * ����ָ���޸�����ִ�����֮��main�����ű����á�
    	 */
        Loader.run(BasicInterpreter.class, args, BasicEvaluator.class);
    }
//    ������ʾ������
//    sum = 0
//    		i = 1
//    		while i<10 {
//    			sum = sum +i;
//    			i = i+1;
//    		}
//    		sum
}
