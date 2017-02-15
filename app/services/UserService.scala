package services

import dbaccess.{UserDao, UserDaoT}
import models.{Punkte, User}

/**
  * Service class for user related operations.
  *
  * @author ob, scs
  */
trait UserServiceT {

  val userDao: UserDaoT = UserDao

  /**
    * User hinzufügen
    */
  def addUser(name: String, password: String, mentor: Boolean): User = {
    // create User
    val newUser = User(-1, name, password, mentor)
    // persist and return User
    userDao.addUser(newUser)
  }

  def rmMember(id: Long): Boolean = userDao.rmMember(id)

  /**
    * User anzeigen
    */
  def showUsers: List[User] = {
    userDao.showUser
  }

  def showPunkte: List[Punkte] = {
    userDao.showPunkte
  }
}

object UserService extends UserServiceT
