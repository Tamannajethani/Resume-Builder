package com.resume.builder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

public class ResumeGenerator {

    // MAIN METHOD: Called from SkillForm with all data and selected template
    public static void generate(String name, String email, String phone, String address,
                                String degree, String university, String year, String grade,
                                String company, String role, String years, String responsibilities,
                                String skills, String template) {

        try {
            // Step 1: Create PDF document
            Document document = new Document();
            String filePath = "Generated_Resume.pdf";
            File file = new File(filePath);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            // Step 2: Generate content based on template
            if (template.equalsIgnoreCase("Modern")) {
                generateModernLayout(document, name, email, phone, address,
                        degree, university, year, grade,
                        company, role, years, responsibilities, skills);
            } else {
                generateProfessionalLayout(document, name, email, phone, address,
                        degree, university, year, grade,
                        company, role, years, responsibilities, skills);
            }

            document.close();

            // Step 3: Open PDF for preview
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file); // Opens in system's default viewer
            }

            // Step 4: Ask user to keep or discard the file
            int choice = JOptionPane.showConfirmDialog(null,
                    "Do you want to save this resume?",
                    "Confirm Download", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.NO_OPTION) {
                file.delete();
                JOptionPane.showMessageDialog(null, "Resume discarded.");
            } else {
                JOptionPane.showMessageDialog(null, "Resume saved at:\n" + file.getAbsolutePath());
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error generating resume:\n" + e.getMessage());
        }
    }

    // TEMPLATE 1: Modern Layout
    private static void generateModernLayout(Document document, String name, String email, String phone, String address,
                                             String degree, String university, String year, String grade,
                                             String company, String role, String years, String responsibilities,
                                             String skills) throws DocumentException {

        Font nameFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, BaseColor.DARK_GRAY);
        Font sectionFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
        Font normalFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

        Paragraph namePara = new Paragraph(name, nameFont);
        namePara.setAlignment(Element.ALIGN_CENTER);
        document.add(namePara);

        Paragraph contact = new Paragraph(email + " | " + phone, normalFont);
        contact.setAlignment(Element.ALIGN_CENTER);
        document.add(contact);

        Paragraph addr = new Paragraph(address + "\n\n", normalFont);
        addr.setAlignment(Element.ALIGN_CENTER);
        document.add(addr);

        document.add(new Paragraph("Education", sectionFont));
        document.add(new Paragraph(degree + ", " + university, normalFont));
        document.add(new Paragraph("Year: " + year + " | Grade: " + grade + "\n", normalFont));

        document.add(new Paragraph("Experience", sectionFont));
        document.add(new Paragraph("Company: " + company, normalFont));
        document.add(new Paragraph("Role: " + role + " | Years: " + years, normalFont));
        document.add(new Paragraph("Responsibilities: " + responsibilities + "\n", normalFont));

        document.add(new Paragraph("Skills", sectionFont));
        document.add(new Paragraph(skills, normalFont));
    }

    // TEMPLATE 2: Professional Layout
    private static void generateProfessionalLayout(Document document, String name, String email, String phone, String address,
                                                   String degree, String university, String year, String grade,
                                                   String company, String role, String years, String responsibilities,
                                                   String skills) throws DocumentException {

        Font nameFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
        Font sectionFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);
        Font textFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.DARK_GRAY);
        LineSeparator line = new LineSeparator();

        document.add(new Paragraph(name, nameFont));
        document.add(new Paragraph("Email: " + email, textFont));
        document.add(new Paragraph("Phone: " + phone, textFont));
        document.add(new Paragraph("Address: " + address + "\n", textFont));
        document.add(line);
        document.add(new Paragraph("\n"));

        document.add(new Paragraph("Education", sectionFont));
        document.add(new Paragraph(degree + ", " + university, textFont));
        document.add(new Paragraph("Year: " + year + " | Grade: " + grade + "\n", textFont));

        document.add(new Paragraph("Experience", sectionFont));
        document.add(new Paragraph("Company: " + company, textFont));
        document.add(new Paragraph("Role: " + role + " | Years: " + years, textFont));
        document.add(new Paragraph("Responsibilities: " + responsibilities + "\n", textFont));

        document.add(new Paragraph("Skills", sectionFont));
        document.add(new Paragraph(skills, textFont));
    }
}
