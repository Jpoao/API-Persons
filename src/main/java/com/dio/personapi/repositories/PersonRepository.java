package com.dio.personapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.personapi.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
