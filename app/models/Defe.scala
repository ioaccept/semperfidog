package models

/**
  * User entity.
  *
  * @param id   database id of the user.
  * @param name name of the user.
  */
case class Defe(var id: BigDecimal, var name: String, var hturm: BigDecimal, var sturm: BigDecimal, var ragna: BigDecimal,
                var pturm: BigDecimal, var hand: BigDecimal, var wturm: BigDecimal, var balisten: BigDecimal,
                var antimagie: BigDecimal, var relikt: BigDecimal, var stern: BigDecimal,

                var gesamt: BigDecimal) {

  def getGesamt(): Unit = {
    this.gesamt = (hturm * 10) + (sturm * 4) + (ragna * 4) + (pturm * 2) + (hand * 2) + (wturm * 1) + (balisten * 1) + (antimagie * 1) + (relikt * 5) + stern
  }
}