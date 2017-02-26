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

    public int getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }
}
