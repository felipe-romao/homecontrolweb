package org.homecontrolweb.repository;

import java.util.Calendar;
import java.util.List;

import org.homecontrolweb.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String>{

	@Query("FROM Transaction t WHERE t.active = 1 AND t.dateModified >= :dateModified")
	List<Transaction> modifieds(@Param("dateModified") Calendar date);
	
	@Query("FROM Transaction t WHERE t.active = 1")
	List<Transaction> activedTransactions();	
}
