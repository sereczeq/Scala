def oddIterative(first: Int, howMany: Int): List[Int] =
{
	def oddIterativeHelper(first: Int, howMany: Int, acc: List[Int] = List()): List[Int] =
	{
		if(howMany <= 0) acc
		else oddIterativeHelper(first + 2, howMany - 1, acc :+ first)
	}

	if(first % 2 == 0) oddIterativeHelper(first + 1, howMany)
	else oddIterativeHelper(first, howMany)
}

oddIterative(13, 0)

def oddImperative(first: Int, howMany: Int): List[Int] =
{
	var acc = List(if(first % 2 == 0) first + 1 else first)
	for(i <- 0 to howMany - 2) acc = acc :+ (acc.last + 2)
	if(howMany <= 0) List() else acc
}

oddImperative(13, 0)


def split(list: List[Any]): (List[Any], List[Any]) =
{
	def odd(list: List[Any], count: Int = 0, acc: List[Any] = List()): List[Any] =
	{
		if(list.isEmpty) acc
		else if(count % 2 != 0) odd(list.tail, count + 1, acc ++ List(list.head))
		else odd(list.tail, count + 1, acc)
	}

	def even(list: List[Any], count: Int = 0, acc: List[Any] = List()): List[Any] =
	{
		if(list.isEmpty) acc
		else if(count % 2 == 0) even(list.tail, count + 1, acc ++ List(list.head))
		else even(list.tail, count + 1, acc)
	}

	(even(list), odd(list))
}
def splitImperative(list: List[Any]): (List[Any], List[Any]) =
{
	var accOdd: List[Any] = List();
	var accEven: List[Any] = List();

	for(i <- 0 until list.length)
	{
		if(i % 2 != 0) accOdd = accOdd ++ List(list(i))
		else accEven = accEven ++ List(list(i))
	}
	(accEven, accOdd)
}

split(List(5, 6, 3, 2, 1, 10, 10))
splitImperative(List(5, 6, 3, 2, 1, 10, 10))

def mergeFunctional(list: List[Any], list2: List[Any], accumulator: List[Any] = List()): List[Any] =
{
	if(list.isEmpty) accumulator ++ list2
	else if(list2.isEmpty) accumulator ++ list
	else mergeFunctional(list.tail, list2.tail, accumulator ++ List(list.head, list2.head))
}
mergeFunctional(List(1, 3, 5, 7, 9, 11), List(2, 4, 6, 8))

def mergeImperative(list1: List[Any], list2: List[Any]): List[Any] =
{
	var acc: List[Any] = List()
	val min = if (list1.length < list2.length) list1.length else list2.length
	for (i <- 0 until min) acc = acc:++List(list1(i), list2(i))
	for (i <- min until list1.length) acc = acc:+ list1(i)
	for (i <- min until list2.length) acc = acc:+ list2(i)
	acc

}
mergeImperative(List(1, 3, 5, 7, 9, 11), List(2, 4, 6, 8))
mergeImperative(List(1, 2, 3), List(4, 5, 6))
mergeImperative(List(1, 3, 5), List(2, 4, 6, 8))
mergeImperative(List(), List(1, 2, 3))