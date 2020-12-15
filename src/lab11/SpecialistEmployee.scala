package lab11

class SpecialistEmployee(surname: String,
                         firstName: String,
                         salary: Int,
                         var bonus: Int)
	extends Employee(surname, firstName, salary)
{
	def raiseBonus(howMany: Int): Unit =
	{
		bonus += howMany
	}


	override def toString = s"SpecialistEmployee(surname=$surname, firstName=$firstName, salary=$salary, bonus=$bonus)"
}
