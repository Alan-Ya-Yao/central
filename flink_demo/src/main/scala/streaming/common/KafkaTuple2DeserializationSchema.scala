package streaming.common

import org.apache.flink.api.common.typeinfo.TypeInformation
import org.apache.flink.streaming.connectors.kafka.KafkaDeserializationSchema
import org.apache.kafka.clients.consumer.ConsumerRecord


class KafkaTuple2DeserializationSchema extends KafkaDeserializationSchema[(String, String)] {
  /**
   * 用来判断该元素是否为流中的最后一个元素，如果返回true，则会结束发射数据<br>
   * 直接返回false，使其一直发射数据，毕竟要用于流式处理
   *
   * @param nextElement 下一个反序列化完毕的元素
   * @return
   */
  override def isEndOfStream(nextElement: (String, String)): Boolean = {
    false
  }

  /**
   * 反序列化函数，用于将读取到的kafka record封装为需要的对象并返回给flink-source
   *
   * @param record kafka record消息
   * @return 二元组，数据分别为key、value
   */
  override def deserialize(record: ConsumerRecord[Array[Byte], Array[Byte]]): (String, String) = {
    (new String(record.key()), new String(record.value()))
  }

  /**
   * 获取该反序列化器泛型的的类型信息
   *
   * @return 该反序列化器泛型的的类型信息
   */
  override def getProducedType: TypeInformation[(String, String)] = {
    TypeInformation.of(classOf[(String, String)])
  }
}