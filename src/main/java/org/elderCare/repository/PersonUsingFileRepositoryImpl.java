package org.elderCare.repository;

import org.elderCare.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class PersonUsingFileRepositoryImpl implements PersonRepository {
    private static final Logger logger = LoggerFactory.getLogger(PersonUsingFileRepositoryImpl.class);
    private final List<Person> persons;

    public PersonUsingFileRepositoryImpl() {
        this.persons = new ArrayList<>(loadPersons());
    }

    private List<Person> loadPersons() {
        logger.info("The persons to be checked are loaded from the file");
        List<String> plainTextPersonList = readFileWithPersons();
        return plainTextPersonList.stream().map(this::buildPerson).toList();
    }

    private List<String> readFileWithPersons() {
        Path path = Paths.get("./src/main/resources/persons.txt");
        try (Stream<String> stream = Files.lines(path)) {
            return stream.toList();
        } catch (IOException x) {
            logger.error("IOException: {0}", x);
        }
        return Collections.emptyList();
    }

    private Person buildPerson(String plainTextGrade) {
        String[] questionArray = plainTextGrade.split(",");
        return new Person(questionArray[0], Integer.parseInt(questionArray[1]), questionArray[2], questionArray[3], Integer.parseInt(questionArray[4]), questionArray[5].charAt(0), questionArray[6].charAt(0));
    }

    @Override
    public List<Person> findAllPersons() {
        return persons;
    }
}
