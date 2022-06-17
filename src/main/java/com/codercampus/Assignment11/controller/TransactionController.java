package com.codercampus.Assignment11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions")
	public String getTransactionInfo(ModelMap model) {
		List<Transaction> everyTransaction = transactionService.findAll();
		model.put("transactions", everyTransaction);
		return "transactions";
	}
	@GetMapping("/transactions/{id}")
	public String getTransactionIndividual(@PathVariable Long id, ModelMap model) {
		Transaction trans = transactionService.findById(id);
		model.put("transaction", trans); // Transactions == transaction.
		return "transaction";// Transform into transaction with no plurality. Disrupts ability find individual page.
	}
}
