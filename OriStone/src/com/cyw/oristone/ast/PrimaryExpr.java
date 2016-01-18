package com.cyw.oristone.ast;

import java.util.List;

public class PrimaryExpr extends ASTList {

	public PrimaryExpr(List<ASTree> list) {
		super(list);
	}

	/**
	 * 签名方法
	 * 在Parser库为抽象语法树创建新的节点对象时，若含有create方法。Parser库将不会直接创建
	 * 该类的对象，而是会调用create方法，并将返回的值作为节点对象
	 * @param c
	 * @return
	 */
	public static ASTree create(List<ASTree> c){
		return c.size() == 1 ? c.get(0):new PrimaryExpr(c);
	}
}
