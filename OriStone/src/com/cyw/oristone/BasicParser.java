package com.cyw.oristone;

import static com.cyw.oristone.Parser.rule;

import java.util.HashSet;

import com.cyw.oristone.Parser.Operators;
import com.cyw.oristone.ast.ASTree;
import com.cyw.oristone.ast.BinaryExpr;
import com.cyw.oristone.ast.BlockStmnt;
import com.cyw.oristone.ast.IfStmnt;
import com.cyw.oristone.ast.Name;
import com.cyw.oristone.ast.NegativeExpr;
import com.cyw.oristone.ast.NullStmnt;
import com.cyw.oristone.ast.NumberLiteral;
import com.cyw.oristone.ast.PrimaryExpr;
import com.cyw.oristone.ast.StringLiteral;
import com.cyw.oristone.ast.WhileStmnt;

/**
 * DSL :专业领域语言
 * 自动生成抽象语法树
 * @author cyw
 *
 */
//public class BasicParser {
//
//	//将当做IDENTIFIER构造函数的参数，其中包含的标识符无法作为变量名使用
//	HashSet<String> reserved = new HashSet<String>();
//	Operators operators = new Operators();
//	
//	//语法的定义是递归的。所以需要这个
//	//语法处理器可以通过该对象一次创建于primary及factor对应的Parser对象，
//	//最后在使用factor将正确的模式添加至expr0，完成一系列的处理
//	Parser expr0 = rule();
//	Parser primary = rule(PrimaryExpr.class)
//			.or(rule().sep("(").ast(expr0).sep(")"),
//					rule().number(NumberLiteral.class),
//					rule().identifier(Name.class,reserved),
//					rule().string(StringLiteral.class));
//	Parser factor = rule().or(rule(NegativeExpr.class).sep("-").ast(primary),primary);
//	Parser expr = expr0.expression(BinaryExpr.class,factor, operators);
//	
//	Parser statement0 = rule();
//	Parser block = rule(BlockStmnt.class).sep("{").option(statement0)
//			.repeat(rule().sep(";",Token.EOL).option(statement0))
//			.sep("}");
//	Parser simple = rule(PrimaryExpr.class).ast(expr);
//	Parser statement = statement0.or(
//			rule(IfStmnt.class).sep("if").ast(expr).ast(block)
//										.option(rule().sep("else").ast(block)),
//			rule(WhileStmnt.class).sep("while").ast(expr).ast(block),simple);
//	
//	Parser program = rule().or(statement, rule(NullStmnt.class)).sep(";", Token.EOL);
//	
//	public BasicParser(){
//		reserved.add(";");
//		reserved.add("}");
//		reserved.add(Token.EOL);
//		
//		
//		//add参数分别是：表示运算符的字符串、优先级（值越大，优先级越高）、左右结合顺序（左右侧的优先级较高）
//		operators.add("=", 1, Operators.RIGHT);
//		operators.add("==", 2, Operators.LEFT);
//		operators.add(">", 2, Operators.LEFT);
//		operators.add("<", 2, Operators.LEFT);
//		operators.add("+", 3, Operators.LEFT);
//		operators.add("-", 3, Operators.LEFT);
//		operators.add("*", 4, Operators.LEFT);
//		operators.add("/", 4, Operators.LEFT);
//		operators.add("%", 4, Operators.LEFT);
//	}
//	
//	/**
//	 * 从词法分析器逐一读取非终结符program。以语句为单位读取单词，并进行语法分析。
//	 * 返回一个抽象语法树
//	 * 类似LISP的S表达式
//	 * @param lexer
//	 * @return
//	 * @throws ParseException
//	 */
//	public ASTree parse(Lexer lexer) throws ParseException{
//		return program.parse(lexer);
//	}
//			
//}

public class BasicParser {
    protected HashSet<String> reserved = new HashSet<String>();
    Operators operators = new Operators();
    Parser expr0 = rule();
    protected Parser primary = rule(PrimaryExpr.class)
        .or(rule().sep("(").ast(expr0).sep(")"),
            rule().number(NumberLiteral.class),
            rule().identifier(Name.class, reserved),
            rule().string(StringLiteral.class));
    Parser factor = rule().or(rule(NegativeExpr.class).sep("-").ast(primary),
                              primary);                               
    protected Parser expr = expr0.expression(BinaryExpr.class, factor, operators);

    Parser statement0 = rule();
    Parser block = rule(BlockStmnt.class)
        .sep("{").option(statement0)
        .repeat(rule().sep(";", Token.EOL).option(statement0))
        .sep("}");
    protected Parser simple = rule(PrimaryExpr.class).ast(expr);
    Parser statement = statement0.or(
            rule(IfStmnt.class).sep("if").ast(expr).ast(block)
                               .option(rule().sep("else").ast(block)),
            rule(WhileStmnt.class).sep("while").ast(expr).ast(block),
            simple);

    protected Parser program = rule().or(statement, rule(NullStmnt.class))
                           .sep(";", Token.EOL);

    public BasicParser() {
        reserved.add(";");
        reserved.add("}");
        reserved.add(Token.EOL);

        operators.add("=", 1, Operators.RIGHT);
        operators.add("==", 2, Operators.LEFT);
        operators.add(">", 2, Operators.LEFT);
        operators.add("<", 2, Operators.LEFT);
        operators.add("+", 3, Operators.LEFT);
        operators.add("-", 3, Operators.LEFT);
        operators.add("*", 4, Operators.LEFT);
        operators.add("/", 4, Operators.LEFT);
        operators.add("%", 4, Operators.LEFT);
    }
    public ASTree parse(Lexer lexer) throws ParseException {
        return program.parse(lexer);
    }
}

