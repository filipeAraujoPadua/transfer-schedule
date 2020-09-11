package com.transferSchedule.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.transferSchedule.seed.TransferRateSeeder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TransferRateRepositoryTest {

	@Autowired
	TransferRateRepository transferRateRepository;
	
	@Before
	public void setUp() {
		
		var transferRate = TransferRateSeeder.seedTransferRateSave();
		transferRateRepository.save(transferRate);
	}
	
	@After
	public void tearDown() {
	
		transferRateRepository.deleteAll();
	}
	
	@Test
	public void testSave () {
		var transferRate = TransferRateSeeder.seedTransferRateSave();		
		var response = transferRateRepository.save(transferRate);		
		assertNotNull(response);
	}
	
	@Test
	public void testFindAll () {
		var response = transferRateRepository.findAll();		
		assertNotNull(response);
	}
}
