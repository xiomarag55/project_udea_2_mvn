package org.elderCare.service;

import org.elderCare.model.Person;

import java.util.List;

public interface PersonService {

    //Method for printing people in vulnerable situation
    void peopleSituationVulnerability();
    int totalSituationVulnerability();
    int numberPensioners(List<Person> persons);
    int numberNonePensioners(List<Person> persons);
    int numberPensionersOveSixty();
    int numberWomenPensioners();
    int numberWomenNonPensioners();
    double percentPensioners();
    double percentNonPensioners();
}
