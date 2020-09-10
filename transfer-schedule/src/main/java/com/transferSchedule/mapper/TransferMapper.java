package com.transferSchedule.mapper;

import com.transferSchedule.entity.Transfer;
import com.transferSchedule.model.request.TransferRequestDto;

public class TransferMapper {

	public Transfer convertDtoToEntity(TransferRequestDto transferDto) {

		var transfer = Transfer.builder().id(transferDto.getId()).sourceAccount(transferDto.getSourceAccount())
				.destinationAccount(transferDto.getDestinationAccount()).transferAmount(transferDto.getTransferAmount())
				.transferRate(transferDto.getTransferRate()).transferDate(transferDto.getTransferDate())
				.schedulingDate(transferDto.getSchedulingDate()).build();

		return transfer;
	}

	public TransferRequestDto convertEntityToDto(Transfer transfer) {

		var transferDto = TransferRequestDto.builder().id(transfer.getId()).sourceAccount(transfer.getSourceAccount())
				.destinationAccount(transfer.getDestinationAccount()).transferAmount(transfer.getTransferAmount())
				.transferRate(transfer.getTransferRate()).transferDate(transfer.getTransferDate())
				.schedulingDate(transfer.getSchedulingDate()).build();

		return transferDto;
	}
}
