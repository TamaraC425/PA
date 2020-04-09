package com.tom;

import java.util.Timer;

public class Timekeeper extends Thread{
    private int finish;
    private long startTime;
    Timer timer;
    public Timekeeper(long startTime,int finish)
    {
       this.finish=finish;
       this.startTime=startTime;
       timer=new Timer();
       timer.schedule(new Task(),finish);
    }
    public void run()
    {
                System.out.println("Timer running ");
    }

}
