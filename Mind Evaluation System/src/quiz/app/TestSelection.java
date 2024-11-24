package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestSelection extends JFrame implements ActionListener {
    // Encapsulated instance variables
    private JButton iqTest, eqTest;
    private String name;

    // Constructor
    public TestSelection(String name) {
        this.name = name;

        setUpFrame();
        setUpHeadingLabels();
        setUpTestButtons();
    }

    // Set up the main frame settings
    private void setUpFrame() {
        getContentPane().setBackground(new Color(0x4F0D03));
        setLayout(null);

        // Adjust the JFrame size
        setSize(800, 400);
        setLocationRelativeTo(null); // Centers the JFrame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Set up the heading labels
    private void setUpHeadingLabels() {
        JLabel line1 = new JLabel("Welcome To");
        line1.setFont(new Font("Mongolian Baiti", Font.BOLD, 28));
        line1.setForeground(new Color(0xEFA43C));
        line1.setBounds(100, 80, 600, 40);
        line1.setHorizontalAlignment(SwingConstants.CENTER);
        add(line1);

        JLabel line2 = new JLabel("Mind Evaluation System");
        line2.setFont(new Font("Mongolian Baiti", Font.BOLD, 28));
        line2.setForeground(new Color(0xEFA43C));
        line2.setBounds(100, 130, 600, 40);
        line2.setHorizontalAlignment(SwingConstants.CENTER);
        add(line2);

        JLabel line3 = new JLabel("Select Your Test");
        line3.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        line3.setForeground(new Color(0xEFA43C));
        line3.setBounds(100, 180, 600, 40);
        line3.setHorizontalAlignment(SwingConstants.CENTER);
        add(line3);
    }

    // Set up the test buttons
    private void setUpTestButtons() {
        // IQ Test Button
        iqTest = new JButton("IQ Test");
        iqTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
        iqTest.setBackground(new Color(0xEFA43C));
        iqTest.setForeground(new Color(0x4F0D03));
        iqTest.addActionListener(this);
        iqTest.setBounds(150, 250, 200, 50);
        iqTest.setFocusPainted(false);
        iqTest.setBorderPainted(false);
        add(iqTest);

        // EQ Test Button
        eqTest = new JButton("EQ Test");
        eqTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
        eqTest.setBackground(new Color(0xEFA43C));
        eqTest.setForeground(new Color(0x4F0D03));
        eqTest.addActionListener(this);
        eqTest.setBounds(400, 250, 200, 50);
        eqTest.setFocusPainted(false);
        eqTest.setBorderPainted(false);
        add(eqTest);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == iqTest) {
            setVisible(false);
            new IQ(name); // Redirect to IQ Test
        } else if (e.getSource() == eqTest) {
            setVisible(false);
            new EQTest(name); // Redirect to EQ Test
        }
    }

    public static void main(String[] args) {
        new TestSelection("User");
    }
}
