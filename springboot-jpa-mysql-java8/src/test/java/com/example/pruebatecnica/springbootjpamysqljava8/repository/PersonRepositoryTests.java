package com.example.pruebatecnica.springbootjpamysqljava8.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.pruebatecnica.springbootjpamysqljava8.models.entity.Person;
import com.example.pruebatecnica.springbootjpamysqljava8.models.repository.PersonRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PersonRepositoryTests {

	@Autowired
	private PersonRepository repository;
	
	@Test
	public void  PersonRepository_Save_ReturnSavedPerson() {
		Person newPerson = new Person();
		newPerson.setNombre("Pedro Perez");
		newPerson.setEmail("pedro.perez@3it.cl");
		newPerson.setArea("Mobile Dev");
		Person savedPerson = repository.save(newPerson);
        Assertions.assertEquals("Pedro Perez", savedPerson.getNombre());
        Assertions.assertEquals("pedro.perez@3it.cl", savedPerson.getEmail());
        Assertions.assertEquals("Mobile Dev", savedPerson.getArea());
	}
	
	@Test
    void testFindAll() {
        List<Person> cuentas = (List<Person>) repository.findAll();
        Assertions.assertFalse(cuentas.isEmpty());
        Assertions.assertEquals(2, cuentas.size());
    }
}
