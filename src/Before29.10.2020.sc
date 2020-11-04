import scala.annotation.tailrec

def sub(x: Int, y: Int) = x - y

def multiply(x: Int, y: Int) = x * y


def mantissa(x: Double): Double =
{
	var mantissa = x
	// if the number is negative, change it's sign
	if(mantissa < 0) {
		mantissa = -mantissa
	}
	while(mantissa >= 0) {
		mantissa = mantissa - 1
	}
	// to properly round it up (not display full double value)
	math.ceil((mantissa + 1) * 10) / 10
}

@tailrec
def fun1(a: Int, b: Int): Int =
{
	if(b == 0) a
	else fun1(b, a % b)
}


def fun2(a: Int, b: Int): Int =
{
	if(a != 0 && b == 0) {
		return fun2(a - 1, 1)
	}
	else if(a != 0) {
		return fun2(a - 1, fun2(a, b - 1))
	}
	b + 1
}


def sumArrayLoop(array: Array[Int]): Int =
{

	var sum = 0
	for(elem <- array) {
		sum += elem
	}
	sum
}

def sumArrayRecursion(array: Array[Int]): Int =
{
	if(array.isEmpty) {
		0
	} else {
		array.head + sumArrayRecursion(array.tail)
	}
}





def sumOddValues(list: List[Int]): Int =
{
	if(list.isEmpty) {
		0
	} else if(list.head % 2 == 0) {
		sumOddValues(list.tail)
	} else {
		list.head + sumOddValues(list.tail)
	}
}







def connectIntoString(list: List[Any], separator: Any): String =
{
	if(list.isEmpty) {
		""
	} else if(list.length == 1) {
		list.head.toString
	} // if there's only one element, the separator should not be applied
	else {
		list.head.toString + separator.toString + connectIntoString(list.tail, separator)
	}
}

def howManyElements(list: List[Any], element: Any): Int =
{
	if(list.isEmpty) {
		0
	} else if(list.head == element) {
		1 + howManyElements(list.tail, element)
	} else {
		howManyElements(list.tail, element)
	}
}


def fibonacci(n: Int): Int =
{
	if(n == 0 || n == 1) {
		n
	} else {
		fibonacci(n - 1) + fibonacci(n - 2)
	}
}

def and(x: Boolean, y: Boolean): Boolean = (x, y) match {
	case (true, true) => true
	case (_, _) => false
}

def geometrical(firstElem: Float, multiplier: Int, howManyElems: Int): List[Float] =
{
	if(howManyElems <= 1) {
		List(firstElem / 2)
	} else {
		List(firstElem / 2) ++ geometrical(firstElem * multiplier, multiplier, howManyElems - 1)
	}
}








def binaryReverse(number: Int): Int =
{
	@tailrec
	def binaryReverseString(array: String, result: String): String =
	{
		if(array.isEmpty) {
			result
		} else {
			binaryReverseString(array.dropRight(1), result.appended(array(array.length - 1)))
		}
	}

	val array = binaryReverseString(number.toBinaryString, "")
	Integer.parseInt(array, 2)
}

def con(list: List[List[Any]]): List[Any] =
{
	// sort lists
	def aroundLists(list: List[List[Any]]): List[List[Any]] =
	{
		// sort elements in single list
		def aroundElems(list: List[Any]): List[Any] =
		{
			if(list.isEmpty) {
				List()
			} else {
				aroundElems(list.tail) ++ List(list.head)
			}
		}

		if(list.isEmpty) {
			List()
		} else {
			aroundLists(list.tail) ++ List(aroundElems(list.head))
		}
	}

	// unpack if all elements are sorted
	def unpackLists(list: List[List[Any]]): List[Any] =
	{
		if(list.isEmpty) {
			List()
		} else if(list.head.isEmpty) {
			unpackLists(list.tail)
		} else {
			List(list.head.head) ++ unpackLists(List(list.head.tail) ++ list.tail)
		}
	}
	// unpack a sorted list of sorted lists
	unpackLists(aroundLists(list))
}

/*
--------------------------------------------------------------------------
                             TUTORIAL 3
--------------------------------------------------------------------------
 */

@tailrec
def sumList(list: List[Int], acc: BigInt = 0): BigInt =
{
	if(list.isEmpty) {
		acc
	} else {
		sumList(list.tail, acc + list.head)
	}
}

sumList(List(1, 2, 3, 4, 5)) // expect 15
sumList(List()) // expect 0
//sumList(List.range(1, 9999999))       // expect no stackOverFlow
//sumList(List.range(1, Int.MaxValue))  // expect no stackOverFlow, but not enough heap

def reverseListRegular(list: List[Any]): List[Any] =
{
	if(list.isEmpty) {
		List()
	} else {
		reverseListRegular(list.tail) ++ List(list.head)
	}
}

reverseListRegular(List(1, 2, 3, 4, 5))
reverseListRegular(List("a", "b", "c", "d", 4, 3, 2, 1))
reverseListRegular(List())

@tailrec
def reverseListTail(list: List[Any], acc: List[Any] = List()): List[Any] =
{
	if(list.isEmpty) {
		acc
	} else {
		reverseListTail(list.tail, list.head :: acc)
	} // :: creates a new list with list.head at beginning and acc at the end
}

reverseListRegular(List(1, 2, 3, 4, 5))
reverseListRegular(List("a", "b", "c", "d", 4, 3, 2, 1))
reverseListRegular(List())

def addTwoLists(list1: List[Any], list2: List[Any]): List[Any] =
{
	if(list1.isEmpty && list2.nonEmpty) {
		list2
	} else if(list2.isEmpty && list1.nonEmpty) {
		list1
	} else if(list1.isEmpty && list2.isEmpty) {
		List()
	} else {
		List(list1.head, list2.head) ++ addTwoLists(list1.tail, list2.tail)
	}
}

