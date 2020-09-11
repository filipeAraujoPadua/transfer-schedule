package com.transferSchedule.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

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

import com.transferSchedule.entity.Transfer;
import com.transferSchedule.repository.TransferRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TransferServiceTest {

	@MockBean
	TransferRepository transferRepository;
	
	@Autowired
	TransferService transferService;
	
	@Before
	public void setUp() {
		
		BDDMockito.given(transferRepository.findAll()).willReturn(List.of(new Transfer()));		
	}
	
	@Test
	public void testFindAll() {
		
		List<Transfer> response = transferRepository.findAll();		
		assertNotNull(response);
	}
	
	@Test
	public void testSave () {
		
		BDDMockito.given(transferRepository.save(Mockito.mock(Transfer.class))).willReturn(new Transfer());		
		Transfer response = transferService.save(new Transfer());
		
		assertNotNull(response);
	}
	
}
