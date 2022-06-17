package com.codercampus.Assignment11.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.codercampus.Assignment11.domain.Transaction;

@Repository
public class TransactionRepository {
	private List<Transaction> transactions = new ArrayList<>(100);
	
	public TransactionRepository () {
		super();
		populateData();
	}
	//Project has issue overwriting .txt file. (FIXED)
	public List<Transaction> findAll () {
		return transactions;
	}
	
	//Add a for loop for the transactions.txt file when empty to see if its iterating through the list properly.
	@SuppressWarnings("unchecked")
	private void populateData() {
		try {
			File file = new File("transactions.txt");
			if (file.isFile() && file.length() != 0) {
				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
				this.transactions = (List<Transaction>) objectInputStream.readObject();
				objectInputStream.close();
			}
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
