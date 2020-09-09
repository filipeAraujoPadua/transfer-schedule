package com.transferSchedule.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transfer_rate")
public class TransferRate implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "rate_range_of_days")
	private Integer rateRangeOfDays;
	
	@Column(name = "rate_percentage")
	private Integer ratePercentage;
	
	@Column(name = "rate_multiplier_days")
	private Double rateMultiplierDays;
	
	@Column(name = "transfer_value_greater")
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

	public Double getRateMultiplierDays() {
		return rateMultiplierDays;
	}

	public void setRateMultiplierDays(Double rateMultiplierDays) {
		this.rateMultiplierDays = rateMultiplierDays;
	}

	public Double getTransferValueGreater() {
		return transferValueGreater;
	}

	public void setTransferValueGreater(Double transferValueGreater) {
		this.transferValueGreater = transferValueGreater;
	}
}
