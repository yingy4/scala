
package services

import org.apache.spark.rdd.RDD
import org.apache.spark.SparkContext

trait FileCloner {
  def call(context: SparkContext,
           inputPath: String,
           outputPath: String): FileClonerResults
}

case class FileClonerResults(
                              lines: RDD[String]
                            )

class FileClonerImpl() extends FileCloner {
  def call(context: SparkContext,
           inputPath: String,
           outputPath: String): FileClonerResults = {
    val lines = context.textFile(inputPath)
    lines.saveAsTextFile(outputPath)

    return FileClonerResults(
      lines = lines
    )
  }
}
