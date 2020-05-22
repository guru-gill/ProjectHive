package stmtables

import java.sql.Statement

class Trips(val cStatement: Statement) {

  cStatement.execute("DROP TABLE IF EXISTS fall2019_aman.scala_ext_trips")
  cStatement.execute(getSqlQuery)
  println("*****Trip Table Created*****")
  new CalendarDates(cStatement)
  cStatement.close()
  def getSqlQuery:String={
    val query: String="CREATE EXTERNAL TABLE fall2019_aman.scala_ext_trips (route_id INT,service_id " +
      " STRING,trip_id STRING,trip_head_sign STRING," +
      " direction_id INT,shape_id INT,wheel_chair_accessible INT,note_fr STRING,note_en String)" +
      " ROW FORMAT DELIMITED" +
      " FIELDS TERMINATED BY ','" +
      " STORED AS TEXTFILE " +
      " LOCATION '/user/fall2019/aman/project4/trips'" +
      " TBLPROPERTIES('skip.header.line.count' = '1'," +
      "'serialization.null.format'='')"
    query
  }
}