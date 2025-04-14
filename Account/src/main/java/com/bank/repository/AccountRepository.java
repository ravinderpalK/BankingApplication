package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	@Query("SELECT a FROM Account a WHERE TYPE(a) = :type")
	List<Account> findByAccountType(@Param("type") Class<? extends Account> type);
}
