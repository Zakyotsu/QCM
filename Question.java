package fr.vinet.qcm;

public class Question {

    private String question;
    private String theme;
    private String[] leurres;
    private String answer;
    private String comment;

    public Question(String question, String theme, String[] leurres, String answer, String comment) {
        this.question = question;
        this.theme = theme;
        this.leurres = leurres;
        this.answer = answer;
        this.comment = comment;
    }

    public String getQuestion() {
        return question;
    }

    public String getTheme() {
        return theme;
    }

    public String[] getLeurres() {
        return leurres;
    }

    public String getAnswer() {
        return answer;
    }

    public String getComment() {
        return comment;
    }

    public boolean isGoodAnswer(String answer) {
        return this.answer.equalsIgnoreCase(answer);
    }
}
