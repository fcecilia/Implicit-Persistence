package persistence


/**
 * Created by fred on 13/06/2014.
 */

object Persistence {

  case class Persisted[E](id: String, data: E)

  object Persisted {

    def apply[E](data: E) = {

      new Persisted[E](generate_ID_RandomUUID, data)
    }

    def generate_ID_RandomUUID: String = java.util.UUID.randomUUID.toString.replace("-", "")

    implicit def persistence2Data[E](p: Persisted[E]): E = p.data

  }

  trait IdGenPersisted[E] extends IdGenAbstract[Persisted[E]] {

    def id(feeP:Persisted[E]):String =  feeP.id

  }


}