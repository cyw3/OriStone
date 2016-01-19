package com.cyw.oristone.ast;

import java.util.List;

/**
 * 实现BNF中的postfix定义
 * @author cyw
 *
 */
public abstract class Postfix extends ASTList {
    public Postfix(List<ASTree> c) { super(c); }
}
