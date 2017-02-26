package quiz;

import graphics.Display;
import graphics.Menu;
import graphics.Panel.QuestionPanel;
import graphics.UserHistory;
import quiz.questions.QuestionManager;
import quiz.states.MenuState;
import quiz.states.QuizState;
import quiz.states.ResultsState;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

public class Quiz {
    private String title;
    private int width, height;
    private Handler handler;
    private Display display;
    private MenuState menuState;
    private QuizGenerator quizGenerator;
    private QuizState quizState;
    private ArrayList<String> selectedOptions;
    private ResultsState resultsState;
    private int result;

    public Quiz(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        this.handler = new Handler(this);
        QuestionManager questionManager = new QuestionManager(this.handler);
        this.quizGenerator = new QuizGenerator(this.handler, questionManager);
        this.quizState = new QuizState(this.handler);
        this.resultsState = new ResultsState(this.handler);

        createQuiz();
    }

    private void createQuiz(){
        display = new Display(this.title, this.width, this.height, this.handler);

        //show menu when first launching
        Menu menu = new Menu(this.handler);
        menuState = new MenuState(menu, this.handler);
        quizState = new QuizState(this.handler);
        //hide menu if user decides to start a quiz and to go quizstate
        activateStartBtn();
        activateHistoryBtn();
    }

    private void activateStartBtn(){
      menuState.getMenu().getStartBtn().addActionListener((ActionEvent event)->{
          menuState.hideMenu();
          quizState.showNewQuiz();
          activateSubmitButton();
      } );

    }

    private void activateHistoryBtn(){
        menuState.getMenu().getHistoryBtn().addActionListener((ActionEvent event) ->{
            menuState.hideMenu();
            UserHistory history = new UserHistory(this.handler);
            display.add(history);

            history.getBackBtn().addActionListener((ActionEvent event1)->{
                history.setVisible(false);
                menuState.getMenu().setVisible(true);
            });
        });
    }

    private void activateSubmitButton(){
        quizState.getQuizPanel().getSubmitBtn().addActionListener((ActionEvent event) -> {
            //list the user selected options
            selectedOptions = new ArrayList<>();

            //iterate through the user's selected options
            for(QuestionPanel questionPanel: quizState.getQuizPanel().getQuestionPanels()){
                String selected = questionPanel.getSelected();
                selectedOptions.add(selected);
            }
            //evaluate
            Grader grader = new Grader(this.handler, quizState.getQuizPanel().getGeneratedQuestions(), selectedOptions);
            result = grader.gradeTotal();

            //add the new entry to the history
            Date now = new Date();
            HistoryEntry newEntry = new HistoryEntry(String.valueOf(now), result, this.handler);

            //hide the quiz
            quizState.getQuizPanel().setVisible(false);

            //show results State
            resultsState.showNewResults();
            activateNewQuizBtn();
            activateGoToMenuBtn();
        });
    }


    private void activateGoToMenuBtn(){
        resultsState.getResultsPanel().getGoToMenuBtn().addActionListener((ActionEvent event) -> {
            //hide the answer panel
            resultsState.getResultsPanel().setVisible(false);
            //generate new menu
            menuState.getMenu().setVisible(true);
        });

    }

    private void activateNewQuizBtn(){
        resultsState.getResultsPanel().getNewQuizBtn().addActionListener((ActionEvent event)->{
            //hide the answer panel
            resultsState.getResultsPanel().setVisible(false);
            //generate new quiz
            quizState.showNewQuiz();
            activateSubmitButton();
        });
    }


    //getters and setters
    public Display getDisplay(){
        return this.display;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public QuizGenerator getQuizGenerator() {
        return quizGenerator;
    }

    public QuizState getQuizState() {
        return quizState;
    }

    public ArrayList<String> getSelectedOptions() {
        return selectedOptions;
    }

    public int getResult() {
        return result;
    }

}
