/**
 * 
 */
package com.test.constant;

import java.util.List;

import com.test.model.Transaction;
import com.test.model.TransactionReport;
import com.test.reader.ExcelReader;
import com.test.reader.ExcelWriter;



/**
 * @author singha2
 *
 */
public enum FileType {
	
	XLS{

		@Override
		public List<Transaction> readFile() {
			// TODO Auto-generated method stub
			return new ExcelReader().readFile();
		}

		@Override
		public void writeFile(List<TransactionReport> transactionReports) {
			// TODO Auto-generated method stub
			new ExcelWriter().writeFile(transactionReports);
		}

		
		
	},XLSX{

		@Override
		public List<Transaction> readFile() {
			// TODO Auto-generated method stub
			return new ExcelReader().readFile();
		}

		@Override
		public void writeFile(List<TransactionReport> transactionReports) {
			// TODO Auto-generated method stub
			new ExcelWriter().writeFile(transactionReports);
		}


		
		
	};

	
	public abstract List<Transaction> readFile(); 
	public abstract void writeFile(List<TransactionReport> transactionReports); 

}
