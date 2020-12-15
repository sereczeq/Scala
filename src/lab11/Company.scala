package lab11


class Company {

	private var employees: List[Employee] = List()

	def addEmployee(newEmployee: Employee): Boolean = {
		if (employees.contains(newEmployee)) return false
		employees = employees :+ newEmployee
		true
	}

	def increaseSalary(percentage: Float): Unit = {
		if (percentage < 0) throw new Exception("percentage is not proper")
		for (employee <- employees) employee.increaseSalary(percentage)
	}

	def increaseBonus(howMuch: Int): Unit = {
		if (howMuch < 0) throw new Exception("bonus is negative")
		for (employee <- employees if employee.isInstanceOf[SpecialistEmployee])
			employee.asInstanceOf[SpecialistEmployee].raiseBonus(howMuch)
	}

	override def toString(): String = "Company{" + "employees=" + employees.toString() + "}"

}
