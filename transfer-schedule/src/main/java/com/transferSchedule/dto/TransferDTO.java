package com.transferSchedule.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferDTO {

	private Long id;
	
	@NotNull(message="A conta de origem deve ser informada")
	@Length(min=6, message="A conta de origem deve ter 6 digitos")
	private String sourceAccount;
	
	@NotNull(message="A conta de destino deve ser informada")
	@Length(min=6, message="A conta de destino deve ter 6 digitos")
	private String destinationAccount;

	@NotNull(message="O valor deve ser informado")
	private Double transferAmount;

	private Double transferRate;

	@NotNull(message="A data de transferencia deve ser informada")
	private Date transferDate;

	@NotNull(message="A data de agendamento deve ser informada")
	private Date schedulingDate;

}