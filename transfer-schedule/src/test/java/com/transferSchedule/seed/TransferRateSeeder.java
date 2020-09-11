package com.transferSchedule.seed;

import com.github.javafaker.Faker;
import com.transferSchedule.entity.TransferRate;

public class TransferRateSeeder {
	
	private Faker fake;
	
	public static TransferRate seedTransferRateSave () {
		
		final var transferRate = TransferRate.builder()
				.id(null)
				.rateMinDay(0)
				.rateMaxDay(0)
				.ratePercentage(3)
				.rateValue(3.0)
				.rateMultiplier(null)
				.transferValueGreater(null).build();
		
		
		return transferRate;
	}
}
