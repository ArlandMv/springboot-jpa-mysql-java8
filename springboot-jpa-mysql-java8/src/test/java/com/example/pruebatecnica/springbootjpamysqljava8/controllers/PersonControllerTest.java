package com.example.pruebatecnica.springbootjpamysqljava8.controllers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.pruebatecnica.springbootjpamysqljava8.models.entity.Person;
import com.example.pruebatecnica.springbootjpamysqljava8.services.PersonService;

@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private PersonService personService;

    @InjectMocks
    private PersonController personController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarPeople() throws Exception {
        Person person1 = new Person(1L, "Pedro Perez", "pedro.perez@3it.cl", "Mobile Dev");
        Person person2 = new Person(2L, "María González", "maría.gonzález@3it.cl", "QA");
        // Given
        Mockito.when(personService.findAll()).thenReturn(Arrays.asList(person1, person2));
        
        // when
        mockMvc.perform(get("/api/v1/"))
        // then
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].nombre").value("Pedro Perez"))
        .andExpect(jsonPath("$[0].email").value("pedro.perez@3it.cl"))
        .andExpect(jsonPath("$[0].area").value("Mobile Dev"))
        .andExpect(jsonPath("$[1].nombre").value("María González"))
        .andExpect(jsonPath("$[1].email").value("maría.gonzález@3it.cl"))
        .andExpect(jsonPath("$[1].area").value("QA"));
        
        Mockito.verify(personService, Mockito.times(1)).findAll();
    }
    
    @Test
    public void testCrearPerson() throws Exception {
        String requestJson = "{ \"nombre\": \"John Doe\", \"email\": \"john.doe@example.com\", \"area\": \"Developer\" }";

        // Define the expected created Person object
        Person createdPerson = new Person(1L, "John Doe", "john.doe@example.com", "Developer");
        Mockito.when(personService.save(Mockito.any(Person.class))).thenReturn(createdPerson);

        mockMvc.perform(post("/api/v1/")
               .content(requestJson)
               .contentType("application/json"))
               .andExpect(status().isCreated())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.nombre").value("John Doe"))
               .andExpect(jsonPath("$.email").value("john.doe@example.com"))
               .andExpect(jsonPath("$.area").value("Developer"));

        Mockito.verify(personService, Mockito.times(1)).save(Mockito.any(Person.class));
    }

}
