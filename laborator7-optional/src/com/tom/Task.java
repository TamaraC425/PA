package com.tom;

import java.util.TimerTask;

public class Task extends TimerTask {

    @Override
    public void run() {
        System.out.println("Time is up");
        System.exit(0);
    }
}
