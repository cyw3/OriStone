package com.cyw.oristone.basic;

import com.cyw.oristone.BasicParser;
import com.cyw.oristone.ClosureParser;
import com.cyw.oristone.CodeDialog;
import com.cyw.oristone.Lexer;
import com.cyw.oristone.ParseException;
import com.cyw.oristone.Token;
import com.cyw.oristone.ast.ASTree;
import com.cyw.oristone.ast.NullStmnt;

public class EnvOptInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new ClosureParser(),
            new Natives().environment(new ResizableArrayEnv()));
    }
    public static void run(BasicParser bp, Environment env)
        throws ParseException
    {
        Lexer lexer = new Lexer(new CodeDialog());
        while (lexer.peek(0) != Token.EOF) {
            ASTree t = bp.parse(lexer);
            if (!(t instanceof NullStmnt)) {
                ((EnvOptimizer.ASTreeOptEx)t).lookup(
                        ((EnvOptimizer.EnvEx2)env).symbols());
                Object r = ((BasicEvaluator.ASTreeEx)t).eval(env);
                System.out.println("=> " + r);
            }
        }
    }
}
