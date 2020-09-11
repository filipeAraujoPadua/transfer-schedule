package com.transferSchedule.mapper;

import org.springframework.lang.NonNull;

import com.transferSchedule.entity.Transfer;
import com.transferSchedule.model.request.TransferRequestDto;

import lombok.NoArgsConstructor;

public class TransferMapper {

	public static Transfer convertDtoToEntity(@NonNull final TransferRequestDto transferDto) {

		final var transfer = Transfer.builder().id(transferDto.getId()).sourceAccount(transferDto.getSourceAccount())
				.destinationAccount(transferDto.getDestinationAccount()).transferAmount(transferDto.getTransferAmount())
				.transferRate(transferDto.getTransferRate()).transferDate(transferDto.getTransferDate())
				.schedulingDate(transferDto.getSchedulingDate()).build();

		return transfer;
	}

	public static TransferRequestDto convertEntityToDto(@NonNull final Transfer transfer) {

		final var transferDto = TransferRequestDto.builder().id(transfer.getId()).sourceAccount(transfer.getSourceAccount())
				.destinationAccount(transfer.getDestinationAccount()).transferAmount(transfer.getTransferAmount())
				.transferRate(transfer.getTransferRate()).transferDate(transfer.getTransferDate())
				.schedulingDate(transfer.getSchedulingDate()).build();

		return transferDto;
	}
}
