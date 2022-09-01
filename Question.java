import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Question here.
 *
 * @author Nikhil Dhomse
 * @version 7/16/18
 */
public class Question
{
    // instance variables - replace the example below with your own
    private String text;
    private static String answer;
    private static ArrayList<String> questions = new ArrayList<String>();
    /**
     * Constructor for objects of class Question
     */
    public Question()
    {
        text = "";
        answer = "";
    }
    
    /** 
       Sets the text for the question.
       @param newText, the String that contains the question.
       */
    public void setText(String newText) {
        text = newText;
    }

    /**
     * Sets the user's answer.
     * @param newAnswer, the user's answer.
     */
    public void setAnswer(String newAnswer) {
        answer = newAnswer;
    }
    
    /**
     * Compares the user's answer to the correct answer and returns true 
     * if correct, false if wrong
     * @param answerChecker, the correct answer.
     */
    public boolean checkAnswer(String answerChecker) {
        return answerChecker.equals(answer);
    }
    
    public void addQuestionChoice(String q) {
       questions.add(q);
    }
    
    public void presentQuestion(Question q2){
        Scanner kboard = new Scanner(System.in);
        for(String q1 : questions) {
            System.out.println(q1); 
            String ans = kboard.nextLine();
            System.out.println(q2.checkAnswer(ans));
    }
}
    public String display() {
        return text;
    }
}
