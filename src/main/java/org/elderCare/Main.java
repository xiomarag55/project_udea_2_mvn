package org.elderCare;

import org.elderCare.repository.PersonUsingFileRepositoryImpl;
import org.elderCare.service.PersonService;
import org.elderCare.service.PersonServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        PersonService personService = new PersonServiceImpl(new PersonUsingFileRepositoryImpl());

        System.out.println("--------------------------- Persons for revision------------------------------");
        personService.allPersonsToRevision();
        System.out.println("----------------------------End-----------------------------------------------");
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