package com.dio.personapi.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
				.birthDate(LocalDate.parse(person.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))
						.atStartOfDay())
				.cpf(person.getCpf()).firstName(person.getFirstName()).lastName(person.getLastName())
				.phones(person.getPhones()).build());

		return mapper.map(entity, PersonDTO.class);

	}

	@Transactional(readOnly = true)
	public List<PersonDTO> listAll() {
		List<Person> person = repository.findAll();
		return person.stream().map(x -> mapper.map(x, PersonDTO.class)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public PersonDTO findById(Long id) {
		Optional<Person> entity = repository.findById(id);
		Person person = entity.orElseThrow(() -> new EntityNotFoundException("Id " + id + " not found"));
		return mapper.map(person, PersonDTO.class);

	}

	@Transactional
	public void delete(Long id) {

		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("id " + id + "not found");
		}
	}

	@Transactional
	public PersonDTO update(Long id, PersonDTO updated) {

		try {
			Person person = repository.getById(id);
			person.setBirthDate(
					LocalDate.parse(updated.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay());
			person.setCpf(updated.getCpf());
			person.setFirstName(updated.getFirstName());
			person.setLastName(updated.getLastName());;
			
			if(!(  updated.getPhones()==null || updated.getPhones().isEmpty()))
				person.setPhones(updated.getPhones());
			
			person = repository.save(person);
			return mapper.map(person, PersonDTO.class);
			
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("id " + id + " not found");
		}

	}
}
