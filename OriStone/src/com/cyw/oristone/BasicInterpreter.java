package com.cyw.oristone;

import com.cyw.oristone.ast.ASTree;
import com.cyw.oristone.ast.NullStmnt;
import com.cyw.oristone.basic.BasicEnv;
import com.cyw.oristone.basic.BasicEvaluator;
import com.cyw.oristone.basic.Environment;

/**
 * ½âÊÍÆ÷µÄ³ÌÐò
 * @author cyw
 *
 */
public class BasicInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new BasicParser(), new BasicEnv());
    }
    public static void run(BasicParser bp, Environment env)
        throws ParseException
    {
        Lexer lexer = new Lexer(new CodeDialog());
        while (lexer.peek(0) != Token.EOF) {
            ASTree t = bp.parse(lexer);
            if (!(t instanceof NullStmnt)) {
                Object r = ((BasicEvaluator.ASTreeEx)t).eval(env);
                System.out.println(">>> " + r);
            }
        }
    }
}
