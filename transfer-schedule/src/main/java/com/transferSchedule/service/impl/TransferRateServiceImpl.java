package com.transferSchedule.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.joda.time.DateTime;
import org.joda.time.Interval;
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
	public Optional<TransferRate> findByRateRangeOfDays(@NonNull final Integer rateRangeOfDays) {

		final var listTransferRate = this.findAll();
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
				
		return Optional.of(transferRateRespnse);
	}
	
	@Override
	public List<TransferRate> findAll() {

		return transferRatetepository.findAll();
	}
	
	public Double findRate(@NonNull final Date transferDate, @NonNull final Date schedulingDate, @NonNull final Double transferAmount) {

		Double response = null;

		final var rangeOfDays = findRangeOfDays(transferDate, schedulingDate);

		var transferRate = findByRateRangeOfDays(rangeOfDays);

		if (transferRate.isPresent()) {
			response = this.validateTransferValues(transferAmount, transferRate.get(), rangeOfDays);
		}

		return response;
	}

	private Double validateTransferValues(@NonNull final Double transferAmount, @NonNull final TransferRate transferRate, @NonNull final Integer rangeOfDays) {
		Double response = 0.0;
		Double onePercentageValue = transferAmount / 100;

		if (this.validateNullEmptyValues(transferRate.getRatePercentage())
				&& !this.validateNullEmptyValues(transferRate.getTransferValueGreater())) {
			response = response + (transferRate.getRatePercentage() * onePercentageValue);
		}

		if(this.validateNullEmptyValues(transferRate.getTransferValueGreater())) {
			if(transferAmount > transferRate.getTransferValueGreater()) {
				response = response + (transferRate.getRatePercentage() * onePercentageValue);
			}
		}

		if (this.validateNullEmptyValues(transferRate.getRateValue())) {
			response = response + transferRate.getRateValue();
		}

		if (this.validateNullEmptyValues(transferRate.getRateMultiplier())) {
			response = response + (transferRate.getRateMultiplier() * rangeOfDays);
		}

		return response;
	}	

	public Integer findRangeOfDays(@NonNull final Date transferDate, @NonNull final  Date schedulingDate) {

		final var dtTransferDate = new DateTime(transferDate);
		final var dtSchedulingDate = new DateTime(schedulingDate);

		final var  intervalo = new Interval(dtTransferDate, dtSchedulingDate);
		final var  period = intervalo.toPeriod();

		return period.getDays();

	}
	
	private Boolean validateNullEmptyValues(@NonNull Double value) {
		return !Objects.isNull(value) && !value.equals(0.0);
	}
	
	private Boolean validateNullEmptyValues(@NonNull Integer value) {
		return !Objects.isNull(value) && !value.equals(0);
	}
		
}
