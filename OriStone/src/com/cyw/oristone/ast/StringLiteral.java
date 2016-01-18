package com.cyw.oristone.ast;

import com.cyw.oristone.Token;

public class StringLiteral extends ASTLeaf {

	public StringLiteral(Token t) {
		super(t);
	}
	public String value(){
		return token().getText();
	}

}
