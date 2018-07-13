package com.test.main;

import java.util.List;

import com.test.constant.FileType;
import com.test.model.Transaction;
import com.test.model.TransactionReport;
import com.test.service.ChargeCalculationService;
import com.test.service.impl.ChargeCalculationServiceImpl;

public class FeeCalculator {

	public static void main(String[] args) {
		List<Transaction> transactions = FileType.XLSX.readFile();
		ChargeCalculationService service = new ChargeCalculationServiceImpl();
		transactions = service.findIntraDay(transactions);
		List<TransactionReport> transactionReports = service.calculateCharge(transactions);
		FileType.XLSX.writeFile(transactionReports);
	}

}
