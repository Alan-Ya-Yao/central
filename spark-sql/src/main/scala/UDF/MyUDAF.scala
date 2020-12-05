package UDF

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Column, Row, SparkSession}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, DoubleType, LongType, StructField, StructType}

class MyUDAF extends UserDefinedAggregateFunction  {

  // 聚合函数输入参数的数据类型
  def inputSchema: StructType = StructType(StructField("inputColumn", LongType) :: Nil)

  // 聚合缓冲区中值得数据类型
  def bufferSchema: StructType = {
    StructType(StructField("sum", LongType) :: StructField("count", LongType) :: Nil)
  }

  // 返回值的数据类型
  def dataType: DataType = DoubleType

  // 对于相同的输入是否一直返回相同的输出。
  def deterministic: Boolean = true

  // 初始化
  def initialize(buffer: MutableAggregationBuffer): Unit = {
    // 总数之和buffer
    buffer(0) = 0L
    // 总个数
    buffer(1) = 0L
  }

  // 同一Execute间的数据合并,buffer与Row的合并
  def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    if (!input.isNullAt(0)) {
      buffer(0) = buffer.getLong(0) + input.getLong(0)
      buffer(1) = buffer.getLong(1) + 1
    }
  }

  // 不同Execute间的数据合并, buffer 与 buffer的合并
  def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
    buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
  }

  // 计算最终结果
  def evaluate(buffer: Row): Double = buffer.getLong(0).toDouble / buffer.getLong(1)

}

object MyUDAF{
  def main(args: Array[String]): Unit = {
    //    创建SparkConf并设置App名称
    val conf = new SparkConf().setAppName("wc").setMaster("local[*]")

    //    创建spark session
    val spark = SparkSession.builder().config(conf).getOrCreate()

    spark.udf.register("Average", new MyUDAF)

    val df = spark.read.json("../central/spark-sql/src/main/resources/people.json")
    df.createOrReplaceTempView("people")
    df.show()
    // +----+-------+
    //| age|   name|
    //+----+-------+
    //|null|Michael|
    //|  30|   Andy|
    //|  19| Justin|
    //+----+-------+

    val result = spark.sql("SELECT Average(age) as average_age FROM people")
    result.show()
    // +-----------+
    //|average_age|
    //+-----------+
    //|       24.5|
    //+-----------+

  }
}
