package lp.kafka.lowversion.consumer;


import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ConsumerMain {


    String zooKeeper = "yf-aip-fg-test01.yf01:8131,yf-aip-fg-test01.yf01:8132,yf-aip-fg-test01.yf01:8133";
    String groupId = "myApp";
    String topic = "my-test-topic-lp-a";

    ConsumerConnector consumerConnector;

    public ConsumerMain() {

        Properties props = new Properties();
        props.put("zookeeper.connect", zooKeeper);
        props.put("group.id", groupId);
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");

        ConsumerConfig consumerConfig = new ConsumerConfig(props);

        consumerConnector =  Consumer.createJavaConsumerConnector(consumerConfig);

        Map<String, Integer> topicCountMap = new HashMap<>();
        topicCountMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector.createMessageStreams(topicCountMap);


        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

        for (KafkaStream<byte[], byte[]> stream : streams) {
            StreamConsumer streamConsumer = new StreamConsumer(stream);
            new Thread(streamConsumer).start();
        }
    }




    class StreamConsumer implements Runnable {

        private KafkaStream stream;

        public StreamConsumer(KafkaStream stream) {
            this.stream = stream;
        }

        public void run() {
            ConsumerIterator<byte[], byte[]> it = this.stream.iterator();
            while (it.hasNext()) {
                System.out.println("Consumed message: " +  new String(it.next().message()));
            }
        }
    }



    public static void main(String[] args) {
        new ConsumerMain();
    }


}
