package com.transferSchedule.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

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
	
	@Test
	public void testSave() {
		
		Transfer transfer = new Transfer();
		Date transferDate = new Date();
		Date schedulingDate = new Date();
		
		
		transfer.setSource_account("xxxxxxxx");
		transfer.setDestination_account("XXXXXXXXX");
		transfer.setTransfer_amount(100.00);
		
		//Refactor to make calculations based on dates
		transfer.setTransfer_rate(30.00);
		transfer.setTransfer_date(transferDate);
		transfer.setScheduling_date(schedulingDate);
		
		Transfer response = trasnferRepository.save(transfer);
		
		assertNotNull(response);
	}
}
