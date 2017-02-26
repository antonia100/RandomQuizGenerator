package graphics;

import graphics.Panel.QuestionPanel;
import quiz.Handler;
import quiz.questions.Question;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QuizPanel extends JPanel{
    private Handler handler;
    private JButton submitBtn;
    private ArrayList<QuestionPanel> questionPanels;
    private ArrayList<Question> generatedQuestions;

    public QuizPanel(Handler handler){
        this.handler = handler;

        createQuizFrame();
    }

    private void createQuizFrame(){
        setPreferredSize(new Dimension(handler.getQuiz().getWidth()-100 , handler.getQuiz().getHeight() ));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);

        createQuestionPanels();

        submitBtn = new JButton();
        submitBtn.setPreferredSize(new Dimension(50,20));
        submitBtn.setText("Submit");

        add(submitBtn);
    }

    private void createQuestionPanels(){
        questionPanels = new ArrayList<>();
        generatedQuestions = handler.getQuiz().getQuizGenerator().generateQuestions();

        for(Question question : generatedQuestions){
            QuestionPanel qPanel = new QuestionPanel(question);
            questionPanels.add(qPanel);
            add(qPanel);
        }
    }

    public JButton getSubmitBtn(){
        return this.submitBtn;
    }

    public ArrayList<QuestionPanel> getQuestionPanels(){
        return this.questionPanels;
    }

    public ArrayList<Question> getGeneratedQuestions(){
        return this.generatedQuestions;
    }
}
