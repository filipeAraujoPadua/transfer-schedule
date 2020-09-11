package com.transferSchedule.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;

import com.transferSchedule.entity.TransferRate;
import com.transferSchedule.repository.TransferRateRepository;
import com.transferSchedule.service.TransferRateService;

@Service
public class TransferRateServiceImpl implements TransferRateService {

	@Autowired
	TransferRateRepository transferRatetepository;

	@Override
	public Optional<TransferRate> findByRateRangeOfDays(Integer rateRangeOfDays) {

		var listTransferRate = this.findAll();
		var transferRateRespnse = new TransferRate();
				
		for (TransferRate obj : listTransferRate) {
			if(obj.getRateMinDay() > obj.getRateMaxDay()) {
				transferRateRespnse = TransferRate.builder()
						.id(obj.getId())
						.rateMinDay(obj.getRateMinDay())
						.rateMaxDay(obj.getRateMaxDay())
						.ratePercentage(obj.getRatePercentage())
						.rateValue(obj.getRateValue())
						.rateMultiplier(obj.getRateMultiplier())
						.transferValueGreater(obj.getTransferValueGreater()).build();
				break;
			}
						
			if(rateRangeOfDays >= obj.getRateMinDay() 
					&& rateRangeOfDays <= obj.getRateMaxDay()) {
				transferRateRespnse = TransferRate.builder()
						.id(obj.getId())
						.rateMinDay(obj.getRateMinDay())
						.rateMaxDay(obj.getRateMaxDay())
						.ratePercentage(obj.getRatePercentage())
						.rateValue(obj.getRateValue())
						.rateMultiplier(obj.getRateMultiplier())
						.transferValueGreater(obj.getTransferValueGreater()).build();
				break;
			}
		};
		
		Optional<TransferRate> response = Optional.of(transferRateRespnse);
		
		return response;
	}
	
	@Override
	public List<TransferRate> findAll() {

		return transferRatetepository.findAll();
	}
	
	public Double findRate(Date transferDate, Date schedulingDate, Double transferAmount) {

		Double response = null;

		Integer rangeOfDays = findRangeOfDays(transferDate, schedulingDate);

		Optional<TransferRate> transferRate = findByRateRangeOfDays(rangeOfDays);

		if (transferRate.isPresent()) {
			response = this.validateTransferValues(transferAmount, transferRate.get(), rangeOfDays);
		}

		return response;
	}

	private Double validateTransferValues(@NonNull final Double transferAmount, @NonNull TransferRate transferRate, Integer rangeOfDays) {
		Double response = 0.0;
		Double onePercentageValue = transferAmount / 100;

		if (!this.validateNullEmptyValues(transferRate.getRatePercentage())
				&& this.validateNullEmptyValues(transferRate.getTransferValueGreater())) {
			response = response + (transferRate.getRatePercentage() * onePercentageValue);
		}

		if(!transferRate.getTransferValueGreater().isNaN() || (!this.validateNullEmptyValues(transferRate.getTransferValueGreater()))) {
			if(transferAmount > transferRate.getTransferValueGreater()) {
				response = response + (transferRate.getRatePercentage() * onePercentageValue);
			}
		}

		if (!this.validateNullEmptyValues(transferRate.getRateValue())) {
			response = response + transferRate.getRateValue();
		}

		if (!this.validateNullEmptyValues(transferRate.getRateMultiplier())) {
			response = response + (transferRate.getRateMultiplier() * rangeOfDays);
		}

		return response;
	}	

	public Integer findRangeOfDays(Date transferDate, Date schedulingDate) {

		DateTime dtTransferDate = new DateTime(transferDate);
		DateTime dtSchedulingDate = new DateTime(schedulingDate);

		Interval intervalo = new Interval(dtTransferDate, dtSchedulingDate);
		Period period = intervalo.toPeriod();

		return period.getDays();

	}
	
	private Boolean validateNullEmptyValues(@NonNull Double value) {
		return Objects.isNull(value) && !value.equals(0.0);
	}
	
	private Boolean validateNullEmptyValues(@NonNull Integer value) {
		return Objects.isNull(value) && !value.equals(0);
	}
}
