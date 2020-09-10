package com.transferSchedule.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.transferSchedule.entity.TransferRate;
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
		
		BDDMockito.given(transferRateRepository.findByRateRangeOfDays(Mockito.anyInt())).willReturn(Optional.of(new TransferRate()));		
	}	
	
	@Test
	public void testFindByRateRangeOfDays() {
		Optional<TransferRate> response = transferRateService.findByRateRangeOfDays(new Integer(0) );
		assertNotNull(response);
	}
	
	@Test
	public void testFindRate() {
		Double response = transferRateService.findRate(new Date(), new Date(), new Double(0));
		assertNotNull(response);
	}
}
