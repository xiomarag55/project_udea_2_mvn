package org.elderCare.service;

import org.elderCare.model.Person;

import java.util.List;

public interface PersonService {

    //Method for printing people in vulnerable situation
    void peopleSituationVulnerability(List<Person> persons);
    int totalSituationVulnerability(List<Person> persons);
    int numberPensioners(List<Person> persons);
    int numberNonePensioners(List<Person> persons);
    int numberPensionersOveSixty(List<Person> persons);
    int numberWomenPensioners(List<Person> persons);
    int numberWomenNonPensioners(List<Person> persons);
    double percentPensioners(List<Person> persons);
    double percentNonPensioners(List<Person> persons);
}
