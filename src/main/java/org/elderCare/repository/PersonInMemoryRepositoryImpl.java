package org.elderCare.repository;

import org.elderCare.model.Person;

import java.util.List;

public class PersonInMemoryRepositoryImpl implements PersonRepository {
    @Override
    public List<Person> findAllPersons() {
        List<Person> persons = List.of(
                new Person("Luis Carlos Arango", 50, "112372567", "Soltero", 1, 'S', 'M'),
                new Person("Maria Lopez Ruiz", 60, "13237256", "Casada", 2, 'N', 'F'),
                new Person("Jose Felix Restrepo", 81, "142372545", "Viudo", 1, 'N', 'M'),
                new Person("Maria elvira Zapata", 70, "152372521", "Viuda", 3, 'S', 'F'),
                new Person("Carlos Felipe Ruiz", 65, "162372545", "Soltero", 1, 'N', 'M'),
                new Person("Fernando Miguel Pelaez", 50, "17237245", "Casado", 2, 'N', 'M'),
                new Person("Mariela Montoya", 58, "182372566", "Casada", 1, 'S', 'F'),
                new Person("Fernando Orozco", 53, "192372545", "Divorciado", 1, 'N', 'M'),
                new Person("Felipe Sanchez", 76, "1023726510", "Viudo", 1, 'N', 'M'),
                new Person("Carla Lopez", 60, "1023725611", "Casada", 2, 'N', 'F'),
                new Person("Josefa Pérez", 60, "1023728812", "Casada", 2, 'N', 'F'),
                new Person("Marta Reyes", 60, "1023789713", "Casada", 2, 'N', 'F')
        );
        return persons;
    }
}
