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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRANSFER_RATE")
public class TransferRate implements Serializable{

	private static final long serialVersionUID = -5867736773681366284L;

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
	
}
