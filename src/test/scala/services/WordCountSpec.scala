
package services

import helpers._
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest._



class WordCountSpec extends FunSuite with Matchers with BeforeAndAfterAll {


  Logger.getLogger("org").setLevel(Level.WARN)
  Logger.getLogger("akka").setLevel(Level.WARN)

  System.setProperty("hadoop.home.dir", "c:\\winutils")
  val conf = new SparkConf().setMaster(
    "local[*]"
  ).setAppName(
    "spark-test"
  )

  lazy val sparkContext: SparkContext = SparkContext.getOrCreate(conf)



  override def afterAll() {
    sparkContext.stop()
  }


  val fileLines = Array("Line One", "Line Two", "Line Three", "Line Four")

  test("splitFile should split the file into words") {
    val inputRDD: RDD[String] = sparkContext.parallelize[String](fileLines)
    val WordCount=new WordCount()
    val wordsRDD = WordCount.splitFile(inputRDD)
    wordsRDD.count() should be (8)
  }


  test("countWords should count the occurrences of each word"){
    val words = Array("word", "count", "example", "word")
    val inputRDD: RDD[String] = sparkContext.parallelize[String](words)
    val WordCount=new WordCount()
    val wordCounts = WordCount.countWords(inputRDD).collect
    wordCounts should contain ("word", 2)
    wordCounts should contain ("count", 1)
    wordCounts should contain ("example", 1)
  }


  test("countWordsInFile should count words") {
    val inputRDD: RDD[String] = sparkContext.parallelize[String](fileLines)
    val WordCount=new WordCount()
    val results = WordCount.countWordsInFile(inputRDD).collect
    results should contain ("Line", 4)
  }


}