package com.dio.personapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.personapi.dto.PhoneDTO;
import com.dio.personapi.services.PhoneService;

@RestController
@RequestMapping("/phones")
public class PhoneController {

	@Autowired
	private PhoneService phoneService;

	@GetMapping
	public ResponseEntity<List<PhoneDTO>> listAllPhones() {

		List<PhoneDTO> entities = phoneService.listAll();
		return ResponseEntity.ok().body(entities);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PhoneDTO> findPhone(@PathVariable Long id) {

		PhoneDTO entity = phoneService.findById(id);
		return ResponseEntity.ok().body(entity);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PhoneDTO> updatePhone(@PathVariable Long id, @RequestBody PhoneDTO updated) {

		PhoneDTO entity = phoneService.update(id, updated);
		return ResponseEntity.ok().body(entity);
	}

}
