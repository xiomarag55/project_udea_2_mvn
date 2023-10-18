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
                new Person("Marta Reyes", 60, "1023789713", "Casada", 2, 'N', 'F'),
                new Person("Carmen Carrera", 52, "1045789713", "Casada", 3, 'N', 'F'),
                new Person("Dario Roldan", 59, "1078689713", "Casado", 2, 'N', 'M'),
                new Person("Julian Cardona", 66, "1028965313", "Viudo", 4, 'S', 'M'),
                new Person("Marina Castrillon", 63, "1145689713", "Viuda", 1, 'S', 'F'),
                new Person("Alicia Martinez", 67, "1023787896", "Casada", 2, 'N', 'F'),
                new Person("Marcos Escobar", 68, "1093789713", "Soltero", 1, 'N', 'M'),
                new Person("Pablo Emilio Trujilloo", 60, "1192789713", "Casado", 5, 'S', 'M'),
                new Person("Fernando Antonio Vazquez", 73, "1022876713", "Divorciado", 3, 'N', 'M'),
                new Person("Angelica Maria Guerra", 54, "1987654313", "Soltera", 2, 'N', 'F'),
                new Person("Elkin Ventola paja", 69, "1023785463", "Viudo", 1, 'S', 'M'),
                new Person("Mauricio Vargas", 71, "1023789798", "Viudo", 3, 'S', 'M'),
                new Person("Rosa Melarga Ventosa", 59, "1026989713", "Divorciada", 2, 'N', 'F'),
                new Person("Karen Antonia Zapata", 67, "1177789713", "Soltera", 1, 'S', 'F')
                );
        return persons;
    }
}
