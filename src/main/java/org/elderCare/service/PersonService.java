package org.elderCare.service;

import org.elderCare.model.Person;

import java.util.List;

public interface PersonService {

    //Method for printing people in vulnerable situation
    void peopleSituationVulnerability();
    void allPersonsToRevision();
    int totalSituationVulnerability();
    int numberPensioners();
    int numberNonePensioners();
    int numberPensionersOveSixty();
    int numberWomenPensioners();
    int numberWomenNonPensioners();
    double percentPensioners();
    double percentNonPensioners();

}
