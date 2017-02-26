package graphics;

import quiz.Handler;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class UserHistory extends JPanel {
    private JTextArea area;
    private JButton backBtn;
    private Handler handler;

    public UserHistory(Handler handler) {
        this.handler = handler;

        createUserHistory();
    }

    private void createUserHistory() {
        setPreferredSize(new Dimension(handler.getQuiz().getWidth() - 200, handler.getQuiz().getHeight() - 100));

        area = new JTextArea();
        area.setPreferredSize(new Dimension(handler.getQuiz().getWidth() - 200, handler.getQuiz().getHeight() - 100));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);
        area.setBackground(Color.black);
        area.setFont(new Font("Verdana", Font.CENTER_BASELINE, 14));
        area.setForeground(Color.white);

        String historyPath = "src/resources/userhistory.txt";
        File file = new File(historyPath);

        try (FileInputStream fis = new FileInputStream(file)) {

            char current;

            while (fis.available() > 0) {
                current = (char) fis.read();
                area.append(String.valueOf(current));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        createBackBtn();
        add(area);

    }

    private void createBackBtn(){
        backBtn = new JButton();
        backBtn.setPreferredSize(new Dimension(100, 50));
        backBtn.setText("Back");
        backBtn.setEnabled(true);

        add(backBtn);
    }


    public JTextArea getArea(){
        return this.area;
    }

    public JButton getBackBtn(){
        return this.backBtn;
    }

}