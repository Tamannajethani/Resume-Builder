package com.resume.builder;

import javax.swing.*;
import java.awt.*;


public class PersonalInfoForm extends JFrame {
    public PersonalInfoForm()
    {
        setTitle("Resume Builder - Personal Info");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JLabel nameLabel=new JLabel("Full Name:");
        JTextField nameField= new JTextField(30);
        JLabel emailLabel=new JLabel("Email:");
        JTextField emailField= new JTextField(30);
        JLabel phoneLabel=new JLabel("Phone:");
        JTextField phoneField= new JTextField(30);
        JLabel addressLabel=new JLabel("Address:");
        JTextArea addressArea= new JTextArea(3,30);
        JScrollPane addressPane=new JScrollPane(addressArea);

        JButton nextButton= new JButton("Next");

        JPanel panel =new JPanel(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(10,10,10,10);
        gbc.anchor=GridBagConstraints.WEST;

        gbc.gridx=0; gbc.gridy=0;
        panel.add(nameLabel,gbc);
        gbc.gridx=1;
        panel.add(nameField,gbc);

        gbc.gridx=0; gbc.gridy=1;
        panel.add(emailLabel,gbc);
        gbc.gridx=1;
        panel.add(emailField,gbc);

        gbc.gridx=0; gbc.gridy=2;
        panel.add(phoneLabel,gbc);
        gbc.gridx=1;
        panel.add(phoneField,gbc);

        gbc.gridx=0; gbc.gridy=3;
        panel.add(addressLabel,gbc);
        gbc.gridx=1;
        panel.add(addressPane,gbc);

        gbc.gridx=1; gbc.gridy=4;
        panel.add(nextButton,gbc);

        add(panel);
        setVisible(true);

        nextButton.addActionListener(e->{

            String name=nameField.getText().trim();
            String email=emailField.getText().trim();
            String phone=phoneField.getText().trim();
            String address=addressArea.getText().trim();

            if(name.isEmpty() || !name.matches("[a-zA-Z]+( [a-zA-Z]+)*$")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid full name(only alphabets).");
                return;
            }
            if(email.isEmpty() || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address.");
                return;
            }
            if(phone.isEmpty() || !phone.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid phone number.");
                return;
            }
            if(address.isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Please enter a valid address.");
                return;
            }
            dispose();
        new EducationForm(name,email,phone,address);});

    }
}
