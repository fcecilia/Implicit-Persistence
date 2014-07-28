package persistence.layout

import persistence.{IdGenAbstract, PersistenceLayoutActionAbstract}

import scala.collection.mutable
import scala.runtime.Nothing$


trait MapPersistenceKeyValueLayout {

  var map = scala.collection.mutable.Map.empty[String, Any]

  def all = map.toList

  def byId(id: String) = map.get(id)

  implicit class MapPersistence[E](obj: E)(implicit gen: IdGenAbstract[E]) extends PersistenceLayoutActionAbstract[E]  {

    def save: E = {
      map += (gen.id(obj) -> obj)
      obj
    }

    def update: E = {
      map += (gen.id(obj) -> obj)
      obj
    }

    def delete: E = {

      map -= gen.id(obj)
      obj
    }

  }



}

trait MapPersistenceCollectionLayout {


  var collections = scala.collection.mutable.Map.empty[String, scala.collection.mutable.Map[String, Any]]

  def collectionName[E](a: Class[E]) =
    a.getSimpleName

  def byId[E](id: String)(implicit m: Manifest[E]): Option[E] =
    m match {
      case n: Nothing$ => None
      case _ => fromCollection(m, id)
    }

  def fromCollection[E](m: Manifest[E], id: String): Option[E] = {
    val collections1 = collections.get(getName(m))
    collections1.flatMap(_.get(id)) match {
      case opt: Option[E] => opt
      case _ => None
    }
  }

  def getName[E](m: Manifest[E]): String = {
    m.runtimeClass.getSimpleName
  }

  def all = collections.toList

  def collection[E](implicit m: Manifest[E]) = collections(getName(m)).toList


  implicit class MapPersistence[E](obj: E)(implicit gen: IdGenAbstract[E]) extends PersistenceLayoutActionAbstract[E]{

    val colName: String = collectionName(obj.getClass)

    private def getMap: mutable.Map[String, Any] = {

      val empty: mutable.Map[String, Any] = mutable.Map.empty[String, Any]
      collections.getOrElse(colName, empty)
    }

    def save = {

      val map = getMap += (gen.id(obj) -> obj)

      collections += colName -> map

      obj
    }

    def update = {

      val map = getMap += (gen.id(obj) -> obj)
      collections += colName -> map
      obj
    }

    def delete = {

      val map = getMap -= gen.id(obj)
      collections += colName -> map
      obj
    }

  }

}