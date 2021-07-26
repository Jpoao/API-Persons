package com.dio.personapi.dto;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import com.dio.personapi.entities.Person;
import com.dio.personapi.entities.Phone;
import com.dio.personapi.enums.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {
	
	private Long id;
	private PhoneType type;
	private String number;
}
