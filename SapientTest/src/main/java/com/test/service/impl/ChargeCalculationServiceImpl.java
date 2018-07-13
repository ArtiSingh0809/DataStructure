package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.test.constant.AppConstant;
import com.test.model.Transaction;
import com.test.model.TransactionReport;
import com.test.service.ChargeCalculationService;

public class ChargeCalculationServiceImpl implements ChargeCalculationService{

	@Override
	public List<Transaction> findIntraDay(List<Transaction> transactions) {
		// TODO Auto-generated method stub
		for(Transaction transaction : transactions) {
			 updateIntraDayFlag(transactions,transaction);
		}
		return transactions;
	}

	private void updateIntraDayFlag(List<Transaction> transactions, Transaction transaction) {
		// TODO Auto-generated method stub
		for(Transaction trans : transactions) {
			if (isIntradayTransaction(transaction, trans)) {
				transaction.setIntraDay(true);
				break;
			}
		}
	}

	private boolean isIntradayTransaction(Transaction transactionMain, Transaction transactionCom) {
		// TODO Auto-generated method stub
		if(transactionMain.getClientId().equals(transactionCom.getClientId())
				&& transactionMain.getSecurityId().equals(transactionCom.getSecurityId())
				&& transactionMain.getTransactionDate().equals(transactionCom.getTransactionDate())
				&& !transactionMain.getTransactionType().equals(transactionCom.getTransactionType())
				&& (AppConstant.BUY.equalsIgnoreCase(transactionMain.getTransactionType()) ||
						AppConstant.SELL.equalsIgnoreCase(transactionMain.getTransactionType()))
				&& (AppConstant.BUY.equalsIgnoreCase(transactionCom.getTransactionType()) ||
						AppConstant.SELL.equalsIgnoreCase(transactionCom.getTransactionType()))) {
			return true;
		}
		return false;
	}

	@Override
	public List<TransactionReport> calculateCharge(List<Transaction> transactions) {
		// TODO Auto-generated method stub
		 List<TransactionReport> transactionReports = new ArrayList<>();
		for(Transaction transaction : transactions) {
			String fee = findProcessingFee(transaction);
			transactionReports.add( new TransactionReport(transaction.getClientId(),
					transaction.getTransactionType(), transaction.getTransactionDate(),
					transaction.getPriorityFlag(), fee));
		}
		return transactionReports;
	}

	private String findProcessingFee(Transaction transaction) {
		// TODO Auto-generated method stub
		String fee = null;
		if(transaction.isIntraDay()) {
			fee = "10$";
		}else if("Y".equalsIgnoreCase(transaction.getPriorityFlag())) {
			fee = "500$";
		}else if (AppConstant.BUY.equalsIgnoreCase(transaction.getTransactionType()) ||
				AppConstant.SELL.equalsIgnoreCase(transaction.getTransactionType())) {
			fee = "100$";
		}else if (AppConstant.DEPOSIT.equalsIgnoreCase(transaction.getTransactionType()) ||
				AppConstant.WITHDRAW.equalsIgnoreCase(transaction.getTransactionType())) {
			fee = "50$";
		}else{
			fee = "00$";
		}
		return fee;
	}

}
