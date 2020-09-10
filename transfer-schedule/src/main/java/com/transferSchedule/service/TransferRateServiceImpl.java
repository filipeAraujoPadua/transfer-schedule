package com.transferSchedule.service;

import java.util.Date;
import java.util.Optional;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transferSchedule.entity.TransferRate;
import com.transferSchedule.repository.TransferRateRepository;

@Service
public class TransferRateServiceImpl implements TransferRateService {

	@Autowired
	TransferRateRepository transferRatetepository;

	@Override
	public Optional<TransferRate> findByRateRangeOfDays(Integer rateRangeOfDays) {

		return transferRatetepository.findByRateRangeOfDays(rateRangeOfDays);
	}

	// Metodo que recebe valor e a data de agendamento da TransfeRate
	public Double findRate(Date transferDate, Date schedulingDate, Double transferAmount) {

		Double response = null;

		// chama calculo de intervalo das datas
		Integer rangeOfDays = findRangeOfDays(transferDate, schedulingDate);

		// chama findByRateRangeOfDays
		Optional<TransferRate> transferRate = findByRateRangeOfDays(rangeOfDays);

		if (transferRate.isPresent()) {
			// faz o calculo de 1% do valor total
			Double onePercentageValue = transferAmount / 100;
			
			//valida se existe porcentagem de taxa e se não existe um valor superior
			if (transferRate.get().getRatePercentage() != null 
					&& transferRate.get().getRatePercentage() != 0
					&& (transferRate.get().getTransferValueGreater() == null
							&& transferRate.get().getRatePercentage() == 0)) {
				
				response = response + (transferRate.get().getRatePercentage() * onePercentageValue);
			}

			//calculo de porcentagem quando existe valor superior
			if(transferRate.get().getTransferValueGreater() != null
					&& transferRate.get().getRatePercentage() != 0) {
				if(transferAmount > transferRate.get().getTransferValueGreater()) {
					response = response + (transferRate.get().getRatePercentage() * onePercentageValue);
				}
			}
			
			//valor de taxa
			if (transferRate.get().getRateValue() != null 
					&& transferRate.get().getRateValue() != 0) {
				response = response + transferRate.get().getRateValue();
			}

			//valor a ser multiplicado pelo intervalo de dias
			if (transferRate.get().getRateMultiplier() != null 
					&& transferRate.get().getRateMultiplier() != 0) {
				response = response + (transferRate.get().getRateMultiplier() * rangeOfDays);
			}

		}

		return response;
	}

	// Metodo pegar o intervalo de datas
	public Integer findRangeOfDays(Date transferDate, Date schedulingDate) {

		DateTime dtTransferDate = new DateTime(transferDate);
		DateTime dtSchedulingDate = new DateTime(schedulingDate);

		Interval intervalo = new Interval(dtTransferDate, dtSchedulingDate);
		Period period = intervalo.toPeriod();

		return period.getDays();

	}

}
