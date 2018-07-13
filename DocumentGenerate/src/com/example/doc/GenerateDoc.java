package com.example.doc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class GenerateDoc {

	public static void main(String[] args) {
		createDocument();

	}

	private static void createDocument() {
		try {
			FileOutputStream out = new FileOutputStream(new File("createdocument.docx"));
			XWPFDocument document = new XWPFDocument();
			XWPFParagraph paragraph = document.createParagraph();
			XWPFRun run = paragraph.createRun();
			run.setItalic(true);
			run.setText("(Note for compilation of Test Conditions: items with box prefilled are required by Q100 or STM specification, empty ones indicate possible additional requirements. For external report remove optional requirements not done. Modify test duration if necessary according to mission profile. Robustness* and relevant duration must be reported only if done)");
			document.write(out);
		    out.close();
		} catch (  IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
