package org.elderCare.controller;

import org.elderCare.model.Person;
import org.elderCare.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("eldercare/persons/")
@CrossOrigin(origins = "file:///C:/Users/Xiomara/Desktop/index.html")
public class PersonController {
    @Autowired
    private  PersonService personService;

    @GetMapping("/test")
    public List<Person> createHeader() throws ParseException {
        return personService.allPersonsToRevision();
    }
}
