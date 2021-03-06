package fr.vinet.qcm;

import java.io.*;
import java.util.ArrayList;

public class DAO {

	private static File csv = new File("qcm.csv");

	public static ArrayList<Question> getQuestions() {
		String line = "";
		ArrayList<Question> questions = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(csv));
			while ((line = br.readLine()) != null) {
				String s = line.replaceAll(";;", "; ;"); //sinon le split ne le compte pas


				//thème;question;réponse correcte;1er leurre ;2e leurre ;3e leurre ;(éventuels autres leurres);éventuel commentaire
				String[] splitted = s.split(";");
				String theme = splitted[0];
				String question = splitted[1];
				String answer = splitted[2];

				String[] leurre = new String[4];
				leurre[0] = splitted[3];
				leurre[1] = splitted[4];
				leurre[2] = splitted[5];
				leurre[3] = "";
				if (!splitted[6].equals(" ")) leurre[3] = splitted[6];

				String comment = "";
				if(splitted.length > 7) {
					if (!splitted[7].equals(" ")) comment = splitted[7];
				}

				questions.add(new Question(question, theme, leurre, answer, comment));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		//retirer le nom des columns
		questions.remove(0);

		return questions;
	}
}
