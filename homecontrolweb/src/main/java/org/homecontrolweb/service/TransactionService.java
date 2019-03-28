package org.homecontrolweb.service;

import org.homecontrolweb.model.Transaction;
import org.homecontrolweb.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
	
	@Autowired 
	private TransactionRepository transactionRepository;
	
	public void salve(Transaction transaction) {
		this.transactionRepository.save(transaction);
	}
}
