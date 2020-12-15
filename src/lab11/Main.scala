package lab11

object Main {

	def main(args: Array[String]): Unit = {
		// making a regular employee
		val john: Employee = new Employee("Kowalski", "John", 2500)
		println(john.toString)
		// making a specialist employee
		val tom: SpecialistEmployee =
			new SpecialistEmployee("Wick", "Thomas", 5400, 1000)
		println(tom.toString)
		// making a company
		val company: Company = new Company()
		company.addEmployee(new Employee("Pence", "Michael", 2000))
		company.addEmployee(john)
		company.addEmployee(tom)
		println(company.toString())
		// checking company's functionality
		println("50% salary increase")
		try company.increaseSalary(50f)
		catch {
			case e: Exception => println("wrong percentage")

		}
		println(company.toString())
		println(
			"-12% salary increase (should cause an exception, nothing should change in the company)")
		try company.increaseSalary(-12f)
		catch {
			case e: Exception => println("wrong percentage")

		}
		println(company.toString())
		println("500 bonus increase (only Thomas's bonus should change0")
		try company.increaseBonus(500)
		catch {
			case e: Exception => println("wrong bonus")

		}
		println(company.toString())
	}
}
