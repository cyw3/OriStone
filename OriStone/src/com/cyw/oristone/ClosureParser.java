package com.cyw.oristone;

import static com.cyw.oristone.Parser.rule;
import com.cyw.oristone.ast.Fun;


public class ClosureParser extends FuncParser {
    public ClosureParser() {
        primary.insertChoice(rule(Fun.class)
                                 .sep("fun").ast(paramList).ast(block));
    }
}
