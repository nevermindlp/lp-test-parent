package lp.kafka;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyKafkaTestApplicationTests {

	@Test
	public void contextLoads() {

		long time = 1534407825349L;
		System.out.println(new Date(time));

	}

}
