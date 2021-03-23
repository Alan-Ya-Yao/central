package streaming

import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.TimeCharacteristic
import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer
import streaming.common.KafkaTuple2DeserializationSchema
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.assigners.SlidingEventTimeWindows
import org.apache.flink.streaming.api.windowing.time.Time


object StreamingJob2 {
  def main(args: Array[String]) {
    // set up the streaming execution environment
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime)
    env.setParallelism(1)

    val props = new Properties
    props.put("bootstrap.servers", "localhost:9092")
//    props.put("zookeeper.connect", "localhost:2181")
    props.put("group.id", "metric-group")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer") //key 反序列化

    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("auto.offset.reset", "latest") //value 反序列化

    //kafka的consumer，test1是要消费的topic
    val kafkaSource = new FlinkKafkaConsumer[(String, String)]("streaming",new KafkaTuple2DeserializationSchema,props)
    //设置从最新的offset开始消费
    kafkaSource.setStartFromLatest()
    //自动提交offset
    kafkaSource.setCommitOffsetsOnCheckpoints(true)
    val stream: DataStream[(String, String)] = env.addSource(kafkaSource)
    val counts = stream.map{
        x => x._2
      }
      .flatMap(x => x.split(" "))
      .map { (_, 1) }
      .keyBy(0)
      .window(SlidingEventTimeWindows.of(Time.seconds(4), Time.seconds(2)))
      .reduce{(e1, e2) => (e1._1, e1._2 + e2._2)}
      .print()

    env.execute("Flink Streaming Scala API Skeleton")
  }
}
