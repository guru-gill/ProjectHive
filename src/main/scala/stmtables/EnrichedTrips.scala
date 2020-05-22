package stmtables

import java.sql.Statement

import loaddata.InsertDataQuery

class EnrichedTrips(val cStatement: Statement)  {

  cStatement.execute("SET hive.mapred.mode=nonstrict")
  cStatement.execute("SET hive.exec.dynamic.partition.mode=nonstrict")
  cStatement.execute("DROP TABLE IF EXISTS fall2019_aman.scala_enriched_trips")
  cStatement.execute(getSqlQuery)
  println("*****Table EnrichedTrips Created*****")
  new InsertDataQuery(cStatement)
  cStatement.close()
  def getSqlQuery:String={
    val query: String="CREATE TABLE fall2019_aman.scala_enriched_trips( "+
      "route_id INT, " +
      "service_id STRING, " +
      "trip_id STRING, "+
      "trip_head_sign STRING," +
      "direction_id INT, "+
      "shape_id INT, "+
      "note_fr STRING, "+
      "note_en STRING, "+
      "date STRING, "+
      "exception_type INT, " +
      "start_time STRING, "+
      "end_time STRING, "+
      "headway_secs INT) " +
      "PARTITIONED BY(wheel_chair_accessible INT) " +
      "ROW FORMAT DELIMITED " +
      "FIELDS TERMINATED BY ','" +
      "STORED AS  PARQUET "+
      "TBLPROPERTIES('parquet.compression'= 'GZIP') "
    query
  }
}
