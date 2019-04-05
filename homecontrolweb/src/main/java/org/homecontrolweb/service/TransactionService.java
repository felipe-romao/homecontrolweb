package org.homecontrolweb.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.homecontrolweb.model.Transaction;
import org.homecontrolweb.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
	
	private final Logger logger = LoggerFactory.getLogger(TransactionService.class);
	
	@Autowired 
	private TransactionRepository transactionRepository;
	
	public void salve(Transaction transaction) {
		transaction.modified();
		this.transactionRepository.save(transaction);
	}
	
	public void salveAll(List<Transaction> transactions) {
		for (Transaction transaction : transactions) {
			transaction.modified();
		}
		this.transactionRepository.saveAll(transactions);
	}

	public List<Transaction> getAll() {
		return this.transactionRepository.findAll();
	}

	public List<Transaction> getAllTransactionsModifiedAfter(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(format.parse(date));
		return this.transactionRepository.modifieds(calendar);			
	}
	
	public List<Transaction> getAllActivedTransactions(){
		return this.transactionRepository.activedTransactions();
	}
}
