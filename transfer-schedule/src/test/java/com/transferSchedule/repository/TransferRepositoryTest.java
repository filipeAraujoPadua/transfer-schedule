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

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TransferRepositoryTest {

	@Autowired
	TransferRepository transferRepository;
	
	@Before
	public void setUp() {
		
		Transfer transfer = new Transfer();
		Date transferDate = new Date();
		Date schedulingDate = new Date();		
		
		transfer.setSourceAccount("000000");
		transfer.setDestinationAccount("000000");
		transfer.setTransferAmount(100.00);
		transfer.setTransferRate(30.00);
		transfer.setTransferDate(transferDate);
		transfer.setSchedulingDate(schedulingDate);

		transferRepository.save(transfer);
	}
	
	@After
	public void tearDown() {
		
		transferRepository.deleteAll();
	}
	
	@Test
	public void testSave() {
		
		Transfer transfer = new Transfer();
		Date transferDate = new Date();
		Date schedulingDate = new Date();
				
		transfer.setSourceAccount("111111");
		transfer.setDestinationAccount("111111");
		transfer.setTransferAmount(100.00);
		transfer.setTransferRate(30.00);
		transfer.setTransferDate(transferDate);
		transfer.setSchedulingDate(schedulingDate);
		
		Transfer response = transferRepository.save(transfer);
		
		assertNotNull(response);
	}
	
	@Test
	public void testFindAll() {
		
		List<Transfer> response = transferRepository.findAll();
		
		assertNotNull(response);
	}
}
