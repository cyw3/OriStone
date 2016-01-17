package com.cyw.test;

import com.cyw.oristone.*;

/**
 * 验证词法分析器
 * @author cyw
 *
 */
public class LexerRunner {
	public static void main(String [] args) throws ParseException{
		Lexer l = new Lexer(new CodeDialog());
		for(Token t;(t=l.read())!=Token.EOF;)
			System.out.println("=> "+t.getText());
	}

}
