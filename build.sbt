name := "ProjectHive"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies += "org.apache.hive" % "hive-jdbc" % "1.1.0-cdh5.16.2"

resolvers += "cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"
