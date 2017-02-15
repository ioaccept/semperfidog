package models

/**
  * User entity.
  *
  * @param id       database id of the user.
  * @param name     name of the user.
  */
case class Punkte(var id: Long, var name: String, var punkte: BigDecimal)
