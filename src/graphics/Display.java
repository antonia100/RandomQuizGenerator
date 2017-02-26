package graphics;

import quiz.Handler;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame{
    private String name;
    private int width, height;
    private Handler handler;

    public Display(String name, int width, int height, Handler handler){
        this.name = name;
        this.width = width;
        this.height = height;
        this.handler = handler;

        createDisplay();
    }

    private void createDisplay(){
        setTitle(name);
        setPreferredSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
    }

}
