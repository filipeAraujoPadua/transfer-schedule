package com.transferSchedule.controller;

import java.util.List;

import javax.persistence.Column;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Date;

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
import com.transferSchedule.entity.Transfer;
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

		TransferResponse<TransferRequestDto> response = new TransferResponse<TransferRequestDto>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Double rateTransfer = transferRateService.findRate(transferDto.getTransferDate(),
				transferDto.getSchedulingDate(), transferDto.getTransferAmount());

		if (rateTransfer == null || rateTransfer == 0) {
			response.getErrors().add("Não existe nenhuma taxa aplicavel para a transferencia");

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Transfer transfer = transferService.save(convertDtoToEntity(transferDto));

		response.setData(convertEntityToDto(transfer));

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<TransferResponse<List<TransferRequestDto>>> findAll() {

		TransferResponse<List<TransferRequestDto>> response = new TransferResponse<List<TransferRequestDto>>();

		List<Transfer> listTransfer = transferService.findAll();

		if (listTransfer.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		List<TransferRequestDto> transferDto = new ArrayList<>();
		listTransfer.forEach(i -> transferDto.add(convertEntityToDto(i)));
		response.setData(transferDto);

		return ResponseEntity.ok().body(response);
	}

	private Transfer convertDtoToEntity(TransferRequestDto transferDto) {

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

	private TransferRequestDto convertEntityToDto(Transfer transfer) {

		TransferRequestDto transferDto = new TransferRequestDto();

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
