package fr.vinet.qcm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DAO {
	private File csv = new File("qcm.csv");

	public ArrayList<Question> getQuestions() {
		String line = "";
		ArrayList<Question> questions = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(csv));
			while ((line = br.readLine()) != null) {
				String[] splitted = line.split(";");
				for(String s : line.split(";")) System.out.println(s);
				String theme = splitted[0];
				String question = splitted[1];

				String[] leurre = new String[4];
				leurre[0] = splitted[2];
				leurre[1] = splitted[3];
				leurre[2] = splitted[4];
				leurre[3] = splitted[5];

				String answer = splitted[6];
				String comment = splitted[7];

				questions.add(new Question(question, theme, leurre, answer, comment));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return questions;
	}
}
