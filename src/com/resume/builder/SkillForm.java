package com.resume.builder;

import javax.swing.*;
import java.awt.*;
public class SkillForm extends JFrame {
    public SkillForm(String name,String email,String phone,String address,String degree,String university,String year, String grade,String company,String role,String years,String responsibilities) {
        setTitle("Resume Builder- Skills ");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel skillsLabel=new JLabel("Enter your skills(comma-seperated or line-by-line).");
        JTextArea skillsArea=new JTextArea(6,30);
        JScrollPane scrollPane=new JScrollPane(skillsArea);

        JButton generateButton= new JButton("Generate Resume");
        JPanel panel =new JPanel(new GridBagLayout());
        GridBagConstraints gbc =new GridBagConstraints();
        gbc.insets=new Insets(10,10,10,10);
        gbc.anchor=GridBagConstraints.WEST;

        gbc.gridx=0;gbc.gridy=0;
        panel.add(skillsLabel,gbc);
        gbc.gridx=1;
        panel.add(scrollPane,gbc);

        gbc.gridx=1;gbc.gridy=1;
        panel.add(generateButton);

        add(panel);
        setVisible(true);

        String[] templates={"Modern", "Professional"};
        JComboBox<String> template_selector=new JComboBox<>(templates);
        gbc.gridx=0;
        gbc.gridy++;
        panel.add(new JLabel("Choose Template:"),gbc);
        gbc.gridx=1;
        panel.add(template_selector,gbc);

        generateButton.addActionListener(e->{
            String skillsInput=skillsArea.getText().trim();

            if(skillsInput.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Please enter atleast one skill");
                return;
            }
            dispose();
            String selectedTemplate=(String) template_selector.getSelectedItem();
            ResumeGenerator.generate(name,email,phone,address,degree ,university,year,grade,company,role,years,responsibilities,skillsInput,selectedTemplate);
        });

    }


}
