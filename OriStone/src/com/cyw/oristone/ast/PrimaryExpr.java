package com.cyw.oristone.ast;

import java.util.List;

public class PrimaryExpr extends ASTList {

	public PrimaryExpr(List<ASTree> list) {
		super(list);
	}

	/**
	 * ǩ������
	 * ��Parser��Ϊ�����﷨�������µĽڵ����ʱ��������create������Parser�⽫����ֱ�Ӵ���
	 * ����Ķ��󣬶��ǻ����create�������������ص�ֵ��Ϊ�ڵ����
	 * @param c
	 * @return
	 */
	public static ASTree create(List<ASTree> c){
		return c.size() == 1 ? c.get(0):new PrimaryExpr(c);
	}
}
