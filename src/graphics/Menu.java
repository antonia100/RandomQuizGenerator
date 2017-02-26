package graphics;

import quiz.Handler;
import quiz.HistoryEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Menu extends JPanel {
    private Handler handler;
    private JButton startBtn, exitBtn, historyBtn;
    private UserHistory userHistory;
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

    }

    public void updateHistory(HistoryEntry entry){
        userHistory.getArea().append(entry.buildEntryString(entry.getDate(), entry.getPoints()));
    }

    public JButton getStartBtn() {
        return this.startBtn;
    }

    public JButton getHistoryBtn(){
        return this.historyBtn;

    }

}
