package exercise9;

import java.util.ArrayList;

public class Question{
	private String question;
	private String answer;
	private boolean check;
	private ArrayList<String> choice = new ArrayList<>();
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public ArrayList<String> getChoice() {
		return choice;
	}
	public void setChoice(ArrayList<String> choice) {
		this.choice = choice;
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(question);
		for (int i = 0; i < choice.size(); i++) {
			str.append("\n" + choice.get(i));
		}
		return str.toString();
	}
}
