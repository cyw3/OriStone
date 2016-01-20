package com.cyw.oristone.array;

import java.util.List;

import com.cyw.oristone.ast.ASTree;
import com.cyw.oristone.ast.Postfix;

/**
 * 表示数组元素的引用
 * @author cyw
 *
 */
public class ArrayRef extends Postfix {
    public ArrayRef(List<ASTree> c) { super(c); }
    public ASTree index() { return child(0); }
    public String toString() { return "[" + index() + "]"; }
}
