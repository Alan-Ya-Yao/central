package com.sparkdemo

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def init(): Unit ={
    print("initing");
  }

  def main(args: Array[String]): Unit = {

    init();
//    //创建SparkConf并设置App名称
    val conf = new SparkConf().setAppName("wc").setMaster("local[*]")
//
//    //创建SparkContext，该对象是提交Spark App的入口
    val sc = new SparkContext(conf)

    //使用sc创建RDD并执行相应的transformation和action
    sc.textFile("../central/spark/src/main/resources/wordcount.txt")
      .flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _, 1)
      .sortBy(_._2, true)
      .foreach(println)

    sc.stop()

  }


}
