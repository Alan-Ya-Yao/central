import org.apache.spark.sql.SparkSession

object WordCount {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local").appName("WordCount").getOrCreate()
    val sc = spark.sparkContext

    val input = sc.parallelize(Seq("Spark Hive Kafka", "Hadoop Kafka Hive Hbase", "Java Scala Spark"))
    val words = input.flatMap(line => line.split(" "))
    val counts = words.map(word => (word, 1)).reduceByKey { (x, y) => x + y }
    println(counts.collect().mkString(","))
    val counts1 = words.mapPartitions(it => it.map(word => (word, 1))).reduceByKey { (x, y) => x + y }
    println(counts1.collect().mkString(","))

    spark.stop()

  }
}