package com.example.pruebatecnica.springbootjpamysqljava8.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pruebatecnica.springbootjpamysqljava8.models.entity.Person;
import com.example.pruebatecnica.springbootjpamysqljava8.models.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Person> findAll() {
		return repository.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Optional<Person> findById(Long id) {
		return repository.findById(id);
	}
	@Override
	@Transactional
	public Person save(Person person) {
		return repository.save(person);
	}
	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
