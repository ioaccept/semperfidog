package controllers

import forms.ChangeVertForm
import models.Defe
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, AnyContent, Controller}
import services.{DefService, GottService, UserService}

/**
  * Controller for user specific operations.
  *
  * @author ob, scs
  */
object DefController extends Controller {

  /**
    * Form object for user data.
    */
  val userForm = Form(
    mapping(
      "id" -> longNumber,
      "name" -> text,
      "hturm" -> bigDecimal,
      "sturm" -> bigDecimal,
      "ragna" -> bigDecimal,
      "pturm" -> bigDecimal,
      "hand" -> bigDecimal,
      "wturm" -> bigDecimal,
      "balisten" -> bigDecimal,
      "antimagie" -> bigDecimal,
      "relikt" -> bigDecimal,
      "stern" -> bigDecimal
    )
    (ChangeVertForm.apply)(ChangeVertForm.unapply))

  /**
    * Verteidung hinzufügen
    *
    * @return Seite Vert
    */
  def addDef: Action[AnyContent] = Action { implicit request =>
    userForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.error("Fehler"))
      },
      userData => {
        val vert = new Defe(-1, userData.name, userData.hturm, userData.sturm, userData.ragna, userData.pturm, userData.hand, userData.wturm, userData.balisten, userData.antimagie, userData.relikt, userData.stern,

          0)
        vert.getGesamt()
        services.DefService.addDef(vert)
        Redirect(routes.DefController.showDef())
      })
  }

  /**
    * Verändert Vert
    *
    * @return
    */
  def changeDef: Action[AnyContent] = Action { implicit request =>
    userForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.error("Fehler"))
      },
      userData => {
        val vert = new Defe(userData.id, userData.name, userData.hturm, userData.sturm, userData.ragna, userData.pturm, userData.hand, userData.wturm, userData.balisten, userData.antimagie, userData.relikt, userData.stern,

          null)
        vert.getGesamt()
        services.DefService.changeDef(vert)
        Redirect(routes.DefController.showMemberDef(userData.id.toString))
      })
  }

  /**
    * Zeigt alle Verteidigungen
    */
  def showDef: Action[AnyContent] = Action { request =>
    val mentor = request.session.get("mentor").isDefined
    val member = request.session.get("member").isDefined
    if (mentor) {
      Ok(views.html.aufstellung(DefService.showDef, UserService.showPunkte))
    } else if(member) {
      Ok(views.html.aufstellungMember(DefService.showDef, UserService.showPunkte))
    }
    else {
      Unauthorized("FehlerSeite")
    }
  }


  /**
    * Zeigt nur Verteidigungen von einem Member
    */
  def showMemberDef(id: String): Action[AnyContent] = Action {request =>
    val mentor = request.session.get("mentor").isDefined
    val member = request.session.get("member").isDefined
    if (mentor) {
      Ok(views.html.changeVert(DefService.showMemberDef(id.toLong), GottService.showGott(id.toLong))).flashing("success" -> "Mentor eingeloggt")
    } else if (member) {
      val memberID = request.session.get("id").get.toLong
      Ok(views.html.changeVertMember(DefService.showMemberDef(memberID), GottService.showGott(memberID)))
    }
    else {
      Unauthorized("FehlerSeite")
    }
  }

}