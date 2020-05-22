package stmtables

import java.sql.Statement

class CalendarDates(val cStatement: Statement) {
  cStatement.execute("DROP TABLE IF EXISTS fall2019_aman.scala_ext_calendar_dates")
  cStatement.execute(getSqlQuery)
  println("*****Table calendar_dates Created*****")
  new Frequencies(cStatement)
  cStatement.close()
  def getSqlQuery:String={
    val query: String="CREATE EXTERNAL TABLE fall2019_aman.scala_ext_calendar_dates (service_id " +
      "STRING,date STRING,exception_type INT) " +
      "ROW FORMAT DELIMITED "+
      "FIELDS TERMINATED BY ','" +
      "STORED AS TEXTFILE " +
      "LOCATION '/user/fall2019/aman/project4/calendar_dates' " +
      "TBLPROPERTIES('skip.header.line.count' = '1', " +
      "'serialization.null.format'='')"
    query
  }
}

