package quiz.states;

import graphics.ResultsPanel;
import quiz.Handler;


public class ResultsState {

    private Handler handler;
    private ResultsPanel resultsPanel;

    public ResultsState(Handler handler){
        this.handler = handler;
    }

    public void showNewResults(){
        resultsPanel = new ResultsPanel(handler,
                handler.getQuiz().getQuizState().getQuizPanel(),
                handler.getQuiz().getResult());

        handler.getQuiz().getDisplay().add(resultsPanel);
    }


    public ResultsPanel getResultsPanel(){
        return this.resultsPanel;
    }
}