package com.coderscampus.assignment11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coderscampus.assignment11.domain.Transaction;
import com.coderscampus.assignment11.service.TransactionService;

@Controller
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions")
	public String getTransactionInfo(ModelMap model) {
		List<Transaction> allTransactions = transactionService.findAll();
		
		model.put("transactions", allTransactions);
		return "transactions";
	}
	@GetMapping("/transactions/{id}")
	public String getTransactionIndividual(@PathVariable Long id, ModelMap model) {
		Transaction trans = transactionService.findById(id);
		model.put("transactions", trans);
		return "transactioninfo";
		
	}
}
