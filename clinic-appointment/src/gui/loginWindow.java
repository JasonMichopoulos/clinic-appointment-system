package gui;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;


public class loginWindow  {

    public loginWindow(){
        JFrame frame = new JFrame("Login");
        frame.setName("Login/Register Window");
        frame.setSize(300,300);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        panel.add(Box.createVerticalGlue());
        panel.add(loginButton(frame));
        panel.add(Box.createVerticalStrut(20));
        panel.add(registerButton(frame));
        panel.add(Box.createVerticalGlue());
        panel.add(ExitButton(frame));

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    private JButton loginButton(JFrame frame){
        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setFocusable(false);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setFont(new Font("SansSerif", Font.PLAIN,20));
        loginButton.addActionListener(e -> {
            loginDialog(frame);
        });
        return loginButton;
    }

    private JButton registerButton(JFrame frame){
        JButton registerButton = new JButton("Register");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setFocusable(false);
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setFont(new Font("SansSerif", Font.PLAIN,20));
        return registerButton;
    }

    private JButton ExitButton(JFrame frame){
        JButton exitButton = new JButton("EXIT");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setFocusable(false);
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exitButton.setFont(new Font("SansSerif",Font.PLAIN,20));
        exitButton.addActionListener(e -> {
            frame.dispose();
        });
        return exitButton;
    }

    private JDialog loginDialog(JFrame frame){
        JDialog dialog = new JDialog(frame,"Login",true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(frame);
        dialog.setSize(300,300);
        dialog.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JTextField amkaField = TextField();
        JTextField phoneField = TextField();

        panel.add(Box.createVerticalGlue());
        panel.add(Label("AMKA"));
        panel.add(amkaField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(Label("Phone Number"));
        panel.add(phoneField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(okayButton(frame));
        panel.add(Box.createVerticalGlue());

        dialog.setContentPane(panel);
        dialog.setVisible(true);
        return dialog;
    }

    private JButton okayButton(JFrame frame){
        JButton okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        okButton.setFont(new Font("SansSerif",Font.PLAIN,20));

        return okButton;
    }

    private JLabel Label(String text){
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif",Font.PLAIN,20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;

    }

    private JTextField TextField(){
        JTextField field = new JTextField();
        field.setFont(new Font("SansSerif",Font.PLAIN,20));
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        field.setPreferredSize(new Dimension(150,field.getPreferredSize().height));
        field.setMaximumSize(new Dimension(150,25));
        return field;
    }
}
