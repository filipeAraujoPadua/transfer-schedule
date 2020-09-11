package com.transferSchedule.controller;

import java.util.List;

import javax.validation.Valid;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transferSchedule.service.TransferRateService;
import com.transferSchedule.service.TransferService;
import com.transferSchedule.mapper.TransferMapper;
import com.transferSchedule.model.request.TransferRequestDto;
import com.transferSchedule.model.response.TransferResponse;

@RestController
@RequestMapping("transfer")
public class TransferController {

	@Autowired
	private TransferService transferService;

	@Autowired
	private TransferRateService transferRateService;
	
	@PostMapping
	public ResponseEntity<TransferResponse<TransferRequestDto>> create(@Valid @RequestBody TransferRequestDto transferDto,
			BindingResult result) {

		var response = new TransferResponse<TransferRequestDto>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		final Double rateTransfer = transferRateService.findRate(transferDto.getTransferDate(),
				transferDto.getSchedulingDate(), transferDto.getTransferAmount());

		if (rateTransfer == null || rateTransfer == 0) {
			response.getErrors().add("There is no fee for the transfer");

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		transferDto.setTransferRate(rateTransfer);
		
		final var transfer = transferService.save(TransferMapper.convertDtoToEntity(transferDto));

		response.setData(TransferMapper.convertEntityToDto(transfer));

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<TransferResponse<List<TransferRequestDto>>> findAll() {

		var response = new TransferResponse<List<TransferRequestDto>>();

		final var listTransfer = transferService.findAll();

		if (listTransfer.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		List<TransferRequestDto> transferDto = new ArrayList<>();
		listTransfer.forEach(i -> transferDto.add(TransferMapper.convertEntityToDto(i)));
		
		response.setData(transferDto);

		return ResponseEntity.ok().body(response);
	}

	
}
