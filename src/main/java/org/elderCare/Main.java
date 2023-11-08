package org.elderCare;

import org.elderCare.repository.PersonInMemoryRepositoryImpl;
import org.elderCare.repository.PersonRepository;
import org.elderCare.service.PersonService;
import org.elderCare.service.PersonServiceImpl;
public class Main {
    public static void main(String[] args) {

        PersonService personService = new PersonServiceImpl(new PersonInMemoryRepositoryImpl());

        personService.totalSituationVulnerability();
        System.out.println("Total number of people in vulnerability: " + personService.totalSituationVulnerability());
        System.out.println("Total of people pensioners: " + personService.numberPensioners());
        System.out.println("Total of people none pensioners: " + personService.numberNonePensioners());
        System.out.println("The number of retired people over 60 years of age is: " + personService.numberPensionersOveSixty());
        System.out.println("Number of women pensioners : " + personService.numberWomenPensioners());
        System.out.println("Number of women Non pensioners : " + personService.numberWomenNonPensioners());
        System.out.println("Percent of pensioners : " + personService.percentPensioners());
        System.out.println("Percent of non pensioners : " + personService.percentNonPensioners());
    }
}