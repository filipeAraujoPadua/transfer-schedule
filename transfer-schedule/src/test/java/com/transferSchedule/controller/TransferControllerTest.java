package com.transferSchedule.controller;

import java.util.Date;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transferSchedule.entity.Transfer;
import com.transferSchedule.entity.TransferRate;
import com.transferSchedule.model.request.TransferRequestDto;
import com.transferSchedule.service.TransferRateService;
import com.transferSchedule.service.TransferService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TransferControllerTest {

	private static final Long ID = 1L;
	private static final String URL = "/transfer";
	private static final  String sourceAccount = "000000";
	private static final  String destinationAccount = "000000";
	private static final  Double transferAmount = 10.00;
	private static final  Double transferRate = 0.0;
	private static final  Date transferDate = new Date();
	private static final  Date schedulingDate = new Date();
	
	@MockBean
	TransferService transferService;
	
	@MockBean
	TransferRateService transferRateService;
	
	@Autowired
	MockMvc mvc;
	
	@Before
	public void setUp() {
		
		BDDMockito.given(transferRateService.findByRateRangeOfDays(Mockito.anyInt())).willReturn(Optional.of(new TransferRate()));		
	}	

	@Test
	public void testSave() throws Exception {
		
		BDDMockito.given(transferService.save(Mockito.any(Transfer.class))).willReturn(getMockTransfer());
		
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(ID,
				sourceAccount,
				destinationAccount,
				transferAmount,
				transferRate,
				transferDate,
				schedulingDate))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.data.id").value(ID))
		.andExpect(jsonPath("$.data.id").value(sourceAccount))
		.andExpect(jsonPath("$.data.id").value(destinationAccount))
		.andExpect(jsonPath("$.data.id").value(transferAmount))
		.andExpect(jsonPath("$.data.id").value(transferRate))
		.andExpect(jsonPath("$.data.id").value(transferDate))
		.andExpect(jsonPath("$.data.id").value(schedulingDate));	
		
			
		
	}
	
	@Test
	public void testSaveInvalidSourceAccount() throws JsonProcessingException, Exception {
		
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(ID,
				"0000000000",
				destinationAccount,
				transferAmount,
				transferRate,
				transferDate,
				schedulingDate))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.errors[0]").value("The source account must be informed"));
		
	}
	
	public Transfer getMockTransfer() {
		Transfer transfer = new Transfer();
		
		transfer.setId(ID);
		transfer.setSourceAccount(sourceAccount);
		transfer.setDestinationAccount(destinationAccount);
		transfer.setTransferAmount(transferAmount);
		transfer.setTransferRate(transferRate);
		transfer.setTransferDate(transferDate);
		transfer.setSchedulingDate(schedulingDate);
		
		return transfer;
	}
	
	public String getJsonPayload(Long jsonId, String jsonSourceAccount, String jsonDestinationAccount,
								 Double jsonTransferAmount, Double jsonTransferRate, Date jsonTransferDate,
								 Date jsonSchedulingDate) throws JsonProcessingException {
		
		TransferRequestDto transferDto = new TransferRequestDto();
		
		transferDto.setId(jsonId);
		transferDto.setSourceAccount(jsonSourceAccount);
		transferDto.setDestinationAccount(jsonDestinationAccount);
		transferDto.setTransferAmount(jsonTransferAmount);
		transferDto.setTransferRate(jsonTransferRate);
		transferDto.setTransferDate(jsonTransferDate);
		transferDto.setSchedulingDate(jsonSchedulingDate);
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(transferDto);
	}
}
