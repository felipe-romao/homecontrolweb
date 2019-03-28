package org.homecontrolweb.rest.controller;


import org.homecontrolweb.model.Transaction;
import org.homecontrolweb.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionRestController {
	
	@Autowired
	private TransactionService transactionService;
	
	
	@PostMapping
	public @ResponseBody String create(@RequestBody Transaction transaction, 
			@RequestHeader(value="datetime", required=false) String datetime){
		
		System.out.println("nova transação id: " + transaction.getId());
		this.transactionService.salve(transaction);
		
		System.out.println("nova transação salva.");
		return "OK";
	}
}
