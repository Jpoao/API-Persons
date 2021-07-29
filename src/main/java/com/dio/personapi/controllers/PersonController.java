package com.dio.personapi.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dio.personapi.dto.PersonDTO;
import com.dio.personapi.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@PostMapping
	public ResponseEntity<PersonDTO> insert(@RequestBody @Valid PersonDTO newPerson){
		
		PersonDTO entity = service.newPerson(newPerson);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId())
				.toUri();
		return ResponseEntity.created(uri).body(entity);
		
	}
	
	@GetMapping
	public ResponseEntity<List<PersonDTO>> listAll(){
		
		List<PersonDTO> entities = service.listAll();
		return ResponseEntity.ok().body(entities);
	}

}
