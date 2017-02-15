package controllers

import forms.CreateUserForm
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, AnyContent, Controller}
import services.{DefService, UserService}

/**
  * Controller for user specific operations.
  *
  * @author ob, scs
  */
object UserController extends Controller {

  /**
    * Form object for user data.
    */
  val userForm = Form(
    mapping(
      "Name" -> text,
      "Password" -> text,
      "Mentor" -> boolean
    )
    (CreateUserForm.apply)(CreateUserForm.unapply))

  /**
    * User hinzufügen
    *
    * @return Seite Member
    */
  def addUser: Action[AnyContent] = Action { implicit request =>
    userForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.index("Fehler"))
      },
      userData => {
        services.UserService.addUser(userData.name, userData.password, userData.mentor)
        Redirect(routes.UserController.loginUser())

      })
  }

  def rmMember: Action[AnyContent] = Action { implicit request =>
    userForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.index("Fehler"))
      },
      userData => {
        val member = UserService.showUsers.find(
          _.name == userData.name
        ).head
        UserService.rmMember(member.id)
        Redirect(routes.UserController.loginUser())

      })
  }

  /**
    * Login Seite Mentor
    */
  def loginUser: Action[AnyContent] = Action { request =>
    val mentor = request.session.get("mentor").isDefined
    val member = request.session.get("member").isDefined
    if (mentor) {
      Ok(views.html.register(UserService.showUsers))
    } else if (member)
      Ok(views.html.aufstellungMember(DefService.showDef, UserService.showPunkte))
    else {
      Unauthorized("FehlerSeite")
    }
  }

  /**
    * User einloggen
    *
    * @return Seite Member
    */
  def login: Action[AnyContent] = Action { implicit request =>
    userForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.index("Fehler"))
      },
      userData => {
        val exists = UserService.showUsers.exists(_.name == userData.name)
        if (exists) {
          val user = UserService.showUsers.find {
            _.name == userData.name
          }.head
          if (user.password == userData.password) {
            if (user.mentor) {
              Redirect(routes.UserController.loginUser()) withSession("id" -> user.id.toString, "user" -> user.name, "mentor" -> "yes")
            } else {
              Redirect(routes.UserController.loginUser()) withSession("id" -> user.id.toString, "user" -> user.name, "member" -> "yes")
            }
          } else {
            Redirect(routes.Application.error)
          }
        } else
          Redirect(routes.Application.error)

      })
  }

  /**
    * Ausloggen
    *
    * @return Index Seite
    */
  def logout: Action[AnyContent] = Action {
    Ok(views.html.index("Semper Fidelis")).withNewSession
  }
}