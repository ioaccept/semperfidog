package dbaccess

import anorm.SQL
import play.api.Play.current
import play.api.db.DB
import anorm.NamedParameter.symbol
import models.{Defe, User}


/**
  * Data access object for user related operations.
  *
  * @author ob, scs
  */
trait DefDaoT {

  /**
    * Verteidigung hinzufügen
    */
  def addDef(defe: Defe): Defe = {
    DB.withConnection { implicit c =>
      val id: Option[Long] =
        SQL("insert into Vert (name, hturm, sturm, ragna, pturm, hand, wturm, balisten, antimagie, relikt, stern" +

          " gesamt) " +
          "values (({name}), ({hturm}), ({sturm}), ({ragna}), ({pturm}), ({hand}), ({wturm}), ({balisten}), ({antimagie}), ({relikt}), ({stern}) " +

          "({gesamt}))").on(
          'name -> defe.name, 'hturm -> defe.hturm, 'sturm -> defe.sturm, 'ragna -> defe.ragna, 'pturm -> defe.pturm,
          'hand -> defe.hand, 'wturm -> defe.wturm, 'balisten -> defe.balisten, 'antimagie -> defe.antimagie, 'relikt -> defe.relikt, 'stern -> defe.stern,

          'gesamt -> defe.gesamt).executeInsert()
      defe.id = id.get
    }
    defe
  }

  /**
    * Verteidigung ändern
    */
  def changeDef(defe: Defe): Defe = {
    DB.withConnection { implicit c =>
      val change =
        SQL("update Vert SET name = ({name}), hturm = ({hturm}), sturm = ({sturm}), ragna = ({ragna}), pturm = ({pturm}), hand = ({hand})," +
          "wturm = ({wturm}), balisten = ({balisten}), antimagie = ({antimagie}), relikt = ({relikt}), stern = ({stern}), " +
          "gesamt = ({gesamt})  where id = ({id})").on(
          'name -> defe.name, 'hturm -> defe.hturm, 'sturm -> defe.sturm, 'ragna -> defe.ragna, 'pturm -> defe.pturm,
          'hand -> defe.hand, 'wturm -> defe.wturm, 'balisten -> defe.balisten, 'antimagie -> defe.antimagie, 'relikt -> defe.relikt, 'stern -> defe.stern,

          'gesamt -> defe.gesamt, 'id ->defe.id).executeUpdate()
    }
    defe
  }

  /**
    * Alle Verteidigungen anzeigen
    */
  def showDef: List[Defe] = {
    DB.withConnection { implicit c =>
      val selectUsers = SQL("Select * from Vert Order by gesamt DESC;")
      val users = selectUsers().map(row => Defe(row[BigDecimal]("id"), row[String]("name"), row[BigDecimal]("hturm"),
        row[BigDecimal]("sturm"), row[BigDecimal]("ragna"), row[BigDecimal]("pturm"), row[BigDecimal]("hand"),
        row[BigDecimal]("wturm"), row[BigDecimal]("balisten"), row[BigDecimal]("antimagie"), row[BigDecimal]("relikt"), row[BigDecimal]("stern"),


        row[BigDecimal]("gesamt"))).toList
      users
    }
  }

  /**
    * Member Verteidigungen anzeigen
    */
  def showMemberDef(id: Long): List[Defe] = {
    DB.withConnection { implicit c =>
      val selectUsers = SQL("Select * from Vert where id = ({id});").on('id -> id)
      val users = selectUsers().map(row => Defe(row[BigDecimal]("id"), row[String]("name"), row[BigDecimal]("hturm"),
        row[BigDecimal]("sturm"), row[BigDecimal]("ragna"), row[BigDecimal]("pturm"), row[BigDecimal]("hand"),
        row[BigDecimal]("wturm"), row[BigDecimal]("balisten"), row[BigDecimal]("antimagie"), row[BigDecimal]("relikt"), row[BigDecimal]("stern"),


        row[BigDecimal]("gesamt"))).toList
      users
    }
  }
}
object DefDao extends DefDaoT
