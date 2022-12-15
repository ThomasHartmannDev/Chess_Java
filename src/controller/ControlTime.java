package controller;

import model.EnumColor;
import vision.JBoard;
import vision.JChess;

import javax.swing.*;
import java.lang.Runnable;

public class ControlTime implements Runnable {// Implements runnable to do Threads


    private JBoard jBoard;

    private int timeUsed = 0;

    public ControlTime(JBoard board) {
        super();
        this.jBoard = board;
    }

    @Override
    public void run() {
        try {
            JChess.setTimeWhiteLb(SecondsToMinute(jBoard.getBoard().gettimeToPlayWhite()));
            JChess.setTimeBlackLb(SecondsToMinute(jBoard.getBoard().gettimeToPlayBlack()));
            while(true) {
                while (jBoard.getBoard().getTurn().equals(EnumColor.WHITE)) {
                    Thread.sleep(1000);
                    timeUsed = 1000;
                    //System.out.println("White Turn");
                    int timeWhite = jBoard.getBoard().gettimeToPlayWhite() - timeUsed;
                    jBoard.getBoard().setTimeToPlayWhite(timeWhite);
                    //System.out.println("Time: " + timeWhite);
                    JChess.setTimeWhiteLb(SecondsToMinute(jBoard.getBoard().gettimeToPlayWhite()));
                    if (timeWhite == 0) {
                        JOptionPane.showMessageDialog(null, "NO TIME MORE, WHITE LOSE");
                        timeUsed = 0;

                    }
                }
                while (jBoard.getBoard().getTurn().equals(EnumColor.BLACK)) {
                    Thread.sleep(1000);
                    timeUsed = 1000;
                    //System.out.println("Black Turn");
                    int timeBlack = jBoard.getBoard().gettimeToPlayBlack() - timeUsed;
                    jBoard.getBoard().setTimeToPlayBlack(timeBlack);
                    //System.out.println("Time: " + timeBlack);

                    JChess.setTimeBlackLb(SecondsToMinute(jBoard.getBoard().gettimeToPlayBlack()));
                    if (timeBlack == 0) {
                        JOptionPane.showMessageDialog(null, "NO TIME MORE, BLACK LOSE");
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    private String SecondsToMinute(int seconds){
        String Time;
        int numberOfMinutes = (seconds) / 60000;
        int numberOfMinutesRest = (seconds) % 60000 / 1000;
        System.out.println(numberOfMinutes + ":" + numberOfMinutesRest);
        if(numberOfMinutesRest < 10){
            Time = numberOfMinutes + ":0" + numberOfMinutesRest;
        }else{
            Time = numberOfMinutes + ":" + numberOfMinutesRest;
        }
        return Time;
    }
}



