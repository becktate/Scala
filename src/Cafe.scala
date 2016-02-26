/**
 * Created by Tate on 2/19/2016.
 */
class Cafe {

  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee()
    (cup, Charge(cc, cup.price))
  }

  def buyCoffees(cc: CreditCard, number: Int): (List[Coffee], Charge) = {
    val purchases: List[(Coffee, Charge)] = List.fill(number)(buyCoffee(cc))
    val (coffees, charges) = purchases.unzip
    (coffees, charges.reduce((c1, c2) => c1.combine(c2)))
  }
}

case class Charge(cc: CreditCard, amount: Double) {

  def combine(other: Charge) : Charge = {
    if (cc == other.cc)
      Charge(cc, amount + other.amount)
    else
      throw new Exception("Can't combine charges to different cards.")
  }
}

class CreditCard {
  def charge(price: Int): Unit = {}
}

class Coffee{
  def price = 3
}