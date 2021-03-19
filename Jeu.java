package fr.vinet.qcm;

public class Jeu {

    public static void main(String[] args) {
        DAO dao = new DAO();

        for(Question q : dao.getQuestions()) {
            System.out.println(q.getQuestion());
        }
    }

}
