package com.example.pruebatecnica.springbootjpamysqljava8.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pruebatecnica.springbootjpamysqljava8.models.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
