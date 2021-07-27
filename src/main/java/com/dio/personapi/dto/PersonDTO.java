package com.dio.personapi.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.dio.personapi.entities.Phone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String cpf;
	private LocalDateTime birthDate;
	private Set<Phone> phones;
}
