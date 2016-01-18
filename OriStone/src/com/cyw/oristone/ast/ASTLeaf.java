package com.cyw.oristone.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import com.cyw.oristone.Token;

public class ASTLeaf extends ASTree {
	private static ArrayList<ASTree> empty = new ArrayList<ASTree>();
	protected Token token;
	
	public ASTLeaf(Token t){ token = t; }
	public Token token(){ return token; }

	public void forEach(Consumer<? super ASTree> arg0) {
	}

	public Spliterator<ASTree> spliterator() {
		return null;
	}

	@Override
	public ASTree child(int i) {
		throw new IndexOutOfBoundsException();
	}

	@Override
	public int numChildren() {
		return 0;
	}

	@Override
	public Iterator<ASTree> children() {
		return empty.iterator();
	}

	@Override
	public String location() {
		return "at line "+token.getLineNumber();
	}
	
	public String toString(){
		return token.getText();
	}

}
