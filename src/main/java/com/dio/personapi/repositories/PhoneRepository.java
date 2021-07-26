package com.dio.personapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.personapi.entities.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
