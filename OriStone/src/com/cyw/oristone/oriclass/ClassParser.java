package com.cyw.oristone.oriclass;

import static com.cyw.oristone.Parser.rule;

import com.cyw.oristone.ClosureParser;
import com.cyw.oristone.Parser;
import com.cyw.oristone.Token;
import com.cyw.oristone.ast.ClassBody;
import com.cyw.oristone.ast.ClassStmnt;
import com.cyw.oristone.ast.Dot;

public class ClassParser extends ClosureParser {
    Parser member = rule().or(def, simple);
    Parser class_body = rule(ClassBody.class).sep("{").option(member)
                            .repeat(rule().sep(";", Token.EOL).option(member))
                            .sep("}");
    Parser defclass = rule(ClassStmnt.class).sep("class").identifier(reserved)
                          .option(rule().sep("extends").identifier(reserved))
                          .ast(class_body);
    
    public ClassParser() {
        postfix.insertChoice(rule(Dot.class).sep(".").identifier(reserved));
        program.insertChoice(defclass);
    }
}
