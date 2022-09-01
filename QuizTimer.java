import java.util.Timer;
import javax.swing.JFrame;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 * Write a description of class Timer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QuizTimer
{    
   Timer t;
   private int time;
   public QuizTimer(int seconds) {
       time = seconds;
       t = new Timer();
       t.schedule(new RemindTask(), seconds*1000);       
    }
    
    class RemindTask extends TimerTask {
     public void run() {
        TimedQuizTester.timeUp = true;
        t.cancel();
        }   
    }   
     
   public void reset() {
       t.schedule(new RemindTask(), time*1000);
    }
   
   public void stop() {
       
    }
    
    
}