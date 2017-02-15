package forms

/**
  * Form containing data to create a user.
  *
  */

case class GottForm(gottId: Long, userId: BigDecimal, gott: String, passiv: Boolean, erweckt: Boolean, skill: BigDecimal, skillE: BigDecimal)
