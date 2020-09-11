package com.transferSchedule.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.transferSchedule.entity.Transfer;
import com.transferSchedule.seed.TransferSeeder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TransferRepositoryTest {

	@Autowired
	TransferRepository transferRepository;
	
	@Before
	public void setUp() {
		
		final var transfer = TransferSeeder.seedTransferSave();
		transferRepository.save(transfer);
	}
	
	@After
	public void tearDown() {
		
		transferRepository.deleteAll();
	}
	
	@Test
	public void testSave() {
		
		final var transfer = TransferSeeder.seedTransferSave();
		Transfer response = transferRepository.save(transfer);
		
		assertNotNull(response);
	}
	
	@Test
	public void testFindAll() {
		
		List<Transfer> response = transferRepository.findAll();		
		assertNotNull(response);
	}
}
