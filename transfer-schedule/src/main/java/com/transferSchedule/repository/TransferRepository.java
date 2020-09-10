package com.transferSchedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transferSchedule.entity.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long>{

}
