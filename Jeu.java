package fr.vinet.qcm;

import javax.swing.*;

public class Jeu {

    public static void main(String[] args) {
        //METHODE SCANNER
        /*
        Scanner s = new Scanner(System.in);

        for(Question q : new DAO().getQuestions()) {
            String themeLine = q.getTheme();

            System.out.println("Thème " + q.getTheme());
            System.out.println("Question: " + q.getQuestion());

            ArrayList<String> reponses = new ArrayList<String>();
            reponses.add(q.getAnswer());
            for(String leurre : q.getLeurres()) reponses.add(leurre);
            Collections.shuffle(reponses);

            int i = 0;
            for(String proposition : reponses) {
                i++;
                System.out.println("Proposition " + i + ": " + proposition);
            }

            int answer = Integer.valueOf(s.next());
            if(q.isGoodAnswer(reponses.get(answer))) {
                System.out.println("WESH T BO");
            }


        }*/

        //METHODE JFRAME
        new QCM();
    }
}
