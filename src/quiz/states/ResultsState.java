package quiz.states;

import graphics.Results;
import quiz.Handler;


public class ResultsState extends State{

    private Handler handler;
    private Results results;

    public ResultsState(Handler handler){
        this.handler = handler;
    }

    public void showNewResults(){
        results = new Results(handler,
                handler.getQuiz().getQuizState().getQuizFrame(),
                handler.getQuiz().getResult());

        handler.getQuiz().getDisplay().add(results);
    }


    public Results getResults(){
        return this.results;
    }
}