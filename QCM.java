package fr.vinet.qcm;

import java.util.ArrayList;

public class QCM {

    private ArrayList<Question> liste;

    public QCM() {
        liste = new DAO().getQuestions();



    }


    public ArrayList<Question> getQuestions() {
        return liste;
    }


		
}
