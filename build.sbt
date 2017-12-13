
lazy val root = (project in file("."))
  .settings(
    name         := "sparkproject",
    organization := "edu.trinity",
    scalaVersion := "2.11.8",
    version      := "0.1.0-SNAPSHOT",
    libraryDependencies += "org.scalafx" % "scalafx_2.11" % "8.0.102-R11",
    libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.2.0",
    libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.2.0",
    libraryDependencies += "org.apache.spark" % "spark-mllib_2.11" % "2.2.0",
    libraryDependencies += "org.apache.spark" % "spark-graphx_2.11" % "2.2.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.0" % "test",
      libraryDependencies += "org.scaldi" %% "scaldi" % "0.5.8" ,
      libraryDependencies +="com.esri.geometry" % "esri-geometry-api" % "1.2.1",
        libraryDependencies +="io.circe" %% "circe-core_2.12" % "0.7.1",
libraryDependencies +="io.circe" %% "circe-generic_2.12" % "0.7.1",
libraryDependencies +="io.circe" %% "circe-parser_2.12" % "0.7.1",

libraryDependencies +="org.slf4j" % "slf4j-api" % "1.7.21",
libraryDependencies +="org.slf4j" % "slf4j-log4j12" % "1.7.21",
libraryDependencies +="com.twitter" %% "util-core_2.11" % "6.34.0",
libraryDependencies +="org.typelevel" % "cats-core_2.11" % "0.7.2",
libraryDependencies +="harsha2010" % "magellan" % "1.0.4-s_2.11"
	


  )

        