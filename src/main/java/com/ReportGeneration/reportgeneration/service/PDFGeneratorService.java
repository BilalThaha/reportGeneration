package com.ReportGeneration.reportgeneration.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfDocument;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class PDFGeneratorService {
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        Paragraph paragraph = new Paragraph("This is the title", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontTitle.setSize(12);
        Paragraph paragraph2 = new Paragraph("This is a paragraph", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(paragraph2);
        document.close();
    }

    public void export1(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        float width = document.getPageSize().getWidth();
        float height = document.getPageSize().getHeight();
        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        Paragraph paragraph = new Paragraph("This is the title", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontTitle.setSize(12);
        Paragraph paragraph2 = new Paragraph("This is a paragraph", fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        float[] columnDefinitionSize = { 33.33F, 66.33F };

        float pos = height / 2;
        PdfPTable table = null;
        PdfPCell cell = null;

        table = new PdfPTable(columnDefinitionSize);
        table.getDefaultCell().setBorder(0);
        table.setHorizontalAlignment(0);
        table.setTotalWidth(width - 72);
        table.setLockedWidth(true);

        // cell = new PdfPCell(new Phrase("Table added with document.add()"));
        // cell.setColspan(columnDefinitionSize.length);
        // table.addCell(cell);
        table.addCell(new Phrase("Louis Pasteur", fontParagraph));
        table.addCell(new Phrase("Albert Einstein", fontParagraph));
        table.addCell(new Phrase("Isaac Newton", fontParagraph));
        table.addCell(new Phrase("8, Rabic street", fontParagraph));
        table.addCell(new Phrase("2 Photons Avenue", fontParagraph));
        table.addCell(new Phrase("32 Gravitation Court", fontParagraph));
        table.addCell(new Phrase("39100 Dole France", fontParagraph));
        table.addCell(new Phrase("12345 Ulm Germany", fontParagraph));
        table.addCell(new Phrase("45789 Cambridge  England", fontParagraph));

        document.add(paragraph);
        document.add(paragraph2);
        document.add(table);
        document.close();
    }

    // public void export2(HttpServletResponse response) throws DocumentException,
    // IOException {
    // Document document = new Document(PageSize.A4);
    // PdfWriter.getInstance(document, response.getOutputStream());

    // PdfWriter writer = new PdfWriter(dest);

    // // Creating a PdfDocument object
    // PdfDocument pdf = new PdfDocument(writer);

    // // Creating a Document object
    // Document doc = new Document(pdf);

    // // Creating a table
    // float [] pointColumnWidths = {150F, 150F, 150F};
    // Table table = new Table(pointColumnWidths);

    // // Adding cells to the table
    // table.addCell(new Cell().add("Name"));
    // table.addCell(new Cell().add("Raju"));
    // table.addCell(new Cell().add("Id"));
    // table.addCell(new Cell().add("1001"));
    // table.addCell(new Cell().add("Designation"));
    // table.addCell(new Cell().add("Programmer"));

    // // Adding Table to document
    // doc.add(table);

    // // Closing the document
    // doc.close();
    // }
}
