package lab11

class Employee(var surname: String, var firstName: String, var salary: Int) {

	def increaseSalary(percentage: Float): Unit = {
		this.salary += (this.salary * percentage / 100).toInt
	}

	 override def toString = s"Employee(surname=$surname, firstName=$firstName, salary=$salary)"
}

