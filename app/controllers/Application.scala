package controllers

import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("SemperFidelis"))
  }

  def error = Action {
    Ok(views.html.error("FehlerSeite"))
  }
}