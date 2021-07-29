package com.dio.personapi.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

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
				.birthDate(LocalDate.parse(person.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay())
				.cpf(person.getCpf())
				.firstName(person.getFirstName())
				.lastName(person.getLastName())
				.phones(person.getPhones())
				.build());
				
		return mapper.map(entity, PersonDTO.class);
		
	}
	
	@Transactional(readOnly = true)
	public List<PersonDTO> listAll(){
		List<Person> person = repository.findAll();
		return person.stream().map(x -> mapper.map(x, PersonDTO.class)).collect(Collectors.toList());
	}
	
	
}
