package fr.vinet.qcm;

import fr.vinet.qcm.frame.Frame;

public class Jeu {

    public static void main(String[] args) {
        DAO dao = new DAO();
        Frame frame = new Frame();

        for(Question q : dao.getQuestions()) {
            System.out.println(q.getComment());
        }
    }

}
