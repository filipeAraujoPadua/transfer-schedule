package com.transferSchedule.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.transferSchedule.entity.TransferRate;
import com.transferSchedule.repository.TransferRateRepository;

public class TransferRateServiceImpl implements TransferRateService{

	@Autowired
	TransferRateRepository transferRatetepository; 
	
	@Override
	public Optional<TransferRate> findByRateRangeOfDays(Integer rateRangeOfDays){
		
		return transferRatetepository.findByRateRangeOfDays(rateRangeOfDays);
	}
	
}
