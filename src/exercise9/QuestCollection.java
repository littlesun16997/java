package exercise9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class QuestCollection {
	private ArrayList<Question> quest = new ArrayList<>();

	public void quest() {
		ClassLoader cl = this.getClass().getClassLoader();
	    URL url = cl.getResource("exercise9/questions");
		try (InputStream in = url.openStream(); BufferedReader input = new BufferedReader(new InputStreamReader(in))) {
			String line;
			ArrayList<String> choice = new ArrayList<>();
			int i;
			while ((line = input.readLine()) != null) {				
				Question q1 = new Question();
				q1.setQuestion(line);
				for (i = 0; i < 4; i++) {
					if (line.length() != 0) {
						choice.add(input.readLine());
					}
				}
				q1.setChoice(choice);
				q1.setAnswer(input.readLine().substring(8));
				quest.add(q1);
				choice = new ArrayList<>();
				if (input.readLine().length() == 0) {
					continue;
				}
			}
		} catch (FileNotFoundException ex1) {
			System.out.println("Reading from file failed: " + ex1.getMessage());
		} catch (IOException ex2) {
			System.out.println("Reading from file failed: " + ex2.getMessage());
		}
	}

	public ArrayList<Question> getQuest() {
		return quest;
	}

	public Question random() {
		Random rand = new Random();
		int n = rand.nextInt(quest.size()) + 1;
		return quest.get(n - 1);
	}
}
