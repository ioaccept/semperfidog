package services

import dbaccess._
import models.{Defe, Gott, User}

/**
  * Service class for user related operations.
  *
  * @author ob, scs
  */
trait GottServiceT {

  val gottDao: GottDaoT = GottDao

  /**
    * User hinzufügen
    */
  def addGott(gott: Gott): Gott = {
    // create User
    // persist and return User
    gottDao.addGott(gott)
  }

  /**
    * Götter zeigen
    */
  def showGott(id: BigDecimal): List[Gott] = {
  gottDao.showGott(id)
  }

  /**
    * Götter veränder
    */
  def changeGott(gott:Gott): Gott = {
    gottDao.changeGott(gott)
  }
}

object GottService extends GottServiceT
