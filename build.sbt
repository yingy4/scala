
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


libraryDependencies +="org.slf4j" % "slf4j-api" % "1.7.21",
libraryDependencies +="org.slf4j" % "slf4j-log4j12" % "1.7.21"


	


  )

        