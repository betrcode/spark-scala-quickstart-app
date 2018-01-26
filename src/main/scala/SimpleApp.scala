/* SimpleApp.scala */

import org.apache.spark.sql.SparkSession

object SimpleApp {
  def main(args: Array[String]) {
    val logFile = "./src/main/resources/pg10.txt" // Should be some file on your system
    val spark = SparkSession.builder
      .appName("Simple Application")
      .config("spark.master", "local")
      .getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numberOfGods = logData.filter(line => line.toLowerCase.contains("god")).count()
    val numberOfDevils = logData.filter(line => line.toLowerCase.contains("devil")).count()
    println(s"Lines with god: $numberOfGods, Lines with devil: $numberOfDevils")
    spark.stop()
  }
}