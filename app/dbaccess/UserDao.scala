package dbaccess

import anorm.SQL
import play.api.Play.current
import play.api.db.DB
import anorm.NamedParameter.symbol
import models.{Punkte, User}


/**
  * Data access object for user related operations.
  *
  * @author ob, scs
  */
trait UserDaoT {

  /**
    * User hinzufügen
    */
  def addUser(user: User): User = {
    DB.withConnection { implicit c =>
      val id: Option[Long] =
        SQL("insert into Users(name, password, mentor) values (({name}), ({password}), ({mentor}))").on(
          'name -> user.name, 'password -> user.password, 'mentor -> user.mentor).executeInsert()
      user.id = id.get
      SQL("insert into Vert (id, name, hturm, sturm, ragna, pturm, hand, wturm, balisten, antimagie, relikt, stern, gesamt) values (({id}), ({name}), " +
        "0 , 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0)").on('id -> user.id, 'name -> user.name).executeInsert()
      SQL("insert into Gott (userId, gott, passiv, erweckt, skill, skillE, gesamt) values (({userId}), 'gott', false, false, 0, 0, 0)").on('userId -> user.id).executeInsert()
      SQL("insert into Gott (userId, gott, passiv, erweckt, skill, skillE, gesamt) values (({userId}), 'gott', false, false, 0, 0, 0)").on('userId -> user.id).executeInsert()
      SQL("insert into Gott (userId, gott, passiv, erweckt, skill, skillE, gesamt) values (({userId}), 'gott', false, false, 0, 0, 0)").on('userId -> user.id).executeInsert()
      SQL("insert into Gott (userId, gott, passiv, erweckt, skill, skillE, gesamt) values (({userId}), 'gott', false, false, 0, 0, 0)").on('userId -> user.id).executeInsert()
    }
    user
  }

  /**
    * Löscht Member
    */
  def rmMember(id: Long): Boolean = {
    DB.withConnection { implicit c =>
      val rowsCount = SQL("delete from Users where id = ({id})").on('id -> id).executeUpdate()
      val rowsCount2 = SQL("delete from Vert where id = ({id})").on('id -> id).executeUpdate()
      val rowsCount3 = SQL("delete from Gott where userId = ({id})").on('id -> id).executeUpdate()
      rowsCount > 0
      rowsCount2 > 0
      rowsCount3 > 0
    }
  }

  /**
    * User anzeigen
    */
  def showUser: List[User] = {
    DB.withConnection { implicit c =>
      val selectUsers = SQL("Select * from Users;")
      val users = selectUsers().map(row => User(row[Long]("id"), row[String]("name"), row[String]("password"), row[Boolean]("mentor"))).toList
      users
    }
  }

  /**
    *
    */
def showPunkte: List[Punkte] = {
  DB.withConnection { implicit c =>
    val selectPunkte = SQL("Select U.id as uid, U.name as uname, MAX(V.gesamt) + SUM(G.gesamt) AS Gesamt from Users U, Vert V, Gott G where U.id = V.id and U.id = G.userId Group By U.id ORDER BY GESAMT DESC")
    val punkte = selectPunkte().map(row => Punkte(row[Long]("uid"), row[String]("uname"), row[BigDecimal]("Gesamt"))).toList
  punkte
  }
}
}

object UserDao extends UserDaoT
