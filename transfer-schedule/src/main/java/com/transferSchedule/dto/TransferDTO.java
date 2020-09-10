package com.transferSchedule.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferDTO {

	private Long id;
	
	@NotNull(message="A conta de origem deve ser informada")
	@Length(min=6, max=6, message="A conta de origem deve ter 6 digitos")
	private String sourceAccount;
	
	@NotNull(message="A conta de destino deve ser informada")
	@Length(min=6, max=6, message="A conta de destino deve ter 6 digitos")
	private String destinationAccount;

	@NotNull(message="O valor deve ser informado")
	private Double transferAmount;

	private Double transferRate;

	@NotNull(message="A data de transferencia deve ser informada")
	private Date transferDate;

	@NotNull(message="A data de agendamento deve ser informada")
	private Date schedulingDate;

	public TransferDTO() {
		
	}

	public TransferDTO(Long id,
			@NotNull(message = "A conta de origem deve ser informada") @Length(min = 6, max=6, message = "A conta de origem deve ter 6 digitos") String sourceAccount,
			@NotNull(message = "A conta de destino deve ser informada") @Length(min = 6, max=6, message = "A conta de destino deve ter 6 digitos") String destinationAccount,
			@NotNull(message = "O valor deve ser informado") Double transferAmount, Double transferRate,
			@NotNull(message = "A data de transferencia deve ser informada") Date transferDate,
			@NotNull(message = "A data de agendamento deve ser informada") Date schedulingDate) {
		super();
		this.id = id;
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.transferAmount = transferAmount;
		this.transferRate = transferRate;
		this.transferDate = transferDate;
		this.schedulingDate = schedulingDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(String sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public String getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(String destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	public Double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public Double getTransferRate() {
		return transferRate;
	}

	public void setTransferRate(Double transferRate) {
		this.transferRate = transferRate;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public Date getSchedulingDate() {
		return schedulingDate;
	}

	public void setSchedulingDate(Date schedulingDate) {
		this.schedulingDate = schedulingDate;
	}
	
	
}
