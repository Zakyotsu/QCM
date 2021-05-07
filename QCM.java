package fr.vinet.qcm;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class QCM extends JFrame {

    private ArrayList<Question> questions;
    private JLabel lblQuestion, lblTheme, lblCommentaire, lblScore;
    private JButton btnValider;
    private JRadioButton proposition1, proposition2, proposition3, proposition4, proposition5;
    private ButtonGroup bg;
    private int currentQuestion;
    private ArrayList<JRadioButton> radioButtons;
    private int score;

    /**
     * Generates JFrame element and shows it
     */
    public QCM() {
        questions = DAO.getQuestions();
        radioButtons = new ArrayList<>();
        currentQuestion = 0;
        score = 0;
        setTitle("QCM");
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        //Initialisation variables
        btnValider = new JButton("Valider");
        lblQuestion = new JLabel("", SwingConstants.CENTER);
        lblTheme = new JLabel("", SwingConstants.CENTER);
        lblCommentaire = new JLabel("", SwingConstants.CENTER);
        lblScore = new JLabel("Score: 0/" + questions.size(), SwingConstants.CENTER);
        proposition1 = new JRadioButton();
        proposition2 = new JRadioButton();
        proposition3 = new JRadioButton();
        proposition4 = new JRadioButton();
        proposition5 = new JRadioButton();
        bg = new ButtonGroup();


        btnValider.addActionListener(e -> {
            Question q = questions.get(currentQuestion);
            String userAnswer = "";
            for(JRadioButton jrb : radioButtons) {
                if(jrb.isSelected()) userAnswer = jrb.getText();
            }
            if(userAnswer.equals("")) {
                JOptionPane.showMessageDialog(null, "Sélectionnez au moins une proposition.", "Erreur", JOptionPane.NO_OPTION);
                return;
            }

            if(q.isGoodAnswer(userAnswer)) {
                JOptionPane.showMessageDialog(null, "Bonne réponse !", "Info", JOptionPane.NO_OPTION);
                score++;
            } else JOptionPane.showMessageDialog(null, "Dommage... Mauvaise réponse :(", "Info", JOptionPane.NO_OPTION);

            updateUI(++currentQuestion);
        });


        btnValider.setBounds(207, 241, 78, 23);
        lblQuestion.setBounds(10, 45, 480, 30);
        lblTheme.setBounds(10, 10, 480, 30);
        lblCommentaire.setBounds(10, 80, 480, 30);
        lblScore.setBounds(400, 250, 90, 10);
        proposition1.setBounds(35, 105, 410, 23);
        proposition2.setBounds(35, 131, 410, 23);
        proposition3.setBounds(35, 158, 410, 23);
        proposition4.setBounds(35, 185, 410, 23);
        proposition5.setBounds(35, 211, 410, 23);

        bg.add(proposition2);
        bg.add(proposition3);
        bg.add(proposition4);
        bg.add(proposition1);
        bg.add(proposition5);

        radioButtons.add(proposition1);
        radioButtons.add(proposition2);
        radioButtons.add(proposition3);
        radioButtons.add(proposition4);
        radioButtons.add(proposition5);

        getContentPane().add(btnValider);
        getContentPane().add(lblQuestion);
        getContentPane().add(lblTheme);
        getContentPane().add(lblCommentaire);
        getContentPane().add(lblScore);
        getContentPane().add(proposition1);
        getContentPane().add(proposition2);
        getContentPane().add(proposition3);
        getContentPane().add(proposition4);
        getContentPane().add(proposition5);

        updateUI(currentQuestion);

        setVisible(true);
    }

    /**
     * Updates the UI
     * @param questionID ID of question
     */
    public void updateUI(int questionID) {
        Question q = questions.get(questionID);
        String[] leurres = q.getLeurres();
        String answer = q.getAnswer();

        //On mélange les propositions et la bonne réponse
        ArrayList<String> propositions = new ArrayList<>();
        for(String leurre : leurres) propositions.add(leurre);
        propositions.add(answer);
        Collections.shuffle(propositions);
        propositions.remove("");

        lblQuestion.setText("<html>Question " + (questionID+1) + ": " + q.getQuestion() + "</html>");
        lblTheme.setText("<html>" + q.getTheme() + "</html>");

        if(!q.getComment().equals("")) {
            lblCommentaire.setVisible(true);
            lblCommentaire.setText("Commentaire: " + q.getComment());
        } else lblCommentaire.setVisible(false);

        for(int i = 0; i < 5; i++) {
            try {
                radioButtons.get(i).setText(propositions.get(i));
                radioButtons.get(i).setVisible(true);
            } catch(IndexOutOfBoundsException e) {
                radioButtons.get(i).setVisible(false);
            }
        }

        lblScore.setText("Score: " + score + "/" + questions.size());
    }
}
