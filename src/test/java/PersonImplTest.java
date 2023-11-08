import org.elderCare.repository.PersonInMemoryRepositoryImpl;
import org.elderCare.repository.PersonRepository;
import org.elderCare.service.PersonService;
import org.elderCare.service.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonImplTest {

    private PersonService personService;

    @BeforeEach
    void setUp(){
        this.personService = new PersonServiceImpl(new PersonInMemoryRepositoryImpl());
    }
    @Test
    void calculate_number_pensioners(){
        int average = this.personService.numberPensioners();
        assertEquals(9, average);
    }
    @Test
    void calculate_percent_number_pensioners(){
        double average = this.personService.percentPensioners();
        assertEquals(36.0, average);
    }
    @Test
    void calculate_percent_number_non_pensioners(){
        double average = this.personService.percentNonPensioners();
        assertEquals(64.0, average);
    }
}
