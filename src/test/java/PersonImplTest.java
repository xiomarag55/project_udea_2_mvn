import org.elderCare.repository.PersonUsingFileRepositoryImpl;
import org.elderCare.service.PersonService;
import org.elderCare.service.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonImplTest {

    private PersonService personService;

    @BeforeEach
    void setUp(){
        this.personService = new PersonServiceImpl(new PersonUsingFileRepositoryImpl());
    }
    @Test
    void calculate_number_pensioners(){
        int average = this.personService.numberPensioners();
        assertEquals(10, average);
    }
    @Test
    void calculate_percent_number_pensioners(){
        double average = this.personService.percentPensioners();
        assertEquals(38.0, average);
    }
    @Test
    void calculate_percent_number_non_pensioners(){
        double average = this.personService.percentNonPensioners();
        assertEquals(62.0, average);
    }
}
