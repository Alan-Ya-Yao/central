import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}


object RDD_DF_DS_Transform {

  def main(args: Array[String]): Unit = {

    //    //创建SparkConf并设置App名称
    val conf = new SparkConf().setAppName("wc").setMaster("local[*]")
    //
    //    //创建SparkContext，该对象是提交Spark App的入口
    val sc = new SparkContext(conf)

    //    创建spark session
    val spark = SparkSession.builder().config(conf).getOrCreate()


    /**
     *  rdd 转 data frame 和 data set
     * */
    val rdd = sc.textFile("../central/spark-sql/src/main/resources/people.txt") // RDD[String]
    import spark.implicits._ //导入 rdd 到 ds 隐式转化

    val rdd2 = rdd.map{x => val pa = x.split(",");(pa(0), pa(1))} //RDD[(String, String)]
    val df = rdd2.toDF("name", "age") //DataFrame[name: string, age: string]
    df.show()

    var tmpRdd = rdd.map{x => val pa = x.split(",");People(pa(0).trim, pa(1).trim.toLong)} //RDD[People]
    val ds = tmpRdd.toDS //DataSet[name:strintg, age: bigint]
    ds.show()



  }

  case class People(name:String, age:Long)

}
