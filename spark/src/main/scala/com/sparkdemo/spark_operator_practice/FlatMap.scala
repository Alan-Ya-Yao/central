package com.sparkdemo.spark_operator_practice

import org.apache.spark.{SparkConf, SparkContext}

object FlatMap {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("flatmap").setMaster("local[*]")
    //
    //    //创建SparkContext，该对象是提交Spark App的入口
    val sc = new SparkContext(conf)

    // use the flatmap to implement map functionality
    val rdd = sc.makeRDD(Array(1,2,3,4,5))
    rdd.map(_+1).collect().foreach(x => print(x + "_"))
    rdd.flatMap(x => Array(x + 1)).collect().foreach(x => print(x + "_"))
    rdd.mapPartitionsWithIndex((x, y) => Iterator(x + ":" + y.mkString("|")))
  }
}
