package streaming

import java.util.Properties

import org.apache.flink.streaming.api.scala._
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.api.java.operators.DataSource
import org.apache.flink.streaming.api.datastream.DataStreamSource
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer

object StreamingJob {
  def main(args: Array[String]) {
    // set up the streaming execution environment
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val props = new Properties
    props.put("bootstrap.servers", "localhost:9092")
    props.put("zookeeper.connect", "localhost:2181")
    props.put("group.id", "metric-group")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer") //key 反序列化

    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("auto.offset.reset", "latest") //value 反序列化

    //kafka的consumer，test1是要消费的topic
    val kafkaSource = new FlinkKafkaConsumer[String]("streaming",new SimpleStringSchema,props)
    //设置从最新的offset开始消费
    kafkaSource.setStartFromLatest()
    //自动提交offset
    kafkaSource.setCommitOffsetsOnCheckpoints(true)
    val stream = env.addSource(kafkaSource)


    stream.print //把从 kafkaUtils中发出的kafka数据 读取到的数据打印在控制台
    /*
     * Here, you can start creating your execution plan for Flink.
     *
     * Start with getting some data from the environment, like
     *  env.readTextFile(textPath);
     *
     * then, transform the resulting DataStream[String] using operations
     * like
     *   .filter()
     *   .flatMap()
     *   .join()
     *   .group()
     *
     * and many more.
     * Have a look at the programming guide:
     *
     * https://flink.apache.org/docs/latest/apis/streaming/index.html
     *
     */

    // execute program
    env.execute("Flink Streaming Scala API Skeleton")
  }
}
