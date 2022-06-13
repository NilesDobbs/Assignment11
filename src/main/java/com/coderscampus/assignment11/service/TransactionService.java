package com.coderscampus.assignment11.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment11.domain.Transaction;
import com.coderscampus.assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Transaction> findAll () {
		List<Transaction> trans = transactionRepository.findAll();
		Collections.sort(trans);
		return trans;
	}

	public Transaction findById(Long id) {
		return transactionRepository.findById(id);
		
	}
//	@Autowired
//	private TransactionRepository transactionRepo;
//	
//	public List<Transaction> findAllTransactions() {
//		List<Transaction> transactions = transactionRepo.findAll();
//		return transactions;
//	}
//	
//	//public Transaction findById(Long transactionId) {
//	//return repository.fetchById(transactionId);
////}
//	
//	public Transaction findById(Long transactionId) {
//		Optional<Transaction> transaction = transactionRepo.findAll().stream()
//				.filter(x -> x.getId().equals(transactionId)).findFirst();
//		return transaction.orElse(null);
//	}
}
