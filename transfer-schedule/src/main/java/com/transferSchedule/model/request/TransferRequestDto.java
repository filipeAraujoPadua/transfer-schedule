package com.transferSchedule.model.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequestDto {

	private Long id;
	
	@NotNull(message="The source account must be informed")
	@Length(min=6, max=6, message="The source account must be 6 digits")
	private String sourceAccount;
	
	@NotNull(message="The target account must be informed")
	@Length(min=6, max=6, message="The target account must be 6 digits")
	private String destinationAccount;

	@NotNull(message="The amount must be informed")
	private Double transferAmount;

	private Double transferRate;

	@NotNull(message="The transfer date must be informed")
	private Date transferDate;

	@NotNull(message="The scheduling date must be informed")
	private Date schedulingDate;

}