addTwoLists(List(1, 2, 3, 4, 5), List(6, 7, 8, 9, 10))
addTwoLists(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), List(11))
addTwoLists(List(1, 2, 3, 4, 5), List())
addTwoLists(List(), List())


/*
def fibonacci(n: Int): Int = {
  if (n == 0 || n == 1) n
  else fibonacci(n - 1) + fibonacci(n - 2)
}
 */

@tailrec
def fibonacciTail(howMany: BigInt, e1: BigInt = 0, e2: BigInt = 1): BigInt =
{
	if(howMany < 1) {
		0
	} else if(howMany == 1) {
		e2
	} else {
		fibonacciTail(howMany - 1, e2, e1 + e2)
	}
}

fibonacciTail(7) // expect 13
fibonacciTail(100) // expect 354,224,848,179,261,915,075, no stackOverFlow
fibonacciTail(0) // expect 0
fibonacciTail(1) // expect 1
fibonacciTail(-5) // expect 0

@tailrec
def splitIntoTwo(list: List[Int], odd: List[Int] = List(), even: List[Int] = List()): (List[Int], List[Int]) =
{
	if(list.isEmpty) {
		(odd, even)
	} else if(list.head % 2 == 0) {
		splitIntoTwo(list.tail, odd, even :+ list.head)
	} else {
		splitIntoTwo(list.tail, odd :+ list.head, even)
	}
}

splitIntoTwo(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
splitIntoTwo(List(1, 3, 5, 7))
splitIntoTwo(List(2))
splitIntoTwo(List())


@tailrec
def isSorted(list: List[Int], lastElem: Int = Int.MinValue): Boolean =
{
	if(list.isEmpty) {
		true
	} else if(list.head <= lastElem) {
		false
	} else {
		isSorted(list.tail, list.head)
	}
}

isSorted(List(1, 2, 3, 4, 5)) // expect true
isSorted(List(1, 2, 3, 5, 4)) // expect false
isSorted(List(5, 4, 3, 2, 1)) // expect false
isSorted(List()) // no wrong order, return true

@tailrec
def replaceElement(list: List[Any], index: Int, elem: Any, acc: List[Any] = List()): List[Any] =
{
	if(index < 0 || list.isEmpty) {
		list
	} else if(index == 0) {
		acc ++ List(elem) ++ list.tail
	} else {
		replaceElement(list.tail, index - 1, elem, acc :+ list.head)
	}
}

replaceElement(List(1, 2, 10, 4, 5), 2, 3)
replaceElement(List(1, 2, 3), 4, 5) // expect empty list
replaceElement(List(), 3, 4) // expect empty list

def convertPressure(atm: Double)(unit: String):
Double = unit.toLowerCase() match {
	case "psi" => atm * 14.6956
	case "torr" => atm * 760
	case "pa" => atm * 101325
	case "bar" => atm * 1.01325
	case _ => -1
}

// use of currying
val convert = convertPressure(2) _
convert("psi")
convert("torr")
convert("Pa")
convert("bar")
convert("sadghkjasdhkad") //expect -1 - error value

/*
-----------------------------------------------------------------------------
                          TUTORIAL 4
 -----------------------------------------------------------------------------
 */

def subtractTailSum(list: List[Int]): Int =
{
	def sumList(list: List[Int]): Int =
	{
		if(list.isEmpty) {
			0
		} else {
			list.head + sumList(list.tail)
		}
	}

	list.head - sumList(list.tail)
}

subtractTailSum(List(1, 2, 3, 4))
subtractTailSum((List(5)))

def sumTwoListsRegular(list1: List[Int], list2: List[Int]): List[Int] =
{
	if(list1.isEmpty) list2
	else if(list2.isEmpty) list1
	else List(list1.head + list2.head) ++ sumTwoListsRegular(list1.tail, list2.tail)
}

sumTwoListsRegular(List(5, 4, 3, 2), List(1, 2, 3, 4, 5, 6))

@tailrec
def sumTwoListsTail(list1: List[Int], list2: List[Int], acc: List[Int] = List()): List[Int] =
{
	if(list1.isEmpty) {
		acc ++ list2
	} else if(list2.isEmpty) {
		acc ++ list1
	} else {
		sumTwoListsTail(list1.tail, list2.tail, acc :+ list1.head + list2.head)
	}
}

sumTwoListsTail(List(5, 4, 3, 2), List(1, 2, 3, 4, 5, 6))



def splitIntoTwoRegular(list: List[Int]): (List[Int], List[Int]) =
{
	def getEven(list: List[Int]): List[Int] =
	{
		if(list.isEmpty) {
			List()
		} else if(list.head % 2 == 0) {
			List(list.head * list.head) ++ getEven(list.tail)
		} else {
			getEven(list.tail)
		}
	}

	def getOdd(list: List[Int]): List[Int] =
	{
		if(list.isEmpty) {
			List()
		} else if(list.head % 2 != 0) {
			List(list.head * 3) ++ getOdd(list.tail)
		} else {
			getOdd(list.tail)
		}
	}

	(getEven(list), getOdd(list))
}

splitIntoTwoRegular(List(3, 6, 8, 9, 13))

@tailrec
def splitIntoTwoTail(list: List[Int], odd: List[Int] = List(), even: List[Int] = List()): (List[Int], List[Int]) =
{
	if(list.isEmpty) {
		(even, odd)
	} else if(list.head % 2 == 0) {
		splitIntoTwoTail(list.tail, odd, even :+ list.head * list.head)
	} else {
		splitIntoTwoTail(list.tail, odd :+ list.head * 3, even)
	}
}

splitIntoTwoRegular(List(3, 6, 8, 9, 13))