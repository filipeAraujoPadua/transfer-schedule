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
		TransferRate transferRate = new TransferRate();
		
		transferRate.setRateMultiplier(null);
		transferRate.setRatePercentage(3);
		transferRate.setRateRangeOfDays(0);
		transferRate.setRateValue(3.00);
		transferRate.setTransferValueGreater(null);
		
		transferRateRepository.save(transferRate);
	}
	
	@After
	public void tearDown() {
	
		transferRateRepository.deleteAll();
	}
	
	@Test
	public void save () {
		TransferRate transferRate = new TransferRate();
		
		transferRate.setRateMultiplier(null);
		transferRate.setRatePercentage(3);
		transferRate.setRateRangeOfDays(0);
		transferRate.setRateValue(3.00);
		transferRate.setTransferValueGreater(null);
		
		TransferRate response = transferRateRepository.save(transferRate);
		
		assertNotNull(response);
	}
	
	@Test
	public void findBy() {
		Optional<TransferRate> response = transferRateRepository.findByRateRangeOfDays(10);
		
		assertNotNull(response);
	}
}
