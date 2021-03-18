package source

import org.apache.spark.SparkConf

import org.apache.kafka.common.serialization.StringDeserializer
//import org.apache.log4j.{Level, Logger}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe

object KafkaSource {
//  Logger.getLogger("source").setLevel(Level.ERROR)
// spark　ui 默认 http://30.73.164.137:4040/jobs/
  def init(): Unit = {
  }

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[4]").setAppName("kafka_words_count")
    conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    val ssc = new StreamingContext(conf, Seconds(1))
    //初始kafka
    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "localhost:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "use_a_separate_group_id_for_each_stream",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (false: java.lang.Boolean)
    )
    val topics = Array("streaming")
    val stream = KafkaUtils.createDirectStream[String, String](
      ssc,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParams)
    )
//    stream.print()
//    stream.map(record =>(record.key, record.value)).print()
    stream.map(record => (record.value()))
          .flatMap(value => {value.split(" ")})
          .map((_,1))
          .reduceByKeyAndWindow((v1:Int, v2:Int)=>{v1 + v2},Seconds(4),Seconds(2))
          .print()


    ssc.start()
    ssc.awaitTermination()
    ssc.stop()
  }
}
