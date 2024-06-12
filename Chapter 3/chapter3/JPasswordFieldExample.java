package chapter3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPasswordFieldExample {

    public static void main(String[] args) {
        JFrame f = new JFrame("Login Example");

        // Username Label and TextField
        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameField = new JTextField();
        usernameLabel.setBounds(20, 50, 100, 30); // x, y, width, height
        usernameField.setBounds(100, 50, 120, 30);

        // Password Label and PasswordField
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField();
        passwordLabel.setBounds(20, 100, 100, 30); // x, y, width, height
        passwordField.setBounds(100, 100, 120, 30);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(100, 150, 120, 30);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        });

        // Add components to the frame
        f.add(usernameLabel);
        f.add(usernameField);
        f.add(passwordLabel);
        f.add(passwordField);
        f.add(submitButton);

        // Frame settings
        f.setLayout(null);
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}