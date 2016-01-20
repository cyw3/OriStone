package com.cyw.oristone;

import static com.cyw.oristone.Parser.rule;
import com.cyw.oristone.ast.Arguments;
import com.cyw.oristone.ast.DefStmnt;
import com.cyw.oristone.ast.ParameterList;

/**
 * 定义BasicParser中新增的功能
 * @author cyw
 *
 */
public class FuncParser extends BasicParser {
    Parser param = rule().identifier(reserved);
    Parser params = rule(ParameterList.class)
                        .ast(param).repeat(rule().sep(",").ast(param));
    Parser paramList = rule().sep("(").maybe(params).sep(")");
    protected Parser def = rule(DefStmnt.class)
                     .sep("def").identifier(reserved).ast(paramList).ast(block);
    Parser args = rule(Arguments.class)
                      .ast(expr).repeat(rule().sep(",").ast(expr));
    protected Parser postfix = rule().sep("(").maybe(args).sep(")");

    public FuncParser() {
        reserved.add(")");
        primary.repeat(postfix);
        simple.option(args);
        program.insertChoice(def);
    }
}