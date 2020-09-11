package com.transferSchedule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transferSchedule.entity.TransferRate;

public interface TransferRateRepository extends JpaRepository<TransferRate, Long>{
		
}
