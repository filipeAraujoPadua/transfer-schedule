package com.transferSchedule.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.transferSchedule.entity.TransferRate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransferRateRepositoryTest {

	@Autowired
	TransferRateRepository transferRateRepository;
	
	@Before
	public void setUp() {
		var transferRate = TransferRate.builder()
				.id(null)
				.rateMinDay(0)
				.rateMaxDay(0)
				.ratePercentage(3)
				.rateValue(3.0)
				.rateMultiplier(null)
				.transferValueGreater(null).build();
		
		transferRateRepository.save(transferRate);
	}
	
	@After
	public void tearDown() {
	
		transferRateRepository.deleteAll();
	}
	
	@Test
	public void save () {
		var transferRate = TransferRate.builder()
				.id(null)
				.rateMinDay(0)
				.rateMaxDay(0)
				.ratePercentage(3)
				.rateValue(3.0)
				.rateMultiplier(null)
				.transferValueGreater(null).build();
		
		TransferRate response = transferRateRepository.save(transferRate);
		
		assertNotNull(response);
	}
	
}
