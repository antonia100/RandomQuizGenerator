package graphics;

import graphics.Panel.QuestionPanel;
import graphics.Panel.ResultPanel;
import quiz.Handler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Results extends JPanel{

    private Handler handler;
    private QuizFrame quizFrame;
    private int result;
    private JButton newQuizBtn, goToMenuBtn;

    public Results(Handler handler, QuizFrame quizFrame, int result){
        this.handler = handler;
        this.quizFrame = quizFrame;
        this.result = result;

        createResultPanels();
    }

    private void createResultPanels(){

        setPreferredSize(new Dimension(handler.getQuiz().getWidth()-100 , handler.getQuiz().getHeight() ));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);

        JLabel resultLabel = new JLabel(resultToString());
        resultLabel.setVisible(true);
        resultLabel.setPreferredSize(new Dimension(30,100));

        add(resultLabel);

        ArrayList<ResultPanel> resultPanels = new ArrayList<>();
        ArrayList<String> userInput = handler.getQuiz().getSelectedOptions();
        //check the result and add the generated panels to the list
        for(QuestionPanel q: quizFrame.getQuestionPanels()){
            ResultPanel resultPanel = new ResultPanel(q.getQuestion(), q.getSelected());
            add(resultPanel);
        }

        newQuizBtn = new JButton();
        newQuizBtn.setText("New Quiz");

        goToMenuBtn = new JButton();
        goToMenuBtn.setText("Menu");

        add(newQuizBtn);
        add(goToMenuBtn);

    }

    private String resultToString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Points ");
        builder.append(String.valueOf(result));
        builder.append("/8");

        return builder.toString();
    }

    public JButton getNewQuizBtn(){
        return this.newQuizBtn;
    }

    public JButton getGoToMenuBtn(){
        return this.goToMenuBtn;
    }

}
