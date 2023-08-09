package com.example.pruebatecnica.springbootjpamysqljava8.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.pruebatecnica.springbootjpamysqljava8.models.entity.Person;
import com.example.pruebatecnica.springbootjpamysqljava8.models.repository.PersonRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PersonRepositoryTests {

	@Autowired
	private PersonRepository repository;
	
	@Test
	public void  savePersonTest() {
		Person newPerson = new Person(1L, "Pedro Perez", "pedro.perez@3it.cl", "Mobile Dev");
        Person savedPerson = repository.save(newPerson);
        Assertions.assertEquals("Alice", savedPerson.getNombre());
        Assertions.assertEquals("alice@example.com", savedPerson.getEmail());
        Assertions.assertEquals("HR", savedPerson.getArea());
	}
	
	@Test
    void testFindAll() {
        List<Person> cuentas = (List<Person>) repository.findAll();
        Assertions.assertFalse(cuentas.isEmpty());
        Assertions.assertEquals(2, cuentas.size());
    }
	
	
	
}
