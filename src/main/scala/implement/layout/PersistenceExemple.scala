package implement.layout

import implement.idgen.{IdGenImplicitFee, IdGenFoo2, IdGenFoo}
import implement.model.Fee
import persistence.Persistence.IdGenPersisted
import persistence.layout.{MapPersistenceCollectionLayout, MapPersistenceKeyValueLayout}

/**
 * Created by fred on 25/07/2014.
 */

object PersistenceKeyValue extends MapPersistenceKeyValueLayout {

  implicit object IdGenFoo extends IdGenFoo

  implicit object IdGenFoo2 extends IdGenFoo2

  implicit object IdGenFee extends IdGenPersisted[Fee]

  implicit object IdFee extends IdGenImplicitFee

}



object PersistenceCollection extends MapPersistenceCollectionLayout {

  implicit object IdGenFoo extends IdGenFoo

  implicit object IdGenFoo2 extends IdGenFoo2

  implicit object IdGenFee extends IdGenPersisted[Fee]


}
