package com.cyw.oristone.runner;

import com.cyw.oristone.BasicParser;
import com.cyw.oristone.CodeDialog;
import com.cyw.oristone.Lexer;
import com.cyw.oristone.ParseException;
import com.cyw.oristone.Token;
import com.cyw.oristone.ast.ASTree;

public class ParserRunner {
    public static void main(String[] args) throws ParseException {
        Lexer l = new Lexer(new CodeDialog());
        BasicParser bp = new BasicParser();
        while (l.peek(0) != Token.EOF) {
            ASTree ast = bp.parse(l);
            System.out.println(">>> " + ast.toString());
        }
    }
}

