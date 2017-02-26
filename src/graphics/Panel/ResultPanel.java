package graphics.Panel;

import quiz.questions.Question;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends Panel{
    private String selected;

    public ResultPanel(Question question, String selected) {
        super(question);
        this.selected = selected;

        WIDTH = 500;
        HEIGHT = 100;

        createPanelBase();
        createPanel();
    }

    private void createPanel() {

        JLabel questionLabel = new JLabel(question.getQuestion());
        questionLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        questionLabel.setBackground(Color.darkGray);
        this.add(questionLabel);

        for (String option : question.getOptions()) {

            //check is option is the correct answer
            if (question.getOptions()[question.getAnswerIndex()].equals(option)) {
                //check if the selected is the correct
                if (option.equals(selected)) {
                    JLabel label = paintLabel(option, new Color(0, 204, 0));
                    this.add(label);
                } else {
                    JLabel label = paintLabel(option, new Color(0, 204, 204));
                    this.add(label);
                }
            } else if (option.equals(selected)) {
                JLabel label = paintLabel(option, new Color(204, 0, 0));
                this.add(label);
            } else {
                JLabel label = new JLabel(option);
                this.add(label);
            }
        }
    }

    private JLabel paintLabel(String s, Color c){
        JLabel painted = new JLabel(s);
        painted.setForeground(c);
        return painted;
    }

}
