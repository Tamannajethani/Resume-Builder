package com.resume.builder;

import javax.swing.*;

public class ResumeBuilder
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(()->new PersonalInfoForm());
    }
}
