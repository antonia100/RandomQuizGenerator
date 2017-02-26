package graphics.Panel;

import quiz.questions.Question;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    protected Question question;
    protected int WIDTH, HEIGHT;

    public Panel(Question question){
        this.question = question;
    }

    protected void createPanelBase(){
        setBounds(70, 20, 81, 140);
        setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setEnabled(true);
        setVisible(true);
    }

}