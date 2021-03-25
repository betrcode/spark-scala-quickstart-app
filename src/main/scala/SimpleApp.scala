/* SimpleApp.scala */

import org.apache.spark.sql.SparkSession

object SimpleApp {
  def main(args: Array[String]) {
    val logFile = "./src/main/resources/pg10.txt" // Should be some file on your system
    val spark = SparkSession.builder.appName("Simple Application")
      .config("spark.master", "local")
      .getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val countsMap = collection.mutable.Map[String, Long]()
    for (argument <- args) {
      countsMap.put(argument, logData.filter(line => line.toLowerCase.contains(argument)).count())
    }
    println(countsMap)
    spark.stop()
  }
}