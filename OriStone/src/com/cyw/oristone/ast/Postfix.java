package com.cyw.oristone.ast;

import java.util.List;

/**
 * ʵ��BNF�е�postfix����
 * @author cyw
 *
 */
public abstract class Postfix extends ASTList {
    public Postfix(List<ASTree> c) { super(c); }
}
