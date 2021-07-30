package com.dio.personapi.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.dio.personapi.enums.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhoneDTO {
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PhoneType type;
	
	@NotBlank
	@Size(min=13, max=14)
	@Column(unique = true)
	private String number;

}
