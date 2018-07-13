package com.test.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.test.constant.AppConstant;
import com.test.model.Transaction;

public class ExcelReader {
	
	public List<Transaction> readFile(){
		List<Transaction> transactions = null;
		try (FileInputStream fileInputStream = new FileInputStream(new File(AppConstant.TRANSACTION_FILE));
			Workbook workbook = new XSSFWorkbook(fileInputStream);){
			Sheet sheet = workbook.getSheetAt(0);
			transactions = new ArrayList<>();
			for(Row row : sheet) {
				if(row.getRowNum()==0)
					continue;
				Transaction transaction = getTransactionDetail(row);
				transactions.add(transaction);
			}
		} catch (FileNotFoundException  e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return transactions;
	}


	private Transaction getTransactionDetail(Row row) {
		// TODO Auto-generated method stub
		return new Transaction(row.getCell(0).toString(),
				row.getCell(1).toString(), 
				row.getCell(2).toString(),
				row.getCell(3).toString(),
				row.getCell(4).toString(),
				Double.parseDouble(row.getCell(5).toString()), 
				row.getCell(6).toString(), 
				false);
	}

}
