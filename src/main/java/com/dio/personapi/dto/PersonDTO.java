package com.dio.personapi.dto;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

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
	
	@NotBlank
	@Size(min=2, max = 100)
	private String firstName;
	
	@NotBlank
	@Size(min=2, max = 100)
	private String lastName;
	
	@CPF
	private String cpf;
	
	private String birthDate;
	
	@Valid
	@NotEmpty
	private Set<Phone> phones;
}
