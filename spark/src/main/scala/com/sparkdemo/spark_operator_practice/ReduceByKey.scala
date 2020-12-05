package com.sparkdemo.spark_operator_practice

import org.apache.spark.{SparkConf, SparkContext}

object ReduceByKey {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("reduceByKey").setMaster("local[*]")
    //
    //    //创建SparkContext，该对象是提交Spark App的入口
    val sc = new SparkContext(conf)

    // use the flatmap to implement map functionality
    val rdd = sc.makeRDD(Array(1,1,3,4,4,4,4))
    rdd.map((_,1)).reduceByKey((v1, v2) => (v1 + v2)/2).collect().foreach(println)
  }

}
