import scala.annotation.tailrec

@tailrec
def getPrimes(list: List[Int], acc: List[Int] = List()): List[Int] =
{
	@tailrec
	def isPrime(number: Int, denominator: Int = 2): Boolean =
	{
		if(denominator >= number && !(number < 0)) true
		else if(number % denominator == 0 || denominator > 200 || number > 200 || number < 0) false
		else isPrime(number, denominator + 1)
	}

	if(list.isEmpty) acc
	else if(isPrime(list.head)) getPrimes(list.tail, acc :+ list.head)
	else getPrimes(list.tail, acc)
}

getPrimes(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 197))
getPrimes(List())
getPrimes(List(2, 4, 6, 8, 10))
getPrimes(List(127, 125, 76, 38, 93, 300))
getPrimes(List(-127, -125, -76, -38, -93, -300))


sealed abstract class Numbers

final case class Plus(a: Numbers, b: Numbers) extends Numbers
{
	override def equals(that: Any): Boolean = false
}

final case class Negate(a: Numbers) extends Numbers
{
	override def equals(that: Any): Boolean = false
}

final case class Literal(v: Int) extends Numbers
{
	override def equals(that: Any): Boolean = false
}

def calculate(expression: Numbers): Int =
{
	expression match
	{
		case Literal(a) => a
		case Plus(a, b) => calculate(a) + calculate(b)
		case Negate(a) => -calculate(a)
	}
}

calculate(Plus(Literal(10), Negate(Literal(3))))
calculate(Negate(Literal(-10)))


sealed abstract class Bool

case object True extends Bool
{
	override def equals(that: Any): Boolean = that match
	{
		case that: Boolean => that
		case _: Any => false
	}
}

case object False extends Bool
{
	override def equals(that: Any): Boolean = that match
	{
		case that: Boolean => !that
		case _: Any => false
	}
}

def and(bol1: Bool, bol2: Bool): Boolean = (bol1, bol2) match
{
	case (True, True) => true
	case (_, _) => false
}
def or(bol1: Bool, bol2: Bool): Boolean = (bol1, bol2) match
{
	case (False, False) => false
	case (_, _) => true
}
def xor(bol1: Bool, bol2: Bool): Boolean = (bol1, bol2) match
{
	case (True, False) => true
	case (False, True) => true
	case (_, _) => false
}
def nor(bol1: Bool, bol2: Bool): Boolean = (bol1, bol2) match
{
	case (False, False) => true
	case (_, _) => false
}
def nand(bol1: Bool, bol2: Bool): Boolean = (bol1, bol2) match
{
	case (True, True) => false
	case (_, _) => true
}

and(True, False)
nand(True, False)
nor(True, True)

def whatType(x: Any): String = x match
{
	case a: Char => s"You typed a char: $a"
	case a: String => s"You typed a string: $a"
	case a: Int => s"You typed an int: $a"
	case a: Float => s"You typed a float: $a"
	case a: Double => s"You typed a double $a"
	case a: Any => s"Sorry, i do not recognize type of: $a"
}

whatType(12)
whatType("Hello World")
whatType(True)