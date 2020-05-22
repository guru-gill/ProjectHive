package showdata

import java.sql.{ResultSet, Statement}

class ShowPartition(val cStatement: Statement){

  val res1: ResultSet = cStatement.executeQuery("SHOW PARTITIONS fall2019_aman.scala_enriched_trips")
  while (res1.next()) {
    println("*****Partitions*****: " + res1.getString(1))
  }

  println("*************************************************************************")

  val res2: ResultSet = cStatement.executeQuery("SELECT COUNT(*) FROM fall2019_aman.scala_enriched_trips")
  while (res2.next()) {
    println("*****Total Records*****: " + res2.getString(1))
  }

  println("*************************************************************************")

  val res: ResultSet = cStatement.executeQuery("SELECT * FROM fall2019_aman.scala_enriched_trips "+
    "Where wheel_chair_accessible=1 "+
    "LIMIT 10")
  while (res.next()) {
    println("RouteId: " + res.getInt(1) +" ServiceId: "+ res.getString(2)+
      " TripId: "+res.getString(3)+" TripHeadSign: "+res.getString(4)+
      " DirectionId: "+res.getInt(5)
      +" ShapeId: "+res.getInt(6)+" NoteFr: "+res.getString(7)+" NoteEn: "+res.getString(8)+
      " Date: "+res.getInt(9)+" ExceptionType:"+res.getInt(10)+" StartTime: "+res.getString(11)+
      " EndTime: "+res.getString(12)+" HeadwaySecs: "+res.getInt(13))
  }
  cStatement.close()
}
