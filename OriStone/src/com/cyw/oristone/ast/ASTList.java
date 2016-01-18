package com.cyw.oristone.ast;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ASTList extends ASTree {
	protected List<ASTree> children;
	
	public ASTList(List<ASTree> list){ children = list; }

	public void forEach(Consumer<? super ASTree> arg0) {
	}

	public Spliterator<ASTree> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ASTree child(int i) {
		return children.get(i);
	}

	@Override
	public int numChildren() {
		return children.size();
	}

	@Override
	public Iterator<ASTree> children() {
		return children.iterator();
	}

	@Override
	public String location() {
		for(ASTree t: children){
			String s = t.location();
			if(s!=null)
				return s;
		}
		return null;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append('(');
		String sep = "";
		for(ASTree t: children){
			builder.append(sep);
			sep = " ";
			builder.append(t.toString());
		}
		return builder.append(')').toString();
	}

}
