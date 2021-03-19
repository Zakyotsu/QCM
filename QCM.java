package fr.vinet.qcm;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class QCM {

    private ArrayList<Question> liste;

    public QCM() {
        liste = new DAO().getQuestions();



    }




		
}
