def gray(n: Int, acc: List[String] = List("0", "1")): List[String] =
{
	def addLayer(list: List[String] = List("0", "1")): List[String] =
	{
		list ++ list.reverse
	}

	def halfZeroHalfOne(list: List[String], length: Int, n: Int = 0, acc: List[String] = List()): List[String] =
	{
		if(list.isEmpty) acc
		else if(n < length.toFloat / 2) halfZeroHalfOne(list.tail, length, n + 1, acc :+ "0" + list.head)
		else halfZeroHalfOne(list.tail, length, n, acc :+ "1" + list.head)
	}

	if(n == 1) acc
	else gray(n - 1, halfZeroHalfOne(addLayer(acc), acc.length * 2))
}


gray(1)
gray(2)
gray(3)
gray(4)

sealed trait Tree[+A]

case object Empty extends Tree[Nothing]

case class Leaf[+A](elem: A, left: Tree[A], right: Tree[A]) extends Tree[A]

def mirrorTree[A](bt: Tree[A]): Tree[A] = bt match
{
	case Empty => Empty
	case Leaf(root, left, right) =>
		val newLeft = mirrorTree(right)
		val newRight = mirrorTree(left)
		Leaf(root, newLeft, newRight)
}

val t = Leaf(1, Leaf(2, Empty, Leaf(3, Empty, Leaf(4, Empty, Empty))), Empty)
mirrorTree(t) // Node(1,Empty,Node(2,Node(3,Node(4,Empty,Empty),Empty),Empty))


def integral(function: Double => Double, interval: (Double, Double), subintervals: Double): Double =
{
	val (a, b) = interval

	val deltaX = (b - a) / subintervals

	// sum from left to right
	def sum(accum: Double, left: Double): Double =
	{
		if(left + deltaX > b)
		{
			return accum
		}

		val value = deltaX * 0.5 * (function(left) + function(left + deltaX))
		sum(accum + value, left + deltaX)
	}

	sum(0, a)
}

def linear(x: Double): Double =
{
	x * 3 + 2
}

def quadratic(x: Double): Double =
{
	3 * (x * x) + 7 * x + -3
}

integral(linear, (0.0, 1.1), 1)
integral(quadratic, (0, 1.1), 10000)