package com.epam.rd.autotasks.arithmeticexpressions;

public class Variable implements Expression {
    String name;
    int value;
    public Variable(String name, int value) {
        this.name= name;
        this.value = value;
        //implement this method
    }

    public void setValue(int value) {
        this.value = value;
        //implement this method
    }

    @Override
    public int evaluate() {
        //implement this method
        return value;
    }

    @Override
    public String toExpressionString() {
        //implement this method
        return name;
    }
}
