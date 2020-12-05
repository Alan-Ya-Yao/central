import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object SparkSqlDemo {

  def main(args: Array[String]): Unit = {
    //    创建SparkConf并设置App名称
    val conf = new SparkConf().setAppName("wc").setMaster("local[*]")

    //    创建spark session
    val spark = SparkSession.builder().config(conf).getOrCreate()

    // 定义dataframe
    val df = spark.read.json("../central/spark-sql/src/main/resources/people.json")

    //展示所有数据
    df.show()


    //DSL 风格操作 dataframe
    df.select("name").show()

    //sql 风格操作 dataframe
    df.createTempView("people")
    spark.sql("select * from people").show()

    spark.close()
  }
}
