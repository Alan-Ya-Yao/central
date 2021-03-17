package kafka;

/**
 * /**
 *
 * @ClassName: ConsumerMain
 * @description:
 * @author: pengyi
 * @create: 2021-03-17 14:27
 **/
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;


/***
 *
 *  代码参考 https://zhixiangyuan.github.io/2020/02/17/kafka-client-%E4%BD%BF%E7%94%A8%E7%A4%BA%E4%BE%8B/
 *  手动提交 https://www.cnblogs.com/xuwujing/p/8432984.html
 */
public class ConsumerMain {

    private static Consumer<String, String> createConsumer() {
        // 设置 Producer 的属性
        Properties properties = new Properties();
        // 设置 Broker 的地址
        properties.put("bootstrap.servers", "localhost:9092");
        // 消费者分组
        properties.put("group.id", "demo-consumer-group");
        // 设置消费者分组最初的消费进度为 earliest 。可参考博客 https://blog.csdn.net/lishuangzhe7047/article/details/74530417 理解
        properties.put("auto.offset.reset", "earliest");
        /**
         * 是否自动提交消费进度
         * 自动提交 好像不工作，重启后会从头消费
         * 手动提交，是工作
         * */
        properties.put("enable.auto.commit", false);

        // 自动提交消费进度频率
        properties.put("auto.commit.interval.ms", "1000");
        // 消息的 key 的反序列化方式
        properties.put("key.deserializer", StringDeserializer.class.getName());
        // 消息的 value 的反序列化方式
        properties.put("value.deserializer", StringDeserializer.class.getName());

        // 创建 KafkaProducer 对象
        // 因为我们消息的 key 和 value 都使用 String 类型，所以创建的 Producer 是 <String, String> 的泛型。
        return new KafkaConsumer<>(properties);
    }

    public static void main(String[] args) {
        // 创建 KafkaConsumer 对象
        Consumer<String, String> consumer = createConsumer();

        // 订阅消息
        consumer.subscribe(Collections.singleton("my_topic"));

        // 拉取消息
        while (true) {
            // 拉取消息。如果拉取不到消息，阻塞等待最多 10 秒，或者等待拉取到消息。
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10));
            // 遍历处理消息
            records.forEach(record -> System.out.println(String.format("key: [%s], value: [%s]", record.key(), record.value())));
            consumer.commitSync();
        }
    }
}