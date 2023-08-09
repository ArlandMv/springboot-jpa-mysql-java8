package com.example.pruebatecnica.springbootjpamysqljava8.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebatecnica.springbootjpamysqljava8.models.entity.Person;
import com.example.pruebatecnica.springbootjpamysqljava8.services.PersonService;

@RestController
@RequestMapping("/api/v1/")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<Person> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> crear(@RequestBody Person person){
		//return service.save(person);
		Person personDb = service.save(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(personDb);
	}
}
