package org.elderCare;

import org.elderCare.repository.PersonInMemoryRepositoryImpl;
import org.elderCare.repository.PersonRepository;
import org.elderCare.service.PersonService;
import org.elderCare.service.PersonServiceImpl;

import java.util.logging.Logger;
public class Main {
    public static void main(String[] args) {

        Logger logger;
        PersonService personService = new PersonServiceImpl(new PersonInMemoryRepositoryImpl());
        PersonRepository personRepository = new PersonInMemoryRepositoryImpl();

        personService.peopleSituationVulnerability(personRepository.findAllPersons());

    }
}