package com.tom;

import java.util.Objects;

public class Token implements Comparable {
    private int value;
    public Token() {
    }

    public Token(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return value == token.value;
    }
    @Override
    public int compareTo(Object token) {
        if (token== null )
            throw new NullPointerException();
        if (!( token instanceof Token ))
            throw new ClassCastException ("Incomparable objects");
        Token tok = (Token) token;
        return (this.value - tok.value);
    }

}

