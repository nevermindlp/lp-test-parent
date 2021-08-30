package lp.kafka;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@SpringBootApplication
//@Async
//@EnableAsync
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
		this.template.send("so53605262", "foo1");
		this.template.send("so53605262", "foo2");
		this.template.send("so53605262", "foo3");
		this.template.flush();

		for (int i = 10; i < 18; i++) {
			String data = i + getMockBigStr();
//			String data = "data" + i;
			System.out.println("data :" + i);
			this.template.send("so53605262", data);
//			ListenableFuture<SendResult<String, String>> future = template.send("lp-topic-test", data);
//			future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//
//				@Override
//				public void onSuccess(SendResult<String, String> result) {
//					System.out.println("Sent message=[" + data +
//							"] with offset=[" + result.getRecordMetadata().offset() + "]");
//				}
//				@Override
//				public void onFailure(Throwable ex) {
//					System.out.println("Unable to send message=["
//							+ data + "] due to : " + ex.getMessage());
//				}
//			});

		}
		this.template.flush();
		latch.await(10000, TimeUnit.SECONDS);
		System.out.println("All received");
	}

	@KafkaListener(topics = {"so53605262"}, containerFactory = "myContainerFactory")
	public void listen(ConsumerRecord<?, ?> cr) throws Exception {
		String value = (String) cr.value();
		System.out.println("listen get message : " + value.length() + "     partition is : "
				+ cr.partition() + " thread is : " + Thread.currentThread());

		Thread.sleep(5000);
		latch.countDown();
		consumerCount++;
		System.out.println("consumerCount = " + consumerCount);
//		throw new RuntimeException("aaaaaaa");
	}

//	@KafkaListener(topics = {"lp-topic-test"}, containerFactory = "myContainerFactory")
//	public void listen1(ConsumerRecord<?, ?> cr) throws Exception {
//		System.out.println("listen1 get message : " + cr.value() + "   partition is : " + cr.partition()
//				+ " thread is : " + Thread.currentThread());
//				latch.countDown();
//				consumerCount++;
//				System.out.println("consumerCount = " + consumerCount);
////		throw new RuntimeException("bbbbbbbbbb");
//	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> myContainerFactory(ConsumerFactory<String, String> consumerFactory) {
		ConcurrentKafkaListenerContainerFactory<String, String> factory =
				new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory);
		factory.setConcurrency(5);
//		factory.setRecordFilterStrategy(record -> record.value().contains("5"));
		factory.setAckDiscarded(true);
		return factory;
	}

	public String getBigStr() {

		StringBuffer buf = new StringBuffer("Java");
		for (int i = 0; i < 100000; i++) {
			buf.append("simpleTest");
		}
		String bigStr = buf.toString();
//		System.out.println("size is :" + bigStr.length());
		return buf.toString();
	}

	public String getMockBigStr() {
		return new String(new byte[1024 * 1024 * 2]);
	}

}
