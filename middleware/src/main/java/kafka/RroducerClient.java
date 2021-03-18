package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/**
 * /**
 *
 * @ClassName: RroducerClient
 * @description:
 * @author: pengyi
 * @create: 2021-03-16 20:11
 **/

//reference https://zhixiangyuan.github.io/2020/02/17/kafka-client-%E4%BD%BF%E7%94%A8%E7%A4%BA%E4%BE%8B/
public class RroducerClient {

    private static final Logger logger = LoggerFactory.getLogger(RroducerClient.class);

    private static Producer<String, String> createProducer() {
        // 设置 Producer 的属性
        Properties properties = new Properties();
        // 设置 Broker 的地址
        properties.put("bootstrap.servers", "localhost:9092");
//        properties.put("bootstrap.servers", "127.0.0.1:2181");
        // 0-不应答。1-leader 应答。all-所有 leader 和 follower 应答。
        properties.put("acks", "1");
        // 发送失败时，重试发送的次数
        properties.put("retries", 3);
//        properties.put("batch.size", 16384);
//        properties.put("linger.ms", 1);
//        properties.put("client.id", "DemoProducer");
//        properties.put("buffer.memory", 33554432);
        // 消息的 key 的序列化方式
        properties.put("key.serializer", StringSerializer.class.getName());
        // 消息的 value 的序列化方式
        properties.put("value.serializer", StringSerializer.class.getName());

        // 创建 KafkaProducer 对象
        // 因为我们消息的 key 和 value 都使用 String 类型，所以创建的 Producer 是 <String, String> 的泛型。
        return new KafkaProducer<>(properties);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建 KafkaProducer 对象
        Producer<String, String> producer = createProducer();

        // 同步发送消息
        for (int i = 0; ; i++) {
            // 创建消息。传入的三个参数，分别是 Topic ，消息的 key ，消息的 message
            String[] messages = new String[]{"hadoop scala spark hive", "kafka scala spark spark", "hbase redis hive storm","flink flink flink storm" };
            ProducerRecord<String, String> message = new ProducerRecord<>("streaming", "key" + i, messages[i % 4]);
            Future<RecordMetadata> sendResultFuture = producer.send(message);
            RecordMetadata result = sendResultFuture.get();
            System.out.println(String.format("message sent to [%s], partition [%s], offset [%s], key [%s]",
                    result.topic(), result.partition(), result.offset(), message.key()));
            TimeUnit.MILLISECONDS.sleep(1000);
        }
    }
}
