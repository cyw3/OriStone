package com.cyw.oristone.ast;

import java.util.List;

/**
 * 数组字面量
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
