package org.elderCare.controller;

import org.elderCare.model.Person;
import org.elderCare.repository.PersonUsingFileRepositoryImpl;
import org.elderCare.service.PersonService;
import org.elderCare.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("eldercare/persons/")
public class PersonController {
    private final PersonService personService = new PersonServiceImpl(new PersonUsingFileRepositoryImpl());

    @GetMapping("/test")
    public List<Person> createHeader() throws ParseException {
        return personService.allPersonsToRevision();
    }
}
