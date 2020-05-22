package stmtables

import java.sql.Statement

class Frequencies(val cStatement: Statement) {
  cStatement.execute("DROP TABLE IF EXISTS fall2019_aman.scala_ext_frequencies")
  cStatement.execute(getSqlQuery)
  println("*****Table Frequencies Created*****")
  new EnrichedTrips(cStatement)
  cStatement.close()
  def getSqlQuery:String={
    val query: String="CREATE EXTERNAL TABLE fall2019_aman.scala_ext_frequencies (" +
      "trip_id STRING, start_time STRING," +
      "end_time STRING,headway_secs String)" +
      "ROW FORMAT DELIMITED "+
      "FIELDS TERMINATED BY ',' "+
      "STORED AS TEXTFILE "+
      "LOCATION '/user/fall2019/aman/project4/frequencies' " +
      "TBLPROPERTIES('skip.header.line.count' = '1', " +
      "'serialization.null.format'='')"
    query
  }
}
