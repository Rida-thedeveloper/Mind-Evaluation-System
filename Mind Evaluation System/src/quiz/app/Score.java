package quiz.app;import javax.swing.*;import java.awt.*;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.io.BufferedWriter;import java.io.File;import java.io.FileWriter;import java.io.IOException;public class Score extends JFrame {    Score(String name, int score, String testType) {        // Initialize variables for IQ and EQ        final String finalName = name;  // Final variable        final int finalScore = score;   // Final variable        final String finalTestType = testType;  // Final variable        // Color for text (0xEFA43C)        Color textColor = new Color(239, 164, 60);        // Check the test type        int adjustedIQ = 0, adjustedEQ = 0;        if (finalTestType.equalsIgnoreCase("IQ")) {            // Calculate IQ based on score            int baseIQ = 0;   // Base IQ level            int iqMultiplier = 2;  // IQ increases per point            int maxIQ = 160;    // Maximum possible IQ            int iq = baseIQ + (finalScore * iqMultiplier);            adjustedIQ = Math.min(iq, maxIQ);            System.out.println("Calculated IQ: " + adjustedIQ + " / " + maxIQ);        } else if (finalTestType.equalsIgnoreCase("EQ")) {            // Calculate EQ based on score            int baseEQ = 0;    // Base EQ level            int eqMultiplier = 3;  // EQ increases per point            int maxEQ = 150;    // Maximum possible EQ            int eq = baseEQ + (finalScore * eqMultiplier);            adjustedEQ = Math.min(eq, maxEQ);            System.out.println("Calculated EQ: " + adjustedEQ + " / " + maxEQ);        }        // Image        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));        Image i2 = i1.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);        ImageIcon i3 = new ImageIcon(i2);        JLabel image = new JLabel(i3);        image.setBounds(60, 200, 200, 150);        add(image);        // Heading        JLabel heading = new JLabel("Thank you " + finalName + " for Playing!");        heading.setBounds(100, 80, 700, 30);        heading.setFont(new Font("Tahoma", Font.BOLD, 26));        heading.setForeground(textColor);  // Set the text color        // Center the heading horizontally        int labelWidth = 4500; // Get the width of the label        int xPosition = (750 - labelWidth) / 2;  // Center the label based on frame width        heading.setBounds(xPosition, 80, labelWidth, 30);  // Set the new x position        heading.setHorizontalAlignment(SwingConstants.CENTER); // Center text inside the label        add(heading);        // Score Display        JLabel scoreLabel = new JLabel("Your Score: " + finalScore);        scoreLabel.setBounds(350, 200, 500, 30);        scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 26));        scoreLabel.setForeground(textColor);  // Set the text color        add(scoreLabel);        // IQ or EQ Display        if (finalTestType.equalsIgnoreCase("IQ")) {            JLabel iqLabel = new JLabel("Estimated IQ: " + adjustedIQ + " / 160");            iqLabel.setBounds(350, 250, 500, 30);            iqLabel.setFont(new Font("Tahoma", Font.BOLD, 26));            iqLabel.setForeground(textColor);  // Set the text color            add(iqLabel);        } else if (finalTestType.equalsIgnoreCase("EQ")) {            JLabel eqLabel = new JLabel("Estimated EQ: " + adjustedEQ + " / 150");            eqLabel.setBounds(350, 250, 500, 30);            eqLabel.setFont(new Font("Tahoma", Font.BOLD, 26));            eqLabel.setForeground(textColor);  // Set the text color            add(eqLabel);        }        // Exit Button        JButton exit = new JButton("EXIT");        exit.setBounds(380, 370, 120, 30);        exit.setBackground(new Color(0xEFA43C));        exit.setForeground(new Color(0x4F0D03));        exit.setFocusPainted(false);  // Remove focus border        exit.setBorderPainted(false); // Remove button border        add(exit);        // Add Exit Button Action        int finalAdjustedEQ = adjustedEQ;        int finalAdjustedIQ = adjustedIQ;        exit.addActionListener(new ActionListener() {            @Override            public void actionPerformed(ActionEvent e) {                // Store score in relevant file based on test type                if (finalTestType.equalsIgnoreCase("IQ")) {                    storeIQScoreInFile(finalName, finalScore, finalAdjustedIQ);                } else if (finalTestType.equalsIgnoreCase("EQ")) {                    storeEQScoreInFile(finalName, finalScore, finalAdjustedEQ);                }                // Close current window                setVisible(false);                new SessionStarter();            }        });        // Background Image        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/back-01.png"));        Image i22 = i11.getImage().getScaledInstance(750, 550, Image.SCALE_DEFAULT);        ImageIcon i33 = new ImageIcon(i22);        JLabel imagee = new JLabel(i33);        imagee.setBounds(0, 0, 750, 550);        add(imagee);        // Frame Settings        setSize(750, 550);        setLocation(400, 150);        setLayout(null);        setUndecorated(true);        setVisible(true);    }    // Method to store IQ scores    private void storeIQScoreInFile(String name, int score, int iq) {        try {            File file = new File("iq_scores.txt");            FileWriter fileWriter = new FileWriter(file, true); // 'true' to append to the file            BufferedWriter writer = new BufferedWriter(fileWriter);            writer.write("Player: " + name + ", Score: " + score + ", Estimated IQ: " + iq + " / 160");            writer.newLine();            writer.close();            System.out.println("IQ score saved to file successfully.");        } catch (IOException e) {            System.out.println("An error occurred while saving the IQ score.");            e.printStackTrace();        }    }    // Method to store EQ scores    private void storeEQScoreInFile(String name, int score, int eq) {        try {            File file = new File("eq_scores.txt");            FileWriter fileWriter = new FileWriter(file, true); // 'true' to append to the file            BufferedWriter writer = new BufferedWriter(fileWriter);            writer.write("Player: " + name + ", Score: " + score + ", Estimated EQ: " + eq + " / 150");            writer.newLine();            writer.close();            System.out.println("EQ score saved to file successfully.");        } catch (IOException e) {            System.out.println("An error occurred while saving the EQ score.");            e.printStackTrace();        }    }    public static void main(String[] args) {        new Score("User", 10, "IQ");  // Test with IQ        // new Score("User", 10, "EQ");  // Test with EQ    }}