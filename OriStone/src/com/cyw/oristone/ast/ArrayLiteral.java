package com.cyw.oristone.ast;

import java.util.List;

/**
 * ����������
 * @author cyw
 *
 */
public class ArrayLiteral extends ASTList {

	public ArrayLiteral(List<ASTree> list) {
		super(list);
	}
	public int size(){
		return numChildren();
	}

}
