import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.Scanner;
import java.awt.BorderLayout;
import javax.swing.Timer;
import javax.swing.JOptionPane;
/**
 * This class creates a timed quiz. Basically an array of 50 questions is made. 20
 * are randomly selected and displayed and there is a time limit of one minute to answer
 * as many questions as you can. Score will be displayed in the end along with a productive
 * comment.
 *
 * @author Nikhil Dhomse
 * @version 7/27/18
 */
public class TimedQuizTester     
{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_LENGTH = 500;
    private static ArrayList<Integer> alreadyAskedQuestions = new ArrayList<Integer>();
    public static ArrayList<Question> questions = new ArrayList<Question>();       
    public static boolean timeUp = false;
    
    /**
     * Checks an integer to all the integers of an arraylist to make sure
     * the integer isn't the same as any of the other integers.
     * @param x the integer that will be compared.
     */
    public static boolean isAlreadyAsked(int x) {
        for(int i : alreadyAskedQuestions) {
            if(x == i) {
                return true;                
            }            
        }
        return false;
    }
    
    /**
     * Contains most of quiz code. Gets a text file and uses input from that to create
     * 50 question objects, and randomly display 20 of them along with their answers
     */
    public static void fullProgram() {          
        Scanner kboard = new Scanner(System.in);
    
        String r1 = "\n\n----------------------------------------------------------------------------------";
        String r2 = "\nWelcome to Java Jeopardy! This is a 20 question timed quiz game.";
        String r3 = "\nIn this game, you have one minute to answer the questions, and your end";
        String r4 = "\nscore will be displayed once you either complete all 20 questions, or run";
        String r5 = "\nout of time. You get +2 points for correct answers, and -1 point for";
        String r6 = "\nwrong answers. Good Luck!";
        JOptionPane.showMessageDialog(null, r1 + r2 + r3 + r4 + r5 + r6);
        while(true)
        {
        String p1 = "\n-----------------------------------";
        String p2 = "Hit <Enter> to Start or 'Q' to quit";
        String p3 = "-----------------------------------";
        String p4 = JOptionPane.showInputDialog(null, p1 + p2 + p3);
        
        if(p4.equals("q") || p4.equals("Q")) {
            String quitter = "Thank you for playing";
            JOptionPane.showMessageDialog(null, quitter);
            System.exit(0);
        }

        
        QuizTimer timer = new QuizTimer(30);
        int score = 0;
        Random rand = new Random();
        //Takes a random integer x as the index for Questions ArrayList h.
        //If that specific index of h is a question that was already asked
        //then a while loop is run continuously until the random number x
        //is an index of h where the question in the ArrayList has not been
        //used yet. Then that question is displayed and the answers are checked
        for(int i = 0; i < 20; i++) {
            int x = rand.nextInt(questions.size() - 1);            
            while (isAlreadyAsked(x) == true) {
                    x = rand.nextInt(questions.size() - 1);
            }
            alreadyAskedQuestions.add(x);
            
            Question qu1 = questions.get(alreadyAskedQuestions.get(i));
            String w = qu1.display();
            String ans = JOptionPane.showInputDialog(null, w);            
            boolean ans2 = qu1.checkAnswer(ans);
            if(ans2 == true) {
            String ans4 = "Correct";
            JOptionPane.showMessageDialog(null, ans4);
        }
            else {
            String ans5 = "Wrong";
            JOptionPane.showMessageDialog(null, ans5);
            }
            if(qu1.checkAnswer(ans) == true) {
                score+= 2;
            }
            else {
                score--;    
            }
            if(timeUp) {                
                JOptionPane.showMessageDialog(null,"Time's up!");
                break;        
            }
        }
            String a1 = "Your score was: " + score + "/40\n";
            
         if(score >= 34) {
            String a2 = "Great job!";
            JOptionPane.showMessageDialog(null, a1 + a2);;
            }   
            else if(score < 34 && score >= 20) {
            String a3 = "Not bad, but could be much better!";
            JOptionPane.showMessageDialog(null, a1 + a3);
            }
            else if(score >= 0 && score < 20) {
            String a4 = "Not very good. Better luck next time!";
            JOptionPane.showMessageDialog(null, a1 + a4);
            }
            else if(score < 0) {
                String a5 =  "This is a really bad score, but I know you can do better if you try!";
                JOptionPane.showMessageDialog(null, a1 + a5);
        }
            alreadyAskedQuestions.clear();
        }   
    }
    
    /**
     * Main method, creates Buttons and Labels in GUI which start the whole program
     */
    public static void main(String []args) throws Exception {
       BufferedReader br = null;           
        br = new BufferedReader(new InputStreamReader(new FileInputStream("MyQues.txt")));
        while(true) {  
            String line = br.readLine();
            if(line == null) {
                break;
            }           
            MultiChoiceQuestion q1 = new MultiChoiceQuestion(); 
            q1.setText(line + "\n");
            q1.addChoice(br.readLine());
            q1.addChoice(br.readLine());
            q1.addChoice(br.readLine());
            q1.addChoice(br.readLine());
            q1.setAnswer(br.readLine());   
            questions.add(q1);
        }
        br.close();
       TimedQuizTester.fullProgram();
       }
}
    
