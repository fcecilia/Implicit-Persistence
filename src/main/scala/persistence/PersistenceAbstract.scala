package persistence

/**
 * Created by fred on 25/07/2014.
 */


/**
 * Created by fred on 01/06/2014.
 */


abstract class IdGenAbstract[E] {

  def id(foo: E): String

}

abstract class PersistenceLayoutActionAbstract[E]{

  def save: E
  def update: E
  def delete: E

}
