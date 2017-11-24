package services

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD



class WordCount() {


  def splitFile(lines: RDD[String]):RDD[String]={

      lines.flatMap(line => line.split(" "))


  }

  def countWords(words: RDD[String]): RDD[(String, Int)] = {
    words.map(word => (word, 1)).reduceByKey(_ + _)
  }

  def countWordsInFile = splitFile _ andThen countWords _

}





