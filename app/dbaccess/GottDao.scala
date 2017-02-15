package dbaccess

import anorm.SQL
import play.api.Play.current
import play.api.db.DB
import anorm.NamedParameter.symbol
import models.{Defe, Gott, User}


/**
  * Data access object for user related operations.
  *
  * @author ob, scs
  */
trait GottDaoT {

  /**
    * Verteidigung hinzufügen
    */
  def addGott(gott: Gott): Gott = {
    DB.withConnection { implicit c =>
      val id: Option[Long] =
        SQL("insert into Gott (userId, name, passiv, erweckt, skill, skillE," +
          " gesamt) " +
          "values (({id}), ({name}), ({passiv}), ({erweckt}), ({skill}), ({skillE})" +

          "({gesamt}))").on(
          'userId -> gott.userId, 'name -> gott.name, 'passiv -> gott.passiv, 'skill -> gott.skill, 'skillE -> gott.skillE,


          'gesamt -> gott.gesamt).executeInsert()
      gott.gottId = id.get
    }
    gott
  }


  /**
    * Götter von Member zeigen
    */
  def showGott(id: BigDecimal): List[Gott] = {
    DB.withConnection { implicit c =>
      val selectGotts = SQL("Select * from Gott where userId = ({userId});") on ('userId -> id)
      val gott = selectGotts().map(row => Gott(row[Long]("gottId"), row[BigDecimal]("userId"), row[String]("gott"), row[Boolean]("passiv"),
        row[Boolean]("erweckt"), row[BigDecimal]("skill"), row[BigDecimal]("skillE"),

        row[BigDecimal]("gesamt"))).toList
      gott
    }
  }

  /**
    * Götter von Member veränder
    */
  def changeGott(gott: Gott): Gott = {
    DB.withConnection { implicit c =>
      val changeGotts = SQL("update Gott SET gott = ({gott}), passiv = ({passiv}), erweckt = ({erweckt}), skill = ({skill}), skillE = ({skillE}), gesamt = ({gesamt}) " +
        "where gottId = ({gottId});").on('gott -> gott.name, 'passiv -> gott.passiv, 'erweckt -> gott.erweckt, 'skill -> gott.skill, 'skillE -> gott.skillE, 'gesamt -> gott.gesamt, 'gottId -> gott.gottId).executeUpdate()
    }
      gott
    }
}

object GottDao extends GottDaoT
