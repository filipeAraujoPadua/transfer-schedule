package com.transferSchedule.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transfer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String source_account;
	
	@Column(nullable = false)
	private String destination_account;
	
	@Column(nullable = false)
	private Double transfer_amount;
	
	@Column(nullable = true)
	private Double transfer_rate;
	
	@Column(nullable = false)
	private Date transfer_date;
	
	@Column(nullable = false)
	private Date scheduling_date;
	
	public Transfer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSource_account() {
		return source_account;
	}

	public void setSource_account(String source_account) {
		this.source_account = source_account;
	}

	public String getDestination_account() {
		return destination_account;
	}

	public void setDestination_account(String destination_account) {
		this.destination_account = destination_account;
	}

	public Double getTransfer_amount() {
		return transfer_amount;
	}

	public void setTransfer_amount(Double transfer_amount) {
		this.transfer_amount = transfer_amount;
	}

	public Double getTransfer_rate() {
		return transfer_rate;
	}

	public void setTransfer_rate(Double transfer_rate) {
		this.transfer_rate = transfer_rate;
	}

	public Date getTransfer_date() {
		return transfer_date;
	}

	public void setTransfer_date(Date transfer_date) {
		this.transfer_date = transfer_date;
	}

	public Date getScheduling_date() {
		return scheduling_date;
	}

	public void setScheduling_date(Date scheduling_date) {
		this.scheduling_date = scheduling_date;
	}
}
