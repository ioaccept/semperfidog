package forms

/**
  * Form containing data to create a user.
  *
  * @param name username
  */

case class ChangeVertForm(id: Long, name: String, hturm: BigDecimal, sturm: BigDecimal, ragna: BigDecimal,
                          pturm: BigDecimal, hand: BigDecimal, wturm: BigDecimal, balisten: BigDecimal,
                          antimagie: BigDecimal, relikt: BigDecimal, stern: BigDecimal)
