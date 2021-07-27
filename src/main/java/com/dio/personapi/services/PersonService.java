package com.dio.personapi.services;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dio.personapi.dto.PersonDTO;
import com.dio.personapi.entities.Person;
import com.dio.personapi.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Transactional
	public PersonDTO newPerson(PersonDTO person) {
				
		Person entity = repository.save(Person.builder()
				.birthDate(person.getBirthDate())
				.cpf(person.getCpf())
				.firstName(person.getFirstName())
				.lastName(person.getLastName())
				.build());
	
		return mapper.map(entity, PersonDTO.class);
		
	}
	
	
}
