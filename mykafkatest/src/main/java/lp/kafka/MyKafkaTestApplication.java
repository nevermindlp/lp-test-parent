package lp.kafka;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class MyKafkaTestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyKafkaTestApplication.class, args).close();
	}

	public int consumerCount = 0;

	@Autowired
	private KafkaTemplate<String, String> template;

	private final CountDownLatch latch = new CountDownLatch(100);

	@Override
	public void run(String... args) throws Exception {
//		this.template.send("myTopic", "foo1");
//		this.template.send("myTopic", "foo2");
//		this.template.send("myTopic", "foo3");
//		this.template.flush();

		for (int i = 0; i < 50; i++) {
			this.template.send("shoulder-track-topic", "test" + i);
		}
		latch.await(10, TimeUnit.SECONDS);
		System.out.println("All received");
	}

	@KafkaListener(topics = "shoulder-track-topic-lp", containerGroup = "lp-test")
	public void listen(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println(cr.value());
//		latch.countDown();
		consumerCount++;
		System.out.println("consumerCount = " + consumerCount);
	}
}
