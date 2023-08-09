/*
 * @(#)ServiceTest.java
 *
 * Copyright (c) BANCO DE CHILE (Chile). All rights reserved.
 *
 * All rights to this product are owned by BANCO DE CHILE and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by BANCO DE CHILE.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package com.example.pruebatecnica.springbootjpamysqljava8.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.pruebatecnica.springbootjpamysqljava8.models.entity.Person;
import com.example.pruebatecnica.springbootjpamysqljava8.models.repository.PersonRepository;

/**
 * ServiceTest.
 *
 * @author Arland Michelena.
 * @version 1.0.0, 08-08-2023
 */

public class PersonServiceTest {

    //@Mock
    //private PersonRepository personRepository;

    //@InjectMocks
	//private PersonService personService = new PersonServiceImpl();
    

    // -------------------------------------------------------------------
    // -- Setup ----------------------------------------------------------
    // -------------------------------------------------------------------
	
    /*PersonRepository repository;
    PersonService service;
    @BeforeEach
    void setup() {
        //repository = Mockito.mock(PersonRepository.class);
        //service = new PersonServiceImpl(repository);
    }*/
    
    // -------------------------------------------------------------------
    // -- Tests CR/CRUD --------------------------------------------------
    // -------------------------------------------------------------------
    /**
     * Test.
     */
    @Test
    void testReadPeople() {
    	//from course
    	PersonRepository repo = Mockito.mock(PersonRepository.class);
    	List<Person> personList = Arrays.asList(
    			new Person(1L, "Pedro Perez", "pedro.perez@3it.cl", "Mobile Dev"),
    			new Person(2L, "María González", "maría.gonzález@3it.cl", "QA")
    			);
    	Mockito.when(repo.findAll()).thenReturn(personList);
    	PersonService personService = new PersonServiceImpl();
        Iterable<Person> result = personService.findAll();
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.iterator().hasNext());

        // Assert that the returned list contains exactly 2 items
        //assertEquals(2, countIterableItems(result));
    	
    	/*List<Person> personList = new ArrayList<>();
    	personList.add(new Person(1L,  "Pedro Perez", "pedro.perez@3it.cl", "Mobile Dev"));
        personList.add(new Person(2L, "María González", "maría.gonzález@3it.cl", "QA"));*/
    	

    	//Iterable<Person> personList = Arrays.asList(
    	
    	
    	//service method null pointer exception
    	//Mockito.when((List<Person>)personRepository.findAll()).thenReturn(personList);
    	
    	//Mockito.when((List<Person>)personRepository.findAll()).thenReturn((List<Person>)personList);
    	//Mockito.when(personRepository.findAll()).thenReturn((List<Person>) personList);
    	
    	/*Mockito.when(personRepository.findAll()).thenReturn(new Iterable<Person>() { //ArrayList
            @Override
            public Iterator<Person> iterator() {
                return personList.iterator();
            }
        });*/
        
        
        //Iterable<Person> result =  personService.findAll();
        //List<Person> result = (List<Person>) personService.findAll();

        //Assertions.assertNotNull(result);
        //Assertions.assertEquals(2, ((List<Person>) result).size());
        //Assertions.assertEquals(2, countIterableItems(result));

    }
    
  
    
    /**
     * Test.
     
    @Test
    void testCreatePeople() {
        // Create a Person object to save
    	Person newPerson = new Person(3L, "Javiera Fernández", "javiera.fernández@3it.cl", "Back-end Dev");

        when(personRepository.save(any())).thenReturn(newPerson);

        Person savedPerson = personService.save(newPerson);

        assertEquals("Alice", savedPerson.getNombre());
        assertEquals("alice@example.com", savedPerson.getEmail());
        assertEquals("HR", savedPerson.getArea());
    }*/
    
    // -------------------------------------------------------------------
    // -------------------------------------------------------------------
    // -------------------------------------------------------------------
	


}
