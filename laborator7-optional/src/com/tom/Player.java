package com.tom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Player extends Thread{
   private String name;
   private Game game;
   private ArithmeticProgression arithmeticProgression;
   abstract boolean chooseToken() throws InterruptedException, IOException;
}




