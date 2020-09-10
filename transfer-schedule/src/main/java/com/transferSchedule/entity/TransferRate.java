package com.transferSchedule.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSFER_RATE")
public class TransferRate implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "RATE_RANG_OF_DAYS")
	private Integer rateRangeOfDays;
	
	@Column(name = "RATE_PERCENTAGE")
	private Integer ratePercentage;
	
	@Column(name = "RATE_VALUE")
	private Double rateValue;
	
	@Column(name = "RATE_MULTIPLIER")
	private Double rateMultiplier;
	
	@Column(name = "TRANSFER_VALUE_GREATER")
	private Double transferValueGreater;
	
	public TransferRate() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRateRangeOfDays() {
		return rateRangeOfDays;
	}

	public void setRateRangeOfDays(Integer rateRangeOfDays) {
		this.rateRangeOfDays = rateRangeOfDays;
	}

	public Integer getRatePercentage() {
		return ratePercentage;
	}

	public void setRatePercentage(Integer ratePercentage) {
		this.ratePercentage = ratePercentage;
	}

	public Double getRateValue() {
		return rateValue;
	}

	public void setRateValue(Double rateValue) {
		this.rateValue = rateValue;
	}

	public Double getRateMultiplier() {
		return rateMultiplier;
	}

	public void setRateMultiplier(Double rateMultiplier) {
		this.rateMultiplier = rateMultiplier;
	}

	public Double getTransferValueGreater() {
		return transferValueGreater;
	}

	public void setTransferValueGreater(Double transferValueGreater) {
		this.transferValueGreater = transferValueGreater;
	}

}
