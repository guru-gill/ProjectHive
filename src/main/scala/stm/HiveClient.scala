package stm

import java.sql.{Connection, DriverManager}

import stmtables.Trips

object HiveClient extends App{

  val hiveDriver: String = "org.apache.hive.jdbc.HiveDriver"
  Class.forName(hiveDriver)

  val connection: Connection = DriverManager.getConnection("jdbc:hive2://172.16.129.58:10000/aman;user=apple;password=apple")
  val cStatement = connection.createStatement()

  new Trips(cStatement)
  connection.close()
}
