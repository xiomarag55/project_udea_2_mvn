package org.elderCare;

import org.elderCare.repository.PersonInMemoryRepositoryImpl;
import org.elderCare.repository.PersonRepository;
import org.elderCare.service.PersonService;
import org.elderCare.service.PersonServiceImpl;
public class Main {
    public static void main(String[] args) {

        PersonService personService = new PersonServiceImpl(new PersonInMemoryRepositoryImpl());
        PersonRepository personRepository = new PersonInMemoryRepositoryImpl();

        personService.totalSituationVulnerability(personRepository.findAllPersons());
        System.out.println("Total number of people in vulnerability: " + personService.totalSituationVulnerability(personRepository.findAllPersons()));

        personService.numberPensioners(personRepository.findAllPersons());
        System.out.println("Total of people pensioners: " + personService.numberPensioners(personRepository.findAllPersons()));

        personService.numberNonePensioners(personRepository.findAllPersons());
        System.out.println("Total of people none pensioners: " + personService.numberNonePensioners(personRepository.findAllPersons()));

        personService.numberPensionersOveSixty(personRepository.findAllPersons());
        System.out.println("The number of retired people over 60 years of age is: " + personService.numberPensionersOveSixty(personRepository.findAllPersons()));

        personService.numberWomenPensioners(personRepository.findAllPersons());
        System.out.println("Number of women pensioners : " + personService.numberWomenPensioners(personRepository.findAllPersons()));

        personService.numberWomenNonPensioners(personRepository.findAllPersons());
        System.out.println("Number of women Non pensioners : " + personService.numberWomenNonPensioners(personRepository.findAllPersons()));
    }
}