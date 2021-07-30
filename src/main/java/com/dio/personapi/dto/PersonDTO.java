package com.dio.personapi.dto;

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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class PersonDTO {

	@NonNull
	private Long id;
	
	@NonNull
	@NotBlank
	@Size(min=2, max = 100)
	private String firstName;
	
	@NonNull
	@NotBlank
	@Size(min=2, max = 100)
	private String lastName;
	
	@NonNull
	@CPF
	private String cpf;
	
	@NonNull
	private String birthDate;
	
	@Valid
	@NotEmpty
	private Set<Phone> phones;
			
}
