package quiz;

import graphics.Display;
import graphics.Menu;
import graphics.Panel.QuestionPanel;
import quiz.questions.QuestionManager;
import quiz.states.MenuState;
import quiz.states.QuizState;
import quiz.states.ResultsState;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class Quiz {
    private String title;
    private int width, height;
    private Handler handler;
    private Display display;
    private MenuState menuState;
    private QuestionManager questionManager;
    private QuizGenerator quizGenerator;
    private QuizState quizState;
    private Grader grader;
    private ArrayList<String> selectedOptions;
    private ResultsState resultsState;
    private int result;

    public Quiz(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        this.handler = new Handler(this);
        this.questionManager = new QuestionManager(this.handler);
        this.quizGenerator = new QuizGenerator(this.handler, this.questionManager);
        this.quizState = new QuizState(this.handler);
        this.resultsState = new ResultsState(this.handler);

        createQuiz();
    }

    public void createQuiz(){
        display = new Display(this.title, this.width, this.height, this.handler);

        //show menu when first launching
        Menu menu = new Menu(this.handler);
        menuState = new MenuState(menu, this.handler);
        quizState = new QuizState(this.handler);
        //hide menu if user decides to start a quiz and to go quizstate
        activateStartBtn();
    }

    private void activateStartBtn(){
      menuState.getMenu().getStartBtn().addActionListener((ActionEvent event)->{
          menuState.hideMenu();
          quizState.showNewQuiz();
          activateSubmitButton();
      } );

    }

    private void activateSubmitButton(){
        quizState.getQuizFrame().getSubmitBtn().addActionListener((ActionEvent event) -> {
            //list the user selected options
            selectedOptions = new ArrayList<>();

            //iterate through the user's selected options
            for(QuestionPanel questionPanel: quizState.getQuizFrame().getQuestionPanels()){
                String selected = questionPanel.getSelected();
                selectedOptions.add(selected);
            }
            //evaluate
            Grader grader = new Grader(this.handler, quizState.getQuizFrame().getGeneratedQuestions(), selectedOptions);
            result = grader.gradeTotal();

            //hide the quiz
            quizState.getQuizFrame().setVisible(false);

            //show results State
            resultsState.showNewResults();
            activateNewQuizBtn();
            activateGoToMenuBtn();
        });
    }


    private void activateGoToMenuBtn(){
        resultsState.getResults().getGoToMenuBtn().addActionListener((ActionEvent event) -> {
            //hide the answer panel
            resultsState.getResults().setVisible(false);
            //generate new menu
            menuState.showMenu();
        });

    }

    private void activateNewQuizBtn(){
        resultsState.getResults().getNewQuizBtn().addActionListener((ActionEvent event)->{
            //hide the answer panel
            resultsState.getResults().setVisible(false);
            //generate new quiz
            quizState.showNewQuiz();
            activateSubmitButton();
        });
    }


    //getters
    public Display getDisplay(){
        return this.display;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public MenuState getMenuState() {
        return menuState;
    }

    public void setMenuState(MenuState menuState) {
        this.menuState = menuState;
    }

    public QuestionManager getQuestionManager() {
        return questionManager;
    }

    public void setQuestionManager(QuestionManager questionManager) {
        this.questionManager = questionManager;
    }

    public QuizGenerator getQuizGenerator() {
        return quizGenerator;
    }

    public void setQuizGenerator(QuizGenerator quizGenerator) {
        this.quizGenerator = quizGenerator;
    }

    public QuizState getQuizState() {
        return quizState;
    }

    public void setQuizState(QuizState quizState) {
        this.quizState = quizState;
    }

    public Grader getGrader() {
        return grader;
    }

    public void setGrader(Grader grader) {
        this.grader = grader;
    }

    public ArrayList<String> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(ArrayList<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
