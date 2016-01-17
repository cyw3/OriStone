package com.cyw.oristone;

/**
 * 单词类型:
 * 标识符(名称、运算符，符号，保留字)、整型字面量(整数值的字符序列)、字符串字面量
 * @author cyw
 */
public abstract class Token {
	//end of file
	public static final Token EOF = new Token(-1){};
	//end 0f line
	public static final String EOL = "\\n";
	private int lineNumber;
	
	protected Token(int line) {
		lineNumber = line;
	}
	
	public int getLineNumber(){
		return lineNumber;
	}
	public boolean isIdentifier(){
		return false;
	}
	public boolean isNumber(){
		return false;
	}
	public boolean isString(){
		return false;
	}
	public int getNumber(){
		throw new OriStoneException("not number token");
	}
	public String getText(){
		return "";
	}

}
