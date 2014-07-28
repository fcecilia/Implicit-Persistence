package exemples

import implement.layout.PersistenceKeyValue._
import implement.model.Fee
import persistence.Persistence._


/**
 * Created by fred on 01/06/2014.
 */
object Lab3 extends App {

  def printFee(f: Fee) = println(f)


  val fee = Fee("toto")

  val feep = Persisted(fee).save


  println(all)

  printFee(feep)

  println(byId(feep.id))


}
