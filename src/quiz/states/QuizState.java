package quiz.states;

import graphics.QuizFrame;
import quiz.Handler;

public class QuizState {
    private Handler handler;
    private QuizFrame quizFrame;

    public QuizState(Handler handler) {
        this.handler = handler;
    }

    public void showNewQuiz() {
        quizFrame = new QuizFrame(this.handler);
        handler.getDisplay().add(quizFrame);
    }

    public QuizFrame getQuizFrame() {
        return this.quizFrame;
    }
}