package exercise9;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class QuizProgram extends JFrame {
	private static final long serialVersionUID = 1L;
	private QuestCollection quest = new QuestCollection();
	private JLabel question = new JLabel("Question");
	private JTextArea data = new JTextArea(10, 30);
	private JLabel answer = new JLabel("Answer");
	private JTextField input = new JTextField(10);
	private JButton check = new JButton("Check answer");
	private JLabel status = new JLabel("");
	private int right = 0, wrong = 0;

	public QuizProgram() {
		this.setTitle("Quiz");
		JPanel panel = new JPanel();
		panel.add(question);

		panel.add(data);
		data.setLineWrap(true);
		data.setWrapStyleWord(true);
		quest.quest();
		data.append(quest.random().toString());

		panel.add(answer);
		panel.add(input);

		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (input.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Choose an option",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						for (int i = 0; i < quest.getQuest().size(); i++) {
							if (data.getText().equals(
									quest.getQuest().get(i).toString())) {
								if (input.getText().equalsIgnoreCase(
										quest.getQuest().get(i).getAnswer())) {
									quest.getQuest().get(i).setCheck(true);
									right++;
								} else {
									wrong++;
								}
								quest.getQuest().remove(i);
							}
						}
						status.setText("Right: " + right + "; wrong: " + wrong);
						data.setText(quest.random().toString());
					}
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null,
							"All questions are answered", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(check);
		panel.add(status);

		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 400);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		QuizProgram quiz = new QuizProgram();
		quiz.setVisible(true);
	}

}
