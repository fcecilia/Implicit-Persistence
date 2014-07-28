package implement.idgen

import implement.model.{Fee, Foo, Foo2}
import persistence.IdGenAbstract
import persistence.Persistence.Persisted

/**
 * Created by fred on 09/06/2014.
 */


trait IdGenFoo extends IdGenAbstract[Foo] {
  def id(foo: Foo): String = foo.id
}

trait IdGenFoo2 extends IdGenAbstract[Foo2] {
  def id(foo: Foo2): String = foo.id
}

trait IdGenImplicitFee extends IdGenAbstract[Fee] {
  def id(foo: Fee): String = Persisted(foo).id
}




