package com.resume.builder;

import javax.swing.*;
import java.awt.*;

public class EducationForm extends JFrame{
    public EducationForm(String name,String email,String phone ,String address)
    {
        setTitle("Resume Builder- Education Info");
        setSize(500,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel degreeLabel=new JLabel("Degree:");
        JTextField degreeField=new JTextField(30);

        JLabel universityLabel=new JLabel("University:");
        JTextField universityField=new JTextField(30);

        JLabel yearLabel=new JLabel("Year of Passing:");
        JTextField yearField=new JTextField(4);

        JLabel gradeLabel=new JLabel("Grade:");
        JTextField gradeField=new JTextField(5);

        JButton nextButton =new JButton("Next");

        JPanel panel =new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(10,10,10,10);
        gbc.anchor=GridBagConstraints.WEST;

        gbc.gridx=0; gbc.gridy=0;
        panel.add(degreeLabel,gbc);
        gbc.gridx=1;
        panel.add(degreeField,gbc);

        gbc.gridx=0; gbc.gridy=1;
        panel.add(universityLabel,gbc);
        gbc.gridx=1;
        panel.add(universityField,gbc);

        gbc.gridx=0; gbc.gridy=2;
        panel.add(yearLabel,gbc);
        gbc.gridx=1;
        panel.add(yearField,gbc);

        gbc.gridx=0; gbc.gridy=3;
        panel.add(gradeLabel,gbc);
        gbc.gridx=1;
        panel.add(gradeField,gbc);

        gbc.gridx=1; gbc.gridy=4;
        panel.add(nextButton,gbc);

        add(panel);
        setVisible(true);

        nextButton.addActionListener(e->{
            String degree=degreeField.getText().trim();
            String university=universityField.getText().trim();
            String year=yearField.getText().trim();
            String grade=gradeField.getText().trim();

            if(degree.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Please enter your degree");
                return;
            }

            if(university.isEmpty() || !university.matches("[a-zA-Z .&()]+"))
            {
                JOptionPane.showMessageDialog(this,"Please enter a valid univeraity or college name(only aalphabets)");
                return;
            }
            if(year.isEmpty() || !year.matches("\\d{4}"))
            {
                JOptionPane.showMessageDialog(this,"Please enter a valid year of passing");
                return;
            }

            if(grade.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Please enter a valid grade or percentage");
                return;
            }
            dispose();
            new ExperienceForm(name,email,phone,address,degree,university,year,grade);
        });






    }
}
