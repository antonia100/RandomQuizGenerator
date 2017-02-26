package graphics.Panel;

import quiz.questions.Question;

import javax.swing.*;

public class QuestionPanel extends Panel {
    private String selected;

    public QuestionPanel(Question question) {
        super(question);

        WIDTH = 500;
        HEIGHT = 100;

        createPanelBase();
        createPanel();
    }

    private void createPanel() {
        JLabel questionLabel = new JLabel(question.getQuestion());
        this.add(questionLabel);

        ButtonGroup buttonGroup = new ButtonGroup();

        for (String option : question.getOptions()) {
            JCheckBox box = new JCheckBox(option);
            box.addItemListener(itemEvent -> {
                selected = option;
            });

            buttonGroup.add(box);
            this.add(box);
        }
    }

    public String getSelected(){
        return this.selected;
    }

    public Question getQuestion(){
        return this.question;
    }

}