package fr.vinet.qcm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Jeu {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        for(Question q : new QCM().getQuestions()) {
            String themeLine = q.getTheme();
            String[] theme = themeLine.split("-");

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
            

        }


    }

}
