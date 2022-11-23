package com.example.Rejestrator.view;


import com.example.Rejestrator.model.Donor;
import com.example.Rejestrator.model.Semen;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class View {


    public static void createSelectedPdf(Donor donor, List<Semen> list) throws IOException {



            String userDefPath = System.getProperty("user.dir")+"\\Rejestrator_pliki";


            new File(userDefPath + "/dawcy").mkdirs();
             String dest = userDefPath + "/dawcy/" + donor.getTag() + ".pdf";
            PdfWriter writer = new PdfWriter(dest);


            // Creating a PdfDocument
            PdfDocument pdfDoc = new PdfDocument(writer);

            // Adding a new page
            pdfDoc.addNewPage();

            // Creating a Document
            Document document = new Document(pdfDoc);

            float[] pointColumnWidths = {250F, 450F};
            float[] threeColumns = {150F, 250F, 350F};
            float[] sixColumns = {150F, 150F, 150F, 150F, 150F, 150F};
            Table table = new Table(pointColumnWidths);

            FontProgram fontProgram = FontProgramFactory.createFont();
            PdfFont font = PdfFontFactory.createFont(fontProgram, "Cp1250");

            document.setFont(font);

            table.addCell(new Cell().add(new Paragraph("Numer świadectwa")));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(donor.getNumberOfCertificate()))));
            table.addCell(new Cell().add(new Paragraph("Nazwa księgi hodowlanej")));
            table.addCell(new Cell().add(new Paragraph(donor.getStudbookName())));
            table.addCell(new Cell().add(new Paragraph("Nazwa rasy samca dawcy")));
            table.addCell(new Cell().add(new Paragraph(donor.getDonorBreedName())));
            table.addCell(new Cell().add(new Paragraph("Numer samca-dawcy w księdze hodowlanej")));
            table.addCell(new Cell().add(new Paragraph(donor.getTag())));
            document.add(table);
            document.add(new Paragraph("Dane identyfikacyjne samca dawcy"));
            Table table2 = new Table(pointColumnWidths);
            table2.addCell(new Cell().add(new Paragraph("Kolczyk")));
            table2.addCell(new Cell().add(new Paragraph(donor.getTag())));
            table2.addCell(new Cell().add(new Paragraph("Imię")));
            table2.addCell(new Cell().add(new Paragraph(donor.getName())));
            table2.addCell(new Cell().add(new Paragraph("Data urodzenia")));
            table2.addCell(new Cell().add(new Paragraph(String.valueOf(donor.getTimeOfBirth()))));
            table2.addCell(new Cell().add(new Paragraph("Miejsce urodzenia")));
            table2.addCell(new Cell().add(new Paragraph(donor.getPlaceOfBirth())));
            table2.addCell(new Cell().add(new Paragraph("Imię i nazwisko hodowcy")));
            table2.addCell(new Cell().add(new Paragraph(donor.getGrowerName())));
            table2.addCell(new Cell().add(new Paragraph("Adres hodowcy")));
            table2.addCell(new Cell().add(new Paragraph(donor.getGrowerAddress())));
            table2.addCell(new Cell().add(new Paragraph("Imię i nazwisko właściciela")));
            table2.addCell(new Cell().add(new Paragraph(donor.getOwnerName())));
            table2.addCell(new Cell().add(new Paragraph("Adrees właściciela")));
            table2.addCell(new Cell().add(new Paragraph(donor.getOwnerAddress())));
            table2.addCell(new Cell().add(new Paragraph("Metoda")));
            table2.addCell(new Cell().add(new Paragraph(donor.getMethod())));
            document.add(table2);
            document.add(new Paragraph("Rodowód samca dawcy"));
            Table table3 = new Table(threeColumns);
            table3.addCell(new Cell().add(new Paragraph("Ojciec")));
            table3.addCell(new Cell().add(new Paragraph("Numer w sekcji hodowlanej")));
            table3.addCell(new Cell().add(new Paragraph(donor.getFatherNumber())));
            table3.addCell(new Cell().add(new Paragraph()));
            table3.addCell(new Cell().add(new Paragraph("Imię")));
            table3.addCell(new Cell().add(new Paragraph(donor.getFatherName())));
            table3.addCell(new Cell().add(new Paragraph("Matka")));
            table3.addCell(new Cell().add(new Paragraph("Numer w sekcji hodowlanej")));
            table3.addCell(new Cell().add(new Paragraph(donor.getMotherNumber())));
            table3.addCell(new Cell().add(new Paragraph()));
            table3.addCell(new Cell().add(new Paragraph("Imię")));
            table3.addCell(new Cell().add(new Paragraph(donor.getMotherName())));
            table3.addCell(new Cell().add(new Paragraph("Dziadek ze strony ojca")));
            table3.addCell(new Cell().add(new Paragraph("Numer w sekcji hodowlanej")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandfatherFatherNumber())));
            table3.addCell(new Cell().add(new Paragraph()));
            table3.addCell(new Cell().add(new Paragraph("Imię")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandfatherFatherName())));
            table3.addCell(new Cell().add(new Paragraph("Babcia ze strony ojca")));
            table3.addCell(new Cell().add(new Paragraph("Numer w sekcji hodowlanej")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandmotherFatherNumber())));
            table3.addCell(new Cell().add(new Paragraph()));
            table3.addCell(new Cell().add(new Paragraph("Imię")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandmotherFatherName())));
            table3.addCell(new Cell().add(new Paragraph("Dziadek ze strony matki")));
            table3.addCell(new Cell().add(new Paragraph("Numer w sekcji hodowlanej")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandfatherMotherNumber())));
            table3.addCell(new Cell().add(new Paragraph()));
            table3.addCell(new Cell().add(new Paragraph("Imię")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandfatherMotherName())));
            table3.addCell(new Cell().add(new Paragraph("Babcia ze strony matki")));
            table3.addCell(new Cell().add(new Paragraph("Numer w sekcji hodowlanej")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandmotherMotherNumber())));
            table3.addCell(new Cell().add(new Paragraph()));
            table3.addCell(new Cell().add(new Paragraph("Imię")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandmotherMotherName())));
            document.add(table3);

            for (Semen it : list) {
                document.add(new Paragraph("Informacje dotyczące nasienia"));
                Table table4 = new Table(sixColumns);
                table4.addCell(new Cell().add(new Paragraph("Kolor słomek")));
                table4.addCell(new Cell().add(new Paragraph("Kod słomek")));
                table4.addCell(new Cell().add(new Paragraph("Liczba słomek")));
                table4.addCell(new Cell().add(new Paragraph("Miejsce pobrania nasienia")));
                table4.addCell(new Cell().add(new Paragraph("Data pobrania nasienia")));
                table4.addCell(new Cell().add(new Paragraph("Inne")));
                table4.addCell(new Cell().add(new Paragraph(it.getColor())));
                table4.addCell(new Cell().add(new Paragraph(it.getColorB())));
                table4.addCell(new Cell().add(new Paragraph(String.valueOf(it.getAmount()))));
                table4.addCell(new Cell().add(new Paragraph(it.getPlaceOfDrawing())));
                table4.addCell(new Cell().add(new Paragraph(String.valueOf(it.getDate()))));
                table4.addCell(new Cell().add(new Paragraph(it.getOthers())));
                document.add(table4);
                Table table5 = new Table(pointColumnWidths);
                table5.addCell(new Cell().add(new Paragraph("Imię i nazwisko odbiorcy")));
                table5.addCell(new Cell().add(new Paragraph(it.getRecipientName())));
                table5.addCell(new Cell().add(new Paragraph("Adres odbiorcy")));
                table5.addCell(new Cell().add(new Paragraph(it.getRecipientAddress())));
                document.add(table5);
            }
            // Closing the document
            document.close();
            System.out.println("PDF Created");


    }

    public static void createPdf(Donor donor) throws IOException {
//        String userDefPath = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\Rejestrator_pliki";
//
//
//        new File(userDefPath+ "/dawcy_wszystkie_pobrania").mkdirs();
//        String dest = userDefPath+ "/dawcy_wszystkie_pobrania/" + donor.getTag() +".pdf";


            //String userDefPath = View.detectOS() + System.getProperty("user.name") + "\\Desktop\\Rejestrator_pliki";
            String userDefPath = System.getProperty("user.dir")+ "\\Rejestrator_pliki";

            new File(userDefPath + "/dawcy").mkdirs();
            String dest = userDefPath + "/dawcy/" + donor.getTag() + ".pdf";



            PdfWriter writer = new PdfWriter(dest);

            // Creating a PdfDocument
            PdfDocument pdfDoc = new PdfDocument(writer);

            // Adding a new page
            pdfDoc.addNewPage();

            // Creating a Document
            Document document = new Document(pdfDoc);

            float[] pointColumnWidths = {250F, 450F};
            float[] threeColumns = {150F, 250F, 350F};
            float[] sixColumns = {150F, 150F, 150F, 150F, 150F, 150F};
            Table table = new Table(pointColumnWidths);

            FontProgram fontProgram = FontProgramFactory.createFont();
            PdfFont font = PdfFontFactory.createFont(fontProgram, "Cp1250");

            document.setFont(font);

            table.addCell(new Cell().add(new Paragraph("Numer świadectwa")));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(donor.getNumberOfCertificate()))));
            table.addCell(new Cell().add(new Paragraph("Nazwa księgi hodowlanej")));
            table.addCell(new Cell().add(new Paragraph(donor.getStudbookName())));
            table.addCell(new Cell().add(new Paragraph("Nazwa rasy samca dawcy")));
            table.addCell(new Cell().add(new Paragraph(donor.getDonorBreedName())));
            table.addCell(new Cell().add(new Paragraph("Numer samca-dawcy w księdze hodowlanej")));
            table.addCell(new Cell().add(new Paragraph(donor.getTag())));
            document.add(table);
            document.add(new Paragraph("Dane identyfikacyjne samca dawcy"));
            Table table2 = new Table(pointColumnWidths);
            table2.addCell(new Cell().add(new Paragraph("Kolczyk")));
            table2.addCell(new Cell().add(new Paragraph(donor.getTag())));
            table2.addCell(new Cell().add(new Paragraph("Imię")));
            table2.addCell(new Cell().add(new Paragraph(donor.getName())));
            table2.addCell(new Cell().add(new Paragraph("Data urodzenia")));
            table2.addCell(new Cell().add(new Paragraph(String.valueOf(donor.getTimeOfBirth()))));
            table2.addCell(new Cell().add(new Paragraph("Miejsce urodzenia")));
            table2.addCell(new Cell().add(new Paragraph(donor.getPlaceOfBirth())));
            table2.addCell(new Cell().add(new Paragraph("Imię i nazwisko hodowcy")));
            table2.addCell(new Cell().add(new Paragraph(donor.getGrowerName())));
            table2.addCell(new Cell().add(new Paragraph("Adres hodowcy")));
            table2.addCell(new Cell().add(new Paragraph(donor.getGrowerAddress())));
            table2.addCell(new Cell().add(new Paragraph("Imię i nazwisko właściciela")));
            table2.addCell(new Cell().add(new Paragraph(donor.getOwnerName())));
            table2.addCell(new Cell().add(new Paragraph("Adrees właściciela")));
            table2.addCell(new Cell().add(new Paragraph(donor.getOwnerAddress())));
            table2.addCell(new Cell().add(new Paragraph("Metoda")));
            table2.addCell(new Cell().add(new Paragraph(donor.getMethod())));
            document.add(table2);
            document.add(new Paragraph("Rodowód samca dawcy"));
            Table table3 = new Table(threeColumns);
            table3.addCell(new Cell().add(new Paragraph("Ojciec")));
            table3.addCell(new Cell().add(new Paragraph("Numer w sekcji hodowlanej")));
            table3.addCell(new Cell().add(new Paragraph(donor.getFatherNumber())));
            table3.addCell(new Cell().add(new Paragraph()));
            table3.addCell(new Cell().add(new Paragraph("Imię")));
            table3.addCell(new Cell().add(new Paragraph(donor.getFatherName())));
            table3.addCell(new Cell().add(new Paragraph("Matka")));
            table3.addCell(new Cell().add(new Paragraph("Numer w sekcji hodowlanej")));
            table3.addCell(new Cell().add(new Paragraph(donor.getMotherNumber())));
            table3.addCell(new Cell().add(new Paragraph()));
            table3.addCell(new Cell().add(new Paragraph("Imię")));
            table3.addCell(new Cell().add(new Paragraph(donor.getMotherName())));
            table3.addCell(new Cell().add(new Paragraph("Dziadek ze strony ojca")));
            table3.addCell(new Cell().add(new Paragraph("Numer w sekcji hodowlanej")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandfatherFatherNumber())));
            table3.addCell(new Cell().add(new Paragraph()));
            table3.addCell(new Cell().add(new Paragraph("Imię")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandfatherFatherName())));
            table3.addCell(new Cell().add(new Paragraph("Babcia ze strony ojca")));
            table3.addCell(new Cell().add(new Paragraph("Numer w sekcji hodowlanej")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandmotherFatherNumber())));
            table3.addCell(new Cell().add(new Paragraph()));
            table3.addCell(new Cell().add(new Paragraph("Imię")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandmotherFatherName())));
            table3.addCell(new Cell().add(new Paragraph("Dziadek ze strony matki")));
            table3.addCell(new Cell().add(new Paragraph("Numer w sekcji hodowlanej")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandfatherMotherNumber())));
            table3.addCell(new Cell().add(new Paragraph()));
            table3.addCell(new Cell().add(new Paragraph("Imię")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandfatherMotherName())));
            table3.addCell(new Cell().add(new Paragraph("Babcia ze strony matki")));
            table3.addCell(new Cell().add(new Paragraph("Numer w sekcji hodowlanej")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandmotherMotherNumber())));
            table3.addCell(new Cell().add(new Paragraph()));
            table3.addCell(new Cell().add(new Paragraph("Imię")));
            table3.addCell(new Cell().add(new Paragraph(donor.getGrandmotherMotherName())));
            document.add(table3);

            for (Semen it : donor.getSemenList()) {
                document.add(new Paragraph("Informacje dotyczące nasienia"));
                Table table4 = new Table(sixColumns);
                table4.addCell(new Cell().add(new Paragraph("Kolor słomek")));
                table4.addCell(new Cell().add(new Paragraph("Kod słomek")));
                table4.addCell(new Cell().add(new Paragraph("Liczba słomek")));
                table4.addCell(new Cell().add(new Paragraph("Miejsce pobrania nasienia")));
                table4.addCell(new Cell().add(new Paragraph("Data pobrania nasienia")));
                table4.addCell(new Cell().add(new Paragraph("Inne")));
                table4.addCell(new Cell().add(new Paragraph(it.getColor())));
                table4.addCell(new Cell().add(new Paragraph(it.getColorB())));
                table4.addCell(new Cell().add(new Paragraph(String.valueOf(it.getAmount()))));
                table4.addCell(new Cell().add(new Paragraph(it.getPlaceOfDrawing())));
                table4.addCell(new Cell().add(new Paragraph(String.valueOf(it.getDate()))));
                table4.addCell(new Cell().add(new Paragraph(it.getOthers())));
                document.add(table4);
                Table table5 = new Table(pointColumnWidths);
                table5.addCell(new Cell().add(new Paragraph("Imię i nazwisko odbiorcy")));
                table5.addCell(new Cell().add(new Paragraph(it.getRecipientName())));
                table5.addCell(new Cell().add(new Paragraph("Adres odbiorcy")));
                table5.addCell(new Cell().add(new Paragraph(it.getRecipientAddress())));
                document.add(table5);
            }
            // Closing the document
            document.close();
            System.out.println("PDF Created");

    }



}
