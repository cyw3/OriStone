package com.cyw.oristone;

import com.cyw.oristone.basic.Natives;
import com.cyw.oristone.basic.NestedEnv;

public class NativeInterpreter extends BasicInterpreter {
	
	/**
	 * һ��ʼ�Ƚ�ԭ�����������뻷��֮��
	 * ������ʱ����ԭ����������ʶ��
	 * �ӻ����е���ԭ��������invoke()���ڵ��õ�Natives���е�static����
	 * @param args
	 * @throws ParseException
	 */
    public static void main(String[] args) throws ParseException {
        run(new ClosureParser(),
            new Natives().environment(new NestedEnv()));
    }
}
