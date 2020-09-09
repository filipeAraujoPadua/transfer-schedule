package com.transferSchedule.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transfer")
public class Transfer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "source_account")
	private String sourceAccount;
	
	@Column(name = "destination_account")
	private String destinationAccount;
	
	@Column(name = "transfer_amount")
	private Double transferAmount;
	
	@Column(name = "transfer_rate")
	private Double transferRate;
	
	@Column(name = "trasfer_date")
	private Date transferDate;
	
	@Column(name = "scheduling_date")
	private Date schedulingDate;
	
	public Transfer() {

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
