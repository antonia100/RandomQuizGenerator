package quiz.questions;

public class Question {
    private int questionIndex;
    private String question;
    private String [] options;
    private int answerIndex;

    public Question(int questionIndex, String question, String [] options, int answerIndex){
        this.questionIndex = questionIndex;
        this.question = question;
        this.options = options;
        this.answerIndex = answerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

}
