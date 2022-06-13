package com.coderscampus.assignment11.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.assignment11.domain.Transaction;

@Repository
public class TransactionRepository {
	private List<Transaction> transactions = new ArrayList<>(100);
	
	public TransactionRepository () {
		super();
		populateData();
	}
	
	public List<Transaction> findAll () {
		return transactions;
	}

	@SuppressWarnings("unchecked")
	private void populateData() {
		try (FileInputStream fileInputStream = new FileInputStream("transactions.txt");
			 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
			this.transactions = (List<Transaction>) objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

	public Transaction findById(Long id) {
		Transaction theOne = null;
		for(Transaction i : findAll()) {
			if(i.getId().equals(id)) {
				theOne = i;
			}
		}
		return theOne;
		
	}
}
//	private List<Transaction> transactions = new ArrayList<>(100);
//
//	public TransactionRepository() {
//		super();
//		populateData();
//
//		Collections.sort(transactions, new Comparator<Transaction>() {
//			public int compare(Transaction t1, Transaction t2) {
//				return t1.getDate().compareTo(t2.getDate());
//			}
//		});
//	}
//	
////	public List<Transaction> findAll () {
////		return transactions;
////	}
////
////	@SuppressWarnings("unchecked")
////	private void populateData() {
////		try (FileInputStream fileInputStream = new FileInputStream("transactions.txt");
////			 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
////			this.transactions = (List<Transaction>) objectInputStream.readObject();
////		} catch (IOException | ClassNotFoundException e) {
////			e.printStackTrace();
////		} 
////	}
//	
//	public List<Transaction> findAll() {
//		return transactions;
//	}
//	private void populateData() {
//		try (FileInputStream fileInputStream = new FileInputStream("transactions.txt");
//				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
//			this.transactions = (List<Transaction>) objectInputStream.readObject();
//		} catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	//public Transaction fetchById(Long transactionId) {
//	//return transactions.get((int) (transactionId -1));
//}
