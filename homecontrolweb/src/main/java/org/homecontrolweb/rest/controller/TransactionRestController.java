package org.homecontrolweb.rest.controller;


import java.util.List;

import org.homecontrolweb.model.Transaction;
import org.homecontrolweb.model.TransactionsWrapper;
import org.homecontrolweb.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransactionRestController {
	
	private final Logger logger = LoggerFactory.getLogger(TransactionRestController.class);
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value="transaction", method=RequestMethod.POST)
	public void salveTransaction(@Validated @RequestBody Transaction transaction) throws RestControllerException{
		try {
			
			logger.debug("transaction received: " + transaction);
			this.transactionService.salve(transaction);			
			logger.debug("transaction saved successfully.");
			
		}catch (Exception e) {
			
			logger.error(e.getMessage(), e.getCause());
			throw new RestControllerException(e.getMessage());
		}
	}
	
	@RequestMapping(value="transactions", method=RequestMethod.POST)
	public void salveTransactions(@Validated @RequestBody TransactionsWrapper transactionsWrapper) throws RestControllerException{
		try {
			
			logger.debug("transactions count received: " + transactionsWrapper.getTransactions().size());
			this.transactionService.salveAll(transactionsWrapper.getTransactions());
			logger.debug("transactions saved successfully.");
			
		}catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			throw new RestControllerException(e.getMessage());
		}
	}
	
	@RequestMapping(value="transactions", method=RequestMethod.GET)
	public TransactionsWrapper getAllTransactions() throws RestControllerException{
		try {
			List<Transaction> transactions = this.transactionService.getAll();
			TransactionsWrapper wrapper = new TransactionsWrapper();
			wrapper.setTransactions(transactions);
			
			return wrapper;
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RestControllerException(e.getMessage());
		}
	}

	@RequestMapping(value="transactions/modified/after/{date}", method=RequestMethod.GET)
	public TransactionsWrapper getAllTransactionsModifiedAfter(@PathVariable("date") String date) throws RestControllerException{
		try {
			
			logger.info("date received: " + date);
			List<Transaction> transactions = this.transactionService.getAllTransactionsModifiedAfter(date);
			TransactionsWrapper wrapper = new TransactionsWrapper();
			wrapper.setTransactions(transactions);
			
			return wrapper;
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RestControllerException(e.getMessage());
		}
	}
	
	
	@RequestMapping(value="transactions/actived", method=RequestMethod.GET)
	public TransactionsWrapper getAllActivedTransactions() throws RestControllerException{
		try {
			
			List<Transaction> transactions = this.transactionService.getAllActivedTransactions();
			TransactionsWrapper wrapper = new TransactionsWrapper();
			wrapper.setTransactions(transactions);
			
			return wrapper;
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RestControllerException(e.getMessage());
		}
	}
}
