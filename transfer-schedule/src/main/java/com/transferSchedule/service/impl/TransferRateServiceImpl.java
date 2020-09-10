package com.transferSchedule.service.impl;

import java.util.Date;
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

		return transferRatetepository.findByRateRangeOfDays(rateRangeOfDays);
	}
	
	public Double findRate(Date transferDate, Date schedulingDate, Double transferAmount) {

		Double response = null;

		Integer rangeOfDays = findRangeOfDays(transferDate, schedulingDate);

		Optional<TransferRate> transferRate = findByRateRangeOfDays(rangeOfDays);

		if (transferRate.isPresent()) {
			this.validateTransferValues(transferAmount, transferRate.get(), rangeOfDays);
		}

		return response;
	}

	private Double validateTransferValues(@NonNull final Double transferAmount, @NonNull TransferRate transferRate, Integer rangeOfDays) {
		Double response = null;
		Double onePercentageValue = transferAmount / 100;

		if (this.validateNullEmptyValues(transferRate.getRatePercentage())
				&& this.validateNullEmptyValues(transferRate.getTransferValueGreater())) {
			response = response + (transferRate.getRatePercentage() * onePercentageValue);
		}

		if(transferRate.getTransferValueGreater() != null
				&& transferRate.getRatePercentage() != 0) {
			if(transferAmount > transferRate.getTransferValueGreater()) {
				response = response + (transferRate.getRatePercentage() * onePercentageValue);
			}
		}

		if (transferRate.getRateValue() != null
				&& transferRate.getRateValue() != 0) {
			response = response + transferRate.getRateValue();
		}

		if (transferRate.getRateMultiplier() != null
				&& transferRate.getRateMultiplier() != 0) {
			response = response + (transferRate.getRateMultiplier() * rangeOfDays);
		}

		return response;
	}
	
	private Boolean validateNullEmptyValues(@NonNull Double value) {
		return Objects.isNull(value) && !value.equals(0);
	}
	
	private Boolean validateNullEmptyValues(@NonNull Integer value) {
		return Objects.isNull(value) && !value.equals(0);
	}

	public Integer findRangeOfDays(Date transferDate, Date schedulingDate) {

		DateTime dtTransferDate = new DateTime(transferDate);
		DateTime dtSchedulingDate = new DateTime(schedulingDate);

		Interval intervalo = new Interval(dtTransferDate, dtSchedulingDate);
		Period period = intervalo.toPeriod();

		return period.getDays();

	}
}