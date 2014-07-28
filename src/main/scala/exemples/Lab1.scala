package exemples

import implement.layout.PersistenceKeyValue._
import implement.model.{Foo, Foo2}


/**
 * Created by fred on 01/06/2014.
 */
object Lab1 extends App {


  val foo = Foo("1", "toto", "titi")

  println(all)

  foo.save

  println(all)


  val foo2 = Foo2("2", "toto2", "titi2")

  foo2.save

  println(all)

  println(byId("1"))

  println(byId("10"))

  println(byId("10"))

}
