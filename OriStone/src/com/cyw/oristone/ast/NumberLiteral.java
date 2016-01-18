package com.cyw.oristone.ast;

import com.cyw.oristone.Token;

public class NumberLiteral extends ASTLeaf {

	public NumberLiteral(Token t) {
		super(t);
	}
	public int value(){
		return token.getNumber();
	}
}
