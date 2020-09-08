package com.transferSchedule.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransferRate implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer rate_range_of_days;
	
	private Integer rate_percentage;
	
	private Double rate_multiplier_days;
	
	private Double transfer_value_greater;
	
	public TransferRate() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRate_range_of_days() {
		return rate_range_of_days;
	}

	public void setRate_range_of_days(Integer rate_range_of_days) {
		this.rate_range_of_days = rate_range_of_days;
	}

	public Integer getRate_percentage() {
		return rate_percentage;
	}

	public void setRate_percentage(Integer rate_percentage) {
		this.rate_percentage = rate_percentage;
	}

	public Double getRate_multiplier_days() {
		return rate_multiplier_days;
	}

	public void setRate_multiplier_days(Double rate_multiplier_days) {
		this.rate_multiplier_days = rate_multiplier_days;
	}

	public Double getTransfer_value_greater() {
		return transfer_value_greater;
	}

	public void setTransfer_value_greater(Double transfer_value_greater) {
		this.transfer_value_greater = transfer_value_greater;
	}

}
