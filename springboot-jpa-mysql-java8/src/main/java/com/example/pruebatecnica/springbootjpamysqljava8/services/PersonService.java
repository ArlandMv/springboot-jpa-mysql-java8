package com.example.pruebatecnica.springbootjpamysqljava8.services;

import java.util.Optional;

import com.example.pruebatecnica.springbootjpamysqljava8.models.entity.Person;

public interface PersonService {
	
	public Iterable<Person> findAll();
	
	public Optional<Person> findById(Long id);
	
	public Person save(Person person);
	
	public void deleteById(Long id);
	
}
