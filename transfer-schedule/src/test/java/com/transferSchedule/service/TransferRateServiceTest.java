package com.transferSchedule.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.transferSchedule.repository.TransferRateRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TransferRateServiceTest {

	@MockBean
	TransferRateRepository transferRateRepository;  
	
	@Autowired
	TransferRateService transferRateService;
	
	@Before
	public void setUp() {
				
	}	
	
	@Test
	public void testFindByRateRangeOfDays() {
		var response = transferRateService.findByRateRangeOfDays(new Integer(0) );
		assertNotNull(response);
	}
	
	@Test
	public void testFindRate() {
		var equalsDate = new Date();
		Double valor = 0.0;
		
		Double response = transferRateService.findRate(equalsDate, equalsDate, valor);
		assertNotNull(response);
	}
}
