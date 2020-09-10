package com.transferSchedule.service;

import java.util.Date;
import java.util.Optional;

import com.transferSchedule.entity.TransferRate;

public interface TransferRateService {

	Optional<TransferRate> findByRateRangeOfDays(Integer rateRangeOfDays);
	
	Double findRate(Date transferDate, Date schedulingDate, Double transferAmount);
}
