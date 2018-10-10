package lp.jackson;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by lvpeng01 on 2018/9/4.
 */
public class MapperTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testSer() {
        Person person = new Person("lp1", 21);

        try {
            String serString = mapper.writeValueAsString(person);
            Person newP = mapper.readValue(serString, Person.class);
            System.out.println(newP.getName());
            System.out.println(newP.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
