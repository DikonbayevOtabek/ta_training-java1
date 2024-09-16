package com.epam.rd.autotasks.arithmeticexpressions;

public class Expressions {

    public static Variable var(String name, int value) {
        Variable var = new Variable(name, value);
        if(name == null){
            return null;
        }
        return var;
    }

    public static Expression val(int value) {
        Expression val = new Expression() {
            @Override
            public int evaluate() {
                return value;
            }
            @Override
            public String toExpressionString() {
                if (value < 0){
                    return "(" + value + ")";
                }
                return "" + value +"";
            }
        };
        return val;
    }

    public static Expression sum(Expression... members){
        Expression sum = new Expression() {
            @Override
            public int evaluate() {
                int sums = 0;
                for (Expression member : members){
                    sums += member.evaluate();
                }
                return sums;
            }
            @Override
            public String toExpressionString() {
                StringBuilder result = new StringBuilder("(");
                for (int i = 0; i < members.length; ++i){
                    if(i + 1 == members.length){
                        result.append(members[i].toExpressionString()).append(")");
                        return result.toString();
                    }
                    result.append(members[i].toExpressionString()).append(" + ");
                }
                return result.toString();
            }
        };
        return sum;
    }

    public static Expression product(Expression... members){
        return new Expression() {
            @Override
            public int evaluate() {
                int result = 1;
                for (Expression member : members){
                    result *= member.evaluate();
                }
                return result;
            }
            @Override
            public String toExpressionString() {
                String result = "(";
                for (int i = 0; i < members.length; ++i){
                    if(i + 1 == members.length){
                        result += members[i].toExpressionString() + ")";
                        return result;
                    }
                    result += members[i].toExpressionString() + " * ";
                }
                return result;
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        Expression difference = new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                String result = "(";
                result += minuend.toExpressionString() + " - ";
                result += subtrahend.toExpressionString() + ")";
                return result;
            }
        };
        return difference;
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        Expression fraction = new Expression() {
            public int evaluate() {
                int num = dividend.evaluate() / divisor.evaluate();
                return num;
            }

            @Override
            public String toExpressionString() {
                String result = "(";
                result += dividend.toExpressionString() + " / ";
                result += divisor.toExpressionString() + ")";
                return result;
            }
        };
        return fraction;
    }
}
