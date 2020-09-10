package com.transferSchedule.controller;

import java.util.List;

import javax.persistence.Column;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transferSchedule.service.TransferRateService;
import com.transferSchedule.service.TransferService;
import com.transferSchedule.dto.TransferDTO;
import com.transferSchedule.entity.Transfer;
import com.transferSchedule.response.Response;

@RestController
@RequestMapping("transfer")
public class TransferController {

	@Autowired
	private TransferService transferService;
	
	@Autowired
	private TransferRateService transferRateService;
	
	@PostMapping
	public ResponseEntity<Response<TransferDTO>> create (){
		return null;
	}
	
	@GetMapping
	public ResponseEntity<Response<List<TransferDTO>>> findAll (){
		
		Response<List<TransferDTO>> response = new Response<List<TransferDTO>>();
		
		List<Transfer> listTransfer = transferService.findAll();
		
		if(listTransfer.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		List<TransferDTO> transferDto = new ArrayList<>();
		listTransfer.forEach(i -> transferDto.add(convertEntityToDto(i)));		
		response.setData(transferDto);
		
		return ResponseEntity.ok().body(response);
	}
	
	private Transfer convertDtoToEntity(TransferDTO transferDto) {
		
		Transfer transfer = new Transfer();
		
		transfer.setId(transferDto.getId());
		transfer.setSourceAccount(transferDto.getSourceAccount());
		transfer.setDestinationAccount(transferDto.getDestinationAccount());
		transfer.setTransferAmount(transferDto.getTransferAmount());
		transfer.setTransferRate(transferDto.getTransferRate());
		transfer.setTransferDate(transferDto.getTransferDate());
		transfer.setSchedulingDate(transferDto.getSchedulingDate());
		
		return transfer;
	}
	
	private TransferDTO convertEntityToDto(Transfer transfer) {
		
		TransferDTO transferDto = new TransferDTO();
		
		transferDto.setId(transfer.getId());
		transferDto.setSourceAccount(transfer.getSourceAccount());
		transferDto.setDestinationAccount(transfer.getDestinationAccount());
		transferDto.setTransferAmount(transfer.getTransferAmount());
		transferDto.setTransferRate(transfer.getTransferRate());
		transferDto.setTransferDate(transfer.getTransferDate());
		transferDto.setSchedulingDate(transfer.getSchedulingDate());
		
		return transferDto;
	}
}
