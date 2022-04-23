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
	public String getAllTransactions(ModelMap model) {
		List<Transaction> transactions = transactionService.findAllTransactions();
		model.put("transactions", transactions);
		return "transactions";
	}
	@GetMapping("/transactions/{transactionId}")
	public String getTransactionById(@PathVariable Long transactionId, ModelMap model) {
		Transaction transaction = transactionService.findById(transactionId);
		model.put("transaction", transaction);
		return "transaction";
	}
}
