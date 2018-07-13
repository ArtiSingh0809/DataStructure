package com.test.service;

import java.util.List;

import com.test.model.Transaction;
import com.test.model.TransactionReport;

public interface ChargeCalculationService {
	
	List<Transaction> findIntraDay(List<Transaction> transactions);
	List<TransactionReport> calculateCharge(List<Transaction> transactions);

}
