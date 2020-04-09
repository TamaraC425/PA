package com.tom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArithmeticProgression {
    private final int size;
    int numbers[]=new int[this.getSize()];
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

    public synchronized boolean isCompleteArithmeticProgression() {
        if (progression.isEmpty() || progression.size() != size)
            return false;
        if (progression.size() == size) {
            Collections.sort(progression);
            int r = progression.get(1).getValue() - progression.get(0).getValue();
            for (int i = 1; i < progression.size()-1; i++)
                if (progression.get(i + 1).getValue() - progression.get(i).getValue() != r)
                    return false;
        }
        else if(progression.size()>size)
        {  Collections.sort(progression);
           findProgression(progression,numbers,0,progression.size()-1,0,size);
        }
        return true;
    }
    public boolean completeArithmeticProgression(int numbers[])
    {
        Arrays.sort(numbers);
        int gasit=0;
        int ratie=numbers[1]-numbers[0];
        for (int i = 1; i < numbers.length-1; i++)
            if (numbers[i + 1] - numbers[i] != ratie)
            {gasit=1;
                return false;}
        if(gasit==0)
        { List<Token> progresie=new ArrayList<>();
            for(int i=0;i<numbers.length;i++)
               { Token token=new Token(numbers[i]);
            progresie.add(token);}
            this.setProgression(progresie);
        }
            return true;
    }
    /**pentru fiecare combinatie de k numere,verific daca este progresie aritmetica completa
    **/
     public boolean findProgression(List<Token> tokens,int numbers[],int start,int end,int index,int k)
    {
      if(index==k)
      {
       if(completeArithmeticProgression(numbers))
           return true;
      }
        for (int i=start; i<=end && end-i+1 >= k-index; i++)
        {
            numbers[index] =tokens.get(i).getValue();
            findProgression(tokens,numbers, i+1, end, index+1, k);
        }

        return false;
    }

    @Override
    public String toString() {
        return "ArithmeticProgression{" +
                "progression=" + progression +
                '}';
    }
}
