
package helpers

import java.io.File
import org.apache.commons.io.FileUtils
import org.apache.spark._
import org.scalatest._

trait SparkHelper extends Suite with BeforeAndAfterEach with BeforeAndAfterAll {
  System.setProperty("hadoop.home.dir", "c:\\winutils")
  val conf = new SparkConf().setMaster(
    "local[*]"
  ).setAppName(
    "spark-test"
  )

  lazy val context: SparkContext = SparkContext.getOrCreate(conf)

  override def beforeEach() = {
    try {
      FileUtils.deleteDirectory(new File("./tmp/samples"))
    } catch {
      case e: Exception => {}
    }

    FileUtils.forceMkdir(new File("./tmp/samples"))
    FileUtils.copyDirectoryToDirectory(new File("./src/test/samples"), new File("./tmp/"))
  }

  override def afterEach() = {
    FileUtils.deleteDirectory(new File("./tmp/samples"))
  }
}
