package com.resume.builder;

import javax.swing.*;
import java.awt.*;

public class ExperienceForm extends JFrame {
    public ExperienceForm(String name,String email,String phone ,String address,String degree, String university,String year,String grade)
    {
        setTitle("Resume Builder-Experience Form");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel companyLabel=new JLabel("Company Name:");
        JTextField companyField =new JTextField(30);

        JLabel roleLabel=new JLabel("Role/Job Title:");
        JTextField roleField =new JTextField(30);

        JLabel yearsLabel=new JLabel("Years of Experience:");
        JTextField yearsField =new JTextField(4);

        JLabel responsibilitiesLabel=new JLabel("Responsibilities:");
        JTextArea responsibilitiesArea =new JTextArea(4,30);
        JScrollPane scrollPane=new JScrollPane(responsibilitiesArea);

        JButton nextButton = new JButton("Next");

        JPanel panel=new JPanel(new GridBagLayout());
        GridBagConstraints gbc =new GridBagConstraints();
        gbc.insets=new Insets(10,10,10,10);
        gbc.anchor=GridBagConstraints.WEST;

        gbc.gridx=0;gbc.gridy=0;
        panel.add(companyLabel,gbc);
        gbc.gridx=1;
        panel.add(companyField,gbc);

        gbc.gridx=0;gbc.gridy=1;
        panel.add(roleLabel,gbc);
        gbc.gridx=1;
        panel.add(roleField,gbc);

        gbc.gridx=0;gbc.gridy=2;
        panel.add(yearsLabel,gbc);
        gbc.gridx=1;
        panel.add(yearsField,gbc);

        gbc.gridx=0;gbc.gridy=3;
        panel.add(responsibilitiesLabel,gbc);
        gbc.gridx=1;
        panel.add(responsibilitiesArea,gbc);

        gbc.gridx=1;gbc.gridy=4;
        panel.add(nextButton,gbc);

        add(panel);
        setVisible(true);

        nextButton.addActionListener(e->{
            String company=companyField.getText().trim();
            String role=roleField.getText().trim();
            String years=yearsField.getText().trim();
            String responsibilities=responsibilitiesArea.getText().trim();
            if(company.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"PLease enter a valid company name.");
                return;
            }
            if(role.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"PLease enter a valid job tile or role.");
                return;
            }
            if(years.isEmpty() || !years.matches("\\d+") || Integer.parseInt(years)>50)
            {
                JOptionPane.showMessageDialog(this,"PLease enter a valid no. of years.");
                return;
            }
            if(responsibilities.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"PLease describe your responsibilities(write few words).");
                return;
            }

            dispose();
            new SkillForm(name,email,phone,address,degree,university,year,grade,company,role,years,responsibilities);
        });


        



    }
}
