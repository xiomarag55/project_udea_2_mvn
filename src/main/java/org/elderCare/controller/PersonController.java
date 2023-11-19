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
@CrossOrigin(origins = "*")
public class PersonController {
    @Autowired
    private  PersonService personService;

    @GetMapping("/mainInfo")
    public List<Person> createHeader() throws ParseException {
        return personService.allPersonsToRevision();
    }
    @GetMapping("/vulnerability")
    public Integer totalSituationVulnerability() throws ParseException {
        return personService.totalSituationVulnerability();
    }
    @GetMapping("/personPensioners")
    public Integer numberPensioners() throws ParseException {
        return personService.numberPensioners();
    }
    @GetMapping("/nonePensioners")
    public Integer numberNonePensioners() throws ParseException {
        return personService.numberNonePensioners();
    }
    @GetMapping("/pensionersOverSixty")
    public Integer numberPensionersOveSixty() throws ParseException {
        return personService.numberPensionersOveSixty();
    }
    @GetMapping("/womenPensioners")
    public Integer numberWomenPensioners() throws ParseException {
        return personService.numberWomenPensioners();
    }
    @GetMapping("/womenNonePensioners")
    public Integer numberWomenNonPensioners() throws ParseException {
        return personService.numberWomenNonPensioners();
    }
    @GetMapping("/percentPensioners")
    public Double percentPensioners() throws ParseException {
        return personService.percentPensioners();
    }
    @GetMapping("/percentNonePensioners")
    public Double percentNonPensioners() throws ParseException {
        return personService.percentNonPensioners();
    }
}
