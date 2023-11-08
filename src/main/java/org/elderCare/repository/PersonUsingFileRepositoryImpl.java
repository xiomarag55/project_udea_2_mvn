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
import java.util.stream.Collectors;
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
        } catch (IOException exception) {
            logger.error("Error reading people file: {}", exception.getMessage());
        }
        return Collections.emptyList();
    }

    private Person buildPerson(String personData) {
        String[] personFields = personData.split(",");
        return new Person(personFields[0], Integer.parseInt(personFields[1]), personFields[2], personFields[3], Integer.parseInt(personFields[4]), personFields[5].charAt(0), personFields[6].charAt(0));
    }

    @Override
    public List<Person> findAllPersons() {
        return persons;
    }

    @Override
    public void addPerson(Person person) {
        persons.add(person);
        savePersonsToFile();
    }

    @Override
    public void removePerson(String personId) {
        Person personToRemove = persons.stream()
                .filter(person -> person.identityDocument().equals(personId))
                .findFirst()
                .orElse(null);

        if (personToRemove != null) {
            persons.remove(personToRemove);
            savePersonsToFile(); // Guarda la lista actualizada en el archivo
        }
    }

    private void savePersonsToFile() {
        List<String> plainTextPersonList = persons.stream()
                .map(this::convertPersonToPlainText)
                .collect(Collectors.toList());

        try {
            Files.write(Paths.get("./src/main/resources/persons.txt"), plainTextPersonList);
        } catch (IOException e) {
            logger.error("Error saving people list to file: {}", e.getMessage());
        }
    }

    private String convertPersonToPlainText(Person person){
        return null;
    }

}
