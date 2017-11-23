
package services

import helpers._
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.scalatest._
import scala.reflect._
import scala.util.matching.Regex
import scaldi.Module

class FileClonerSpec extends WordSpec with SparkHelper {
  Logger.getLogger("org").setLevel(Level.WARN)
  Logger.getLogger("akka").setLevel(Level.WARN)

  ".call" when {
    def result(inputPath: String, outputPath: String): FileClonerResults = {
      new FileClonerImpl().call(
        context = context, // use context provided by SparkHelper
        inputPath = inputPath,
        outputPath = outputPath
      )
    }

    "valid params are given" should {
      val inputPath = "./tmp/samples/my.bucket/"
      val outputPath = "./tmp/samples/output.bucket/"

      "not throw an exception" in {
        result(inputPath = inputPath, outputPath = outputPath)
      }

      "read the expected number of lines" in {
        val state = result(inputPath = inputPath, outputPath = outputPath)
        assert(state.lines.count() == 1)
      }

      "write the expected number of lines" in {
        result(inputPath = inputPath, outputPath = outputPath)
        val lines = context.textFile(outputPath)
        assert(lines.count() == 1)
      }
    }
  }
}
