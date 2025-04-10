package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.FundTransfer;

public interface FundTransferRepository extends JpaRepository<FundTransfer, Long> {

}
