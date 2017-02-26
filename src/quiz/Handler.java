package quiz;

import graphics.Display;

public class Handler {

    private Quiz quiz;

    public Handler(Quiz quiz){
        this.quiz = quiz;
    }

    public Display getDisplay(){
        return quiz.getDisplay();
    }

    public Quiz getQuiz(){
        return this.quiz;
    }

}
