package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EQTest extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    EQTest(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(new Color(0x4F0D03));
        setUndecorated(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eq-01.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);

        // Set text color to 0xEFA43C
        Color textColor = new Color(0xEFA43C);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        qno.setForeground(textColor);  // Set text color
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        question.setForeground(textColor);  // Set text color
        add(question);

        // Define questions and answers
        questions[0][0] = "How do you build and maintain trust in your relationships?";
        questions[0][1] = "By being honest and transparent in my communication";
        questions[0][2] = "By consistently following through on promises and commitments";
        questions[0][3] = "By showing empathy and understanding when the other person is in need";
        questions[0][4] = "By respecting boundaries and valuing the other person's perspective";

        questions[1][0] = "What keeps you motivated during challenging times?";
        questions[1][1] = "External rewards";
        questions[1][2] = "Personal growth";
        questions[1][3] = "Fear of failure";
        questions[1][4] = "Support from others";

        questions[2][0] = "When someone is upset, do you:?";
        questions[2][1] = "Offer advice";
        questions[2][2] = "Listen without judgment";
        questions[2][3] = "Avoid the conversation";
        questions[2][4] = "Try to cheer them up or distract them";

        questions[3][0] = "What strategies do you use to control impulsive decisions?";
        questions[3][1] = "Pause and take a deep breath.";
        questions[3][2] = "Consider the consequences.";
        questions[3][3] = "Seek input from others.";
        questions[3][4] = "Focus on long-term goals.";

        questions[4][0] = "How well do you adapt to unexpected changes in your plans?";
        questions[4][1] = "I stay calm and quickly adjust to the new situation.";
        questions[4][2] = "I feel frustrated at first but eventually find a solution.";
        questions[4][3] = "I struggle to adapt and often resist the change.";
        questions[4][4] = "I try to stick to the original plan as much as possible.";

        questions[5][0] = "Can you recognize your emotions as they arise, and do you understand what triggers them?";
        questions[5][1] = "Yes, I can quickly identify and understand my emotions.";
        questions[5][2] = "I recognize them but need time to understand the triggers.";
        questions[5][3] = "I sometimes struggle to identify my emotions.";
        questions[5][4] = "I rarely notice my emotions until they affect my behavior.";

        questions[6][0] = "How do you feel when you’re not performing as well as you expected?";
        questions[6][1] = "Motivated to try harder";
        questions[6][2] = "Frustrated but willing to improve";
        questions[6][3] = "Disappointed and discouraged";
        questions[6][4] = "Indifferent";

        questions[7][0] = "How do you typically react when you’re criticized?";
        questions[7][1] = "I listen and try to improve";
        questions[7][2] = "I get defensive but try to understand";
        questions[7][3] = "I ignore the criticism";
        questions[7][4] = "I feel hurt and withdraw";

        questions[8][0] = "How do you handle disagreements in a group setting?";
        questions[8][1] = "I listen to all sides and help find a compromise";
        questions[8][2] = "I stand my ground and try to convince others";
        questions[8][3] = "I avoid confrontation and let others decide";
        questions[8][4] = "I stay quiet and wait for the conflict to resolve itself";

        questions[9][0] = "How often do you take a break or step back before reacting to a stressful situation?";
        questions[9][1] = "Always";
        questions[9][2] = "Sometimes";
        questions[9][3] = "Rarely";
        questions[9][4] = "Never";

        answers[0][1] = "By consistently following through on promises and commitments";
        answers[1][1] = "Personal growth";
        answers[2][1] = "Try to cheer them up or distract them";
        answers[3][1] = "Consider the consequences.";
        answers[4][1] = "I stay calm and quickly adjust to the new situation.";
        answers[5][1] = "Yes, I can quickly identify and understand my emotions.";
        answers[6][1] = "Motivated to try harder";
        answers[7][1] = "I listen and try to improve";
        answers[8][1] = "I listen to all sides and help find a compromise";
        answers[9][1] = "Always";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(new Color(0x4F0D03));
        opt1.setForeground(textColor);  // Set text color
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(new Color(0x4F0D03));
        opt2.setForeground(textColor);  // Set text color
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(new Color(0x4F0D03));
        opt3.setForeground(textColor);  // Set text color
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(new Color(0x4F0D03));
        opt4.setForeground(textColor);  // Set text color
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(850, 750, 200, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setFocusPainted(false);  // Remove focus border
        next.setBorderPainted(false); // Remove button border
        add(next);



//        lifeline = new JButton("Help");
//        lifeline.setBounds(930, 750, 200, 30);
//        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 18));
//        lifeline.setBackground(new Color(22, 99, 54));
//        lifeline.setForeground(Color.WHITE);
//        lifeline.addActionListener(this);
//        add(lifeline);
        submit = new JButton("Submit");
        submit.setBounds(1100, 750, 200, 30); // Move the button to the right

        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(new Color(0xFFA500));
        submit.setForeground(new Color(0x4F0D03));  // Set text color
        submit.addActionListener(this);
        submit.setEnabled(false);
        submit.setFocusPainted(false);  // Remove focus border
        submit.setBorderPainted(false); // Remove button border
        add(submit);


        start(count);
        setUndecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            // Disable options based on the current question index
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            // Calculate score
            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score, "EQ");
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score, "EQ");
            } else {
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new EQTest("Player");
    }
}
