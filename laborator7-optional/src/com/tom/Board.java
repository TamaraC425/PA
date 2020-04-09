package com.tom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Token> tokens;

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
    public synchronized Token extractRandomToken() {
        Token token = new Token();
        if (this.emptyBoard() == false) {
            int n = (int) (Math.random() * (tokens.size() - 1));
            token.setValue(tokens.get(n).getValue());
            tokens.remove(n);
        }
        return token;
    }

    public synchronized Token extractSmartToken() {
        /////////// Trebuie de refacut !!!!!!!!!!!!!!!!!!!
        Token token = new Token();
        int n = (int) (Math.random() * tokens.size());
        token.setValue(tokens.get(n).getValue());
        tokens.remove(n);
        return token;
    }

    public synchronized Token extractManualToken() throws IOException {
        Token token = new Token();
        if (this.emptyBoard() == false) {
            int gasit = -1;
            while (gasit == -1) {
                System.out.println("Puteti alege un numar din lista : ");
                System.out.println(this.getTokens());
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String input = bufferedReader.readLine();
                int number = Integer.parseInt(input);
                for (int i = 0; i < tokens.size(); i++)
                    if (tokens.get(i).getValue() == number) {
                        gasit = i;
                        break;
                    }
                if (gasit != -1) {
                    token.setValue(number);
                    tokens.remove(gasit);
                } else
                    System.out.println("Trebuie sa alegeti un numar din lista !");
            }
        }
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
