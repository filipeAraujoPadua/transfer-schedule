package com.transferSchedule.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.transferSchedule.entity.Transfer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrasnferRepositoryTest {

	@Autowired
	TrasnferRepository trasnferRepository;
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testSave() {
		
		Transfer transfer = new Transfer();
		Date transferDate = new Date();
		Date schedulingDate = new Date();
		
		
		transfer.setSourceAccount("xxxxxxxx");
		transfer.setDestinationAccount("XXXXXXXXX");
		transfer.setTransferAmount(100.00);
		
		//Refactor to make calculations based on dates
		transfer.setTransferRate(30.00);
		transfer.setTransferDate(transferDate);
		transfer.setSchedulingDate(schedulingDate);
		
		Transfer response = trasnferRepository.save(transfer);
		
		assertNotNull(response);
	}
}
