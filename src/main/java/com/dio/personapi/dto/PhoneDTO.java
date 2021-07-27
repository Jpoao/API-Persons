package com.dio.personapi.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.dio.personapi.enums.PhoneType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneDTO {
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PhoneType type;
	
	@NotBlank
	@Size(min=13, max=14)
	private String number;
}
