package com.sparkdemo.spark_operator_practice

import org.apache.spark.{SparkConf, SparkContext}

object UnderScoreOperation {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("flatmap").setMaster("local[*]")
    //
    //    //创建SparkContext，该对象是提交Spark App的入口
    val sc = new SparkContext(conf)

    // use the flatmap to implement map functionality
    val rdd = sc.makeRDD(Array(1,2,3,4,5))
    rdd.repartition(1).map((_,1)).map(x=>(x._1, x._2 *2)).foreach(print) //(1,2)(2,2)(3,2)(4,2)(5,2)
    rdd.repartition(1).map((_,1)).mapValues(_*2).foreach(print) //(1,2)(2,2)(3,2)(4,2)(5,2)
    rdd.repartition(1).map((_,1)).mapValues(x=>x*2).foreach(print) //(1,2)(2,2)(3,2)(4,2)(5,2)
  }

}
