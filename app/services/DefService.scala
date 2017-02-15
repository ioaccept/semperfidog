package services

import dbaccess.{DefDao, DefDaoT, UserDao, UserDaoT}
import models.{Defe, User}

/**
  * Service class for user related operations.
  *
  * @author ob, scs
  */
trait DefServiceT {

  val defDao: DefDaoT = DefDao

  /**
    * User hinzufügen
    */
  def addDef(vert: Defe): Defe = {
    // create User
    // persist and return User
    defDao.addDef(vert)
  }
  /**
    * Verteidigung ändern
    */
  def changeDef(vert: Defe): Defe = {
    // create User
    // persist and return User
    defDao.changeDef(vert)
  }
  /**
    * Alle Verteidigungen anzeigen
    */
  def showDef: List[Defe] = {
    defDao.showDef
  }

  /**
    * Verteidigung von Member anzeigen
    */
  def showMemberDef(id: Long): List[Defe] = {
    defDao.showMemberDef(id)
  }

}

object DefService extends DefServiceT
