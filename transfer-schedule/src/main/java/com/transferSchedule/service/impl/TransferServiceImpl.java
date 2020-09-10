package com.transferSchedule.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.transferSchedule.entity.Transfer;
import com.transferSchedule.repository.TransferRepository;
import com.transferSchedule.service.TransferRateService;
import com.transferSchedule.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	TransferRepository transferRepository;
	
	@Autowired
	TransferRateService transferRateService;
	
	@Override
	public Transfer save (Transfer transfer){
		return transferRepository.save(transfer);
	}
	
	@Override
	public List<Transfer> findAll(){
		return transferRepository.findAll();
	}
	
}
