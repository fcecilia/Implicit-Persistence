package exemples

import implement.layout.PersistenceCollection
import implement.layout.PersistenceCollection._
import implement.model.{Foo, Foo2}

/**
  * Created by fred on 01/06/2014.
  */
object Lab2 extends App{

  val foo= Foo("1","toto","titi")

   println(all)

   foo.save

   println(all)

  val foo2 = Foo2("1", "toto2", "titi2")

  foo2.save

  println(all)


  println(collection[Foo])

  println(collection[Foo2])

  println(byId[Foo2]("1"))

  println(byId[Foo2]("10"))

}
