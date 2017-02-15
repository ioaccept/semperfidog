package controllers

import forms.GottForm
import models.Gott
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, AnyContent, Controller}


/**
  * Controller for user specific operations.
  *
  * @author ob, scs
  */
object GottController extends Controller {

  /**
    * Form object for user data.
    */
  val gottForm = Form(
    mapping(
      "gottId" -> longNumber,
      "userId" -> bigDecimal,
      "gott" -> text,
      "passiv" -> boolean,
      "erweckt" -> boolean,
      "skill" -> bigDecimal,
      "skillE" -> bigDecimal

    )
    (GottForm.apply)(GottForm.unapply))

  /**
    * Verteidung hinzufügen
    *
    * @return Seite Vert
    */
  def addGott: Action[AnyContent] = Action { implicit request =>
    gottForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.error("Fehler"))
      },
      userData => {
        val gott = new Gott(-1, userData.userId, userData.gott, userData.passiv, userData.erweckt, userData.skill, userData.skillE,
          0)
        gott.getGesamt()
        services.GottService.addGott(gott)
        Redirect(routes.DefController.showDef())
      })
  }
  /**
    * Gott ändern
    *
    * @return ChangeVert
    */
  def changeGott: Action[AnyContent] = Action { implicit request =>
    gottForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.error("Fehler Gott"))
      },
      userData => {
        val gott = new Gott(userData.gottId, userData.userId, userData.gott, userData.passiv, userData.erweckt, userData.skill, userData.skillE,
          0)
        gott.getGesamt()
        services.GottService.changeGott(gott)
        Redirect(routes.DefController.showMemberDef(userData.userId.toString))
      })
  }
}