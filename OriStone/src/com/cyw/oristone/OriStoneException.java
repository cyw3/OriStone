package com.cyw.oristone;

public class OriStoneException extends RuntimeException {
	public OriStoneException(String m){
		super(m);
	}
//	public OriStoneException(String m, ASTree t){
//		super(m+" "+t.location());
//	}
}
