package loaddata

import java.sql.Statement

import showdata.ShowPartition

class InsertDataQuery(val cStatement: Statement){
  println("*****Please wait... Data is inserting into a Table(EnrichedTrip)*****")
  cStatement.execute(getSqlQuerey)
  println("*****Data has loaded*****")
  new ShowPartition(cStatement)
  cStatement.close()
  def getSqlQuerey:String={
    val query: String="INSERT OVERWRITE TABLE fall2019_aman.scala_enriched_trips PARTITION (wheel_chair_accessible) " +
      "SELECT  T.route_id,T.service_id,T.trip_id,T.trip_head_sign,T.direction_id,T.shape_id,T.note_fr,T.note_en, "+
      "C.date,C.exception_type,F.start_time,F.end_time,F.headway_secs,T.wheel_chair_accessible "+
      "FROM fall2019_aman.scala_ext_trips T LEFT JOIN fall2019_aman.scala_ext_calendar_dates C "+
      "ON C.service_id=T.service_id LEFT JOIN fall2019_aman.scala_ext_frequencies F ON F.trip_id=T.trip_id"
    query
  }
}