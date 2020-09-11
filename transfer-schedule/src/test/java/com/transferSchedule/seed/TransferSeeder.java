package com.transferSchedule.seed;

import java.util.Date;

import com.github.javafaker.Faker;
import com.transferSchedule.entity.Transfer;

public class TransferSeeder {

	private Faker fake;
	
	public static Transfer seedTransferSave () {
		
		final var transferDate = new Date();
		final var schedulingDate = new Date();		
		final var transfer = Transfer.builder()
				.id(null)
				.sourceAccount("000000")
				.destinationAccount("000000")
				.transferAmount(100.00)
				.transferRate(30.00)
				.transferDate(transferDate)
				.schedulingDate(schedulingDate).build();
		
		return transfer;

	}
	
}
