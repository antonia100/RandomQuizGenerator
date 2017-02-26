package graphics;

import quiz.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Menu extends JPanel {
    private Handler handler;
    private JButton startBtn, exitBtn, historyBtn;
    private static final int MENUWIDTH = 300;
    private static final int MENUHEIGHT = 100;
    private static final int BUTTONSWIDTH = 100;
    private static final int BUTTONSHEIGHT = 50;

    public Menu(Handler handler) {
        this.handler = handler;

        createMenu();
    }

    private void createMenu() {
        setMinimumSize(new Dimension(MENUWIDTH, MENUHEIGHT));
        setMaximumSize(new Dimension(MENUWIDTH, MENUHEIGHT));
        setPreferredSize(new Dimension(MENUWIDTH, MENUHEIGHT));


        startBtn = new JButton();
        startBtn.setPreferredSize(new Dimension(BUTTONSWIDTH, BUTTONSHEIGHT));
        startBtn.setText("Start");
        startBtn.setEnabled(true);

        exitBtn = new JButton();
        exitBtn.setPreferredSize(new Dimension(BUTTONSWIDTH, BUTTONSHEIGHT));
        exitBtn.setText("Exit");
        exitBtn.setEnabled(true);
        exitBtn.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        historyBtn = new JButton();
        historyBtn.setPreferredSize(new Dimension(BUTTONSWIDTH, BUTTONSHEIGHT));
        historyBtn.setText("History");
        historyBtn.setEnabled(true);

        add(startBtn);
        add(historyBtn);
        add(exitBtn);

        setImageIcon();

    }

    private void setImageIcon(){
        ImageIcon icon = new ImageIcon("src/resources/back.png");
        JLabel iconLabel = new JLabel();
        iconLabel.setIcon(icon);

        add(iconLabel);
    }

    public JButton getStartBtn() {
        return this.startBtn;
    }

    public JButton getHistoryBtn(){
        return this.historyBtn;

    }

}
