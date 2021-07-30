package com.dio.personapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dio.personapi.dto.PhoneDTO;
import com.dio.personapi.entities.Phone;
import com.dio.personapi.repositories.PhoneRepository;

@Service
public class PhoneService {

	@Autowired
	private PhoneRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Transactional(readOnly = true)
	public List<PhoneDTO> listAll() {
		List<Phone> person = repository.findAll();
		return person.stream().map(x -> mapper.map(x, PhoneDTO.class)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public PhoneDTO findById(Long id) {
		Optional<Phone> entity = repository.findById(id);
		Phone phone = entity.orElseThrow(() -> new EntityNotFoundException("Id " + id + " not found"));
		return mapper.map(phone, PhoneDTO.class);

	}

	@Transactional
	public PhoneDTO update(Long id, PhoneDTO updated) {

		try {
			Phone phone = repository.getById(id);
			phone.setNumber(updated.getNumber());
			phone.setType(phone.getType());
			return mapper.map(phone, PhoneDTO.class);
			
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("id " + id + " not found");
		}

	}
	
	
	
}
