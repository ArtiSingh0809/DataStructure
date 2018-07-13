package com.test.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.test.constant.AppConstant;
import com.test.model.TransactionReport;

public class ExcelWriter {

	public void writeFile(List<TransactionReport> transactionReports){
		int rowCount = 0;
		try (FileOutputStream fileOutputStream = new FileOutputStream(new File(AppConstant.TRANSACTION_REPORT));
			Workbook workbook = new XSSFWorkbook();){
			Sheet sheet = workbook.createSheet("Charge Report");
			Row row = sheet.createRow(rowCount);
			++rowCount;
			writeHeader(row);
			for(TransactionReport transactionReport :transactionReports) {
				row = sheet.createRow(rowCount);
				writeReport(transactionReport,row);
				++rowCount;
			}
			workbook.write(fileOutputStream);
			workbook.close();
		} catch (FileNotFoundException  e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeReport(TransactionReport transactionReport, Row row) {
		row.createCell(0).setCellValue(transactionReport.getClientId());
		row.createCell(1).setCellValue(transactionReport.getTransactionType());
		row.createCell(2).setCellValue(transactionReport.getTransactionDate());
		row.createCell(3).setCellValue(transactionReport.getPriorityFlag());
		row.createCell(4).setCellValue(transactionReport.getProcessingFee());
		
	}

	private void writeHeader(Row row) {
		row.createCell(0).setCellValue("Client Id");
		row.createCell(1).setCellValue("Transaction Type");
		row.createCell(2).setCellValue("Transaction Date");
		row.createCell(3).setCellValue("Priority");
		row.createCell(4).setCellValue("Processing Fee");
	}
	
	
}
