package lp.kafka.lowversion.producer;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

public class ProducerMain {

    public ProducerMain(String topic, int partitionCount, int msgProduceDelay) {

        Properties props = new Properties();

        props.put("metadata.broker.list", "10.38.27.39:8292,10.38.27.39:8293,10.38.27.39:8294");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "1");

        ProducerConfig config = new kafka.producer.ProducerConfig(props);
        Producer p = new Producer<String, String>(config);

        run(topic, partitionCount, msgProduceDelay, p);
    }



    private void run(String topic, int partitionCount, int msgProduceDelay, Producer p) {

        int i = 0;
        while(i < 50) {
            String message = "Message #" + (i + 1);
            String key = "" + i % partitionCount;
            KeyedMessage<String, String> keyedMessage = new KeyedMessage<>(topic, key, message);
            p.send(keyedMessage);
            System.out.println("Sent message :" + message);
            sleep(msgProduceDelay);
            i++;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ProducerMain("my-test-topic-lp-a", 2, 500);
    }

}