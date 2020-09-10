package com.transferSchedule.service;

import java.util.List;

import com.transferSchedule.entity.Transfer;

public interface TransferService {

	Transfer save (Transfer transfer);
	
	List<Transfer> findAll();
}
