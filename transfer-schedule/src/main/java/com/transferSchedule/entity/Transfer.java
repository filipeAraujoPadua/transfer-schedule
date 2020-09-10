package com.transferSchedule.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRANSFER")
public class Transfer implements Serializable{

	private static final long serialVersionUID = 6098657671824563659L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "SOURCE_ACCOUNT")
	private String sourceAccount;
	
	@Column(name = "DESTINATION_ACCOUNT")
	private String destinationAccount;
	
	@Column(name = "TRANSFER_AMOUNT")
	private Double transferAmount;
	
	@Column(name = "TRANSFER_RATE")
	private Double transferRate;
	
	@Column(name = "TRANSFER_DATE")
	private Date transferDate;
	
	@Column(name = "SCHEDULING_DATE")
	private Date schedulingDate;
	
}
