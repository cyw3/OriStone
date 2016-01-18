package com.cyw.oristone.ast;

import com.cyw.oristone.Token;

public class Name extends ASTLeaf {

	public Name(Token t) {
		super(t);
	}
	public String name(){
		return token.getText();
	}

}
