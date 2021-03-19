package fr.vinet.qcm;

public class Question {

    private String question;
    private String theme;
    private String leurre1;
    private String leurre2;
    private String leurre3;
    private String leurre4;
    private String answer;
    private String comment;

    public Question(String question, String theme, String[] leurre, String answer, String comment) {
        this.question = question;
        this.theme = theme;
        this.leurre1 = leurre[0];
        this.leurre2 = leurre[1];
        this.leurre3 = leurre[2];
        this.leurre4 = leurre[3];
        this.answer = answer;
        this.comment = comment;
    }

    public String getQuestion() {
        return question;
    }

    public String getTheme() {
        return theme;
    }

    public String getLeurre1() {
        return leurre1;
    }

    public String getLeurre2() {
        return leurre2;
    }

    public String getLeurre3() {
        return leurre3;
    }

    public String getLeurre4() {
        return leurre4;
    }

    public String getAnswer() {
        return answer;
    }

    public String getComment() {
        return comment;
    }
}
