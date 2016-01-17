package com.cyw.oristone;

/**
 * ��������:
 * ��ʶ��(���ơ�����������ţ�������)������������(����ֵ���ַ�����)���ַ���������
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
