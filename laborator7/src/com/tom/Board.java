package com.tom;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Token> tokens;

    public Board() {
        tokens = new ArrayList<>();
    }

    public Board(int n) {
        tokens = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Token token = new Token(i);
            tokens.add(token);
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public synchronized Token extractToken() {
        Token token = new Token();
        token.setValue(tokens.get(0).getValue());
        tokens.remove(0);
        return token;
    }

    public boolean emptyBoard() {
        if (tokens.isEmpty())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Board{" +
                "tokens=" + tokens +
                '}';
    }
}
