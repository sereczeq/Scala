case class Person(firstName : String, lastName :String) extends Ordered[Person]
{
	override def compare(that: Person) = if((this.lastName compare that.lastName) == 0) this.firstName compare that.lastName
																						else this.lastName compare that.lastName;

	override def equals(that: Any) = that.isInstanceOf[Person] && this.compare(that.asInstanceOf[Person]) == 0
}

val list : List[Person] = List(Person("Benny", "Beckett"), Person("Charles", "Curly"), Person("Arnold", "Anderson"), Person("David", "Davidson"))
list.sorted