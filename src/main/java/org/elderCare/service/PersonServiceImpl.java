package org.elderCare.service;

import org.elderCare.model.Person;
import org.elderCare.repository.PersonInMemoryRepositoryImpl;
import org.elderCare.repository.PersonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonServiceImpl implements PersonService {
    public PersonServiceImpl(PersonInMemoryRepositoryImpl personInMemoryRepository){

    }

    @Override
    public void peopleSituationVulnerability(List<Person> persons) {
        Map<String, Integer> vulnerablePerson = new HashMap<>();
        int totalSituationVulnerability = 0;
        for (Person person : persons) {
            if (person.getIsPension() == 'N' && person.getStratum() < 2) {
                vulnerablePerson.put(person.getIdentityDocument(), person.getStratum());
                totalSituationVulnerability++;
            }
        }
        for (Map.Entry<String, Integer> person : vulnerablePerson.entrySet()) {
            System.out.println("Document: " + person.getKey() + " Stratum: " + person.getValue());

        }


    }
}
