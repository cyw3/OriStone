package com.cyw.oristone.ast;

import java.util.List;

/**
 * ����
 * @author cyw
 *
 */
public class NegativeExpr extends ASTList {

	public NegativeExpr(List<ASTree> list) {
		super(list);
	}
	public ASTree operand(){
		return child(0);
	}
	public String toString(){
		return "-"+operand();
	}

}
