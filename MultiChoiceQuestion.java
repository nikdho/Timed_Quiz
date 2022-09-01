import java.util.ArrayList;
/**
 * Write a description of class AnyCorrectChoiceQuestion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MultiChoiceQuestion extends Question
{
   String answer;
    private ArrayList<String> choiceList = new ArrayList<String>();
    public MultiChoiceQuestion() {
       
    }
    
    public void addChoice(String choice) {
        choiceList.add(choice);
    }
    
    public void setAnswer(String a) {
        answer = a;
    }
    
    public boolean checkAnswer(String actualAnswer) {
        if(actualAnswer.equals(answer)) {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    public String display() {       
        String displayStr = super.display();
        for(int i = 0; i < choiceList.size(); i++) {
            displayStr += (i + 1) + ": " + choiceList.get(i) + "\n";
        }
        return displayStr;
    }
}
