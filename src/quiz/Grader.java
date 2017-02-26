package quiz;

import quiz.questions.Question;

import java.util.ArrayList;

public class Grader {

    private Handler handler;
    private ArrayList<String> userInput;
    private ArrayList<Question> questions;

    public Grader(Handler handler, ArrayList<Question> questions, ArrayList<String> userInput){
        this.handler = handler;
        this.questions = questions;
        this.userInput = userInput;
    }


    public int gradeTotal(){
        int result = 0;

        for(int i = 0; i<questions.size(); i++){

           if(gradeQuestion(questions.get(i), userInput.get(i))){
               result++;
           }
        }


        return result;
    }

    public boolean gradeQuestion(Question q, String input){
        String answer = q.getOptions()[q.getAnswerIndex()];

        if(answer.equals(input)){
            return true;
        }

        return false;
    }

}
