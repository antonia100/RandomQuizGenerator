package graphics;

import quiz.Handler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Menu extends JPanel {
    private Handler handler;
    private JButton startBtn, exitBtn;
    private JTextArea userHistory;
    private static final int MENUWIDTH = 500;
    private static final int MENUHEIGHT = 700;
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


        add(startBtn);
        add(exitBtn);
    }


    //problems here
    public void updateHistory() {

        userHistory = new JTextArea();
        JTextArea userHistory = new JTextArea();
        userHistory.setPreferredSize(new Dimension(handler.getQuiz().getWidth() - 200, handler.getQuiz().getHeight() - 100));
        userHistory.setLineWrap(true);
        userHistory.setWrapStyleWord(true);
        userHistory.setEditable(false);
        userHistory.setBackground(Color.black);
        userHistory.setFont(new Font("Verdana", Font.CENTER_BASELINE, 14));
        userHistory.setForeground(Color.white);
        JScrollPane scrollPane = new JScrollPane(userHistory);

        String historyPath = "src/resources/userhistory.txt";
        File file = new File(historyPath);

        try (FileInputStream fis = new FileInputStream(file)) {

            char current;

            while (fis.available() > 0) {
                current = (char) fis.read();
                userHistory.append(String.valueOf(current));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        add(userHistory);

    }


    public JButton getStartBtn() {
        return this.startBtn;
    }

}
