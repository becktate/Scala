/**
 * Created by Tate on 2/19/2016.
 */
object ScalaApp {

  def main(args: Array[String]): Unit = {
    val cafe = new Cafe()
    val coffees = cafe.buyCoffees(new CreditCard(), 3)
    print(coffees)
  }


  def coalesce(charges: List[Charge]) : List[Charge] = {
    charges.groupBy(_.cc).values.map(_.reduce(_ combine _)).toList
  }
}
