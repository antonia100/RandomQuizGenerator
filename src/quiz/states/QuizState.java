package quiz.states;

import graphics.QuizPanel;
import quiz.Handler;

public class QuizState {
    private Handler handler;
    private QuizPanel quizPanel;

    public QuizState(Handler handler) {
        this.handler = handler;
    }

    public void showNewQuiz() {
        quizPanel = new QuizPanel(this.handler);
        handler.getDisplay().add(quizPanel);
    }

    public QuizPanel getQuizPanel() {
        return this.quizPanel;
    }
}