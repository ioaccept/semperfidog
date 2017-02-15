package models

/**
  * User entity.
  */
case class Gott(var gottId: Long, var userId: BigDecimal, var name: String, var passiv: Boolean, var erweckt: Boolean, var skill: BigDecimal, var skillE: BigDecimal,

                var gesamt: BigDecimal) {

  def getGesamt(): Unit = {
    if(erweckt && passiv) {
      this.gesamt = 8 + skill + skillE
    } else if( erweckt && !passiv) {
      this.gesamt = 5 + skill + skillE
    } else {
      this.gesamt = 2 + skill
    }
  }
}