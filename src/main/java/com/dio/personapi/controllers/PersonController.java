package com.dio.personapi.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PersonDTO> findPerson(@PathVariable Long id){
		
		PersonDTO entity = service.findById(id);
		return ResponseEntity.ok().body(entity);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PersonDTO> delete(@PathVariable Long id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
				
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody PersonDTO updated){
		
		PersonDTO entity = service.update(id, updated);
		return ResponseEntity.ok().body(entity);
	}
}
