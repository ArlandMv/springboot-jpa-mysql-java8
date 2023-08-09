package com.example.pruebatecnica.springbootjpamysqljava8;

import com.example.pruebatecnica.springbootjpamysqljava8.models.*;
import com.example.pruebatecnica.springbootjpamysqljava8.models.entity.Person;

import java.util.Optional;

public class Datos {
	public static Optional<Person> createPerson01() {
		return Optional.of(new Person(1L, "Pedro Perez", "pedro.perez@3it.cl", "Mobile Dev"));
	}
	public static Optional<Person> createPerson02() {
		return Optional.of(new Person(2L, "María González", "maría.gonzález@3it.cl", "QA"));
	}
}
