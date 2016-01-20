package com.cyw.oristone.array;

import static com.cyw.oristone.Parser.rule;
import javassist.gluonj.Reviser;

import com.cyw.oristone.FuncParser;
import com.cyw.oristone.Parser;
import com.cyw.oristone.ast.ArrayLiteral;

@Reviser public class ArrayParser extends FuncParser {
    Parser elements = rule(ArrayLiteral.class)
                          .ast(expr).repeat(rule().sep(",").ast(expr));
    public ArrayParser() {
        reserved.add("]");
        primary.insertChoice(rule().sep("[").maybe(elements).sep("]"));
        postfix.insertChoice(rule(ArrayRef.class).sep("[").ast(expr).sep("]"));
    }
}
