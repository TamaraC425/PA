package com.tom;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticProgression {
    private final int size;
    private List<Token> progression = new ArrayList<>();

    public ArithmeticProgression(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public List<Token> getProgression() {
        return progression;
    }

    public void setProgression(List<Token> progression) {
        this.progression = progression;
    }

    public void addToken(Token token) {
        progression.add(token);
    }

    public boolean isCompleteArithmeticProgression() {
        if (progression.isEmpty() || progression.size() != size)
            return false;
        if (progression.size() == size) {
            int r = progression.get(1).getValue() - progression.get(0).getValue();
            for (int i = 1; i < progression.size()-1; i++)
                if (progression.get(i + 1).getValue() - progression.get(i).getValue() != r)
                    return false;
        }
        else if(progression.size()>size)
        {
           if(!findProgression(progression,1))
               return false;
            if(!findProgression(progression,2))
                return false;
            if(!findProgression(progression,3))
                return false;
            if(!findProgression(progression,3))
                return false;
        }
        return true;
    }
    public boolean findProgression(List<Token> tokens,int r)
    {
      ///gasirea unei progresii aritmetice de dimensiune=size
        return true;
    }

    @Override
    public String toString() {
        return "ArithmeticProgression{" +
                "progression=" + progression +
                '}';
    }
}
