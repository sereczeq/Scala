sealed trait lBT[+A]

case object Leaf extends lBT[Nothing]

case class Branch[+A](elem: String, left: lBT[A], right: lBT[A]) extends lBT[A]

def find(toFind: String, tree: lBT[Any]): List[String] = tree match
{
	case Leaf => List()
	case Branch(elem, left, right) =>
	if(elem.indexOf(toFind) != -1) elem :: find(toFind, left) ::: find(toFind, right)
	else find(toFind, left) ::: find(toFind, right)
}


find("Tes", Branch("Test", Branch("Testtt", Leaf, Leaf), Branch("estt", Leaf, Branch("SuperTes", Leaf, Leaf))))
find("bang", Branch("Test", Branch("Testtt", Leaf, Leaf), Branch("estt", Leaf, Branch("SuperTes", Leaf, Leaf))))
find("SuperTes", Branch("Test", Branch("Testtt", Leaf, Leaf), Branch("estt", Leaf, Branch("SuperTes", Leaf, Leaf))))

def odd(k: Int): LazyList[Int] =
{
	if(k < 0)
		LazyList()
	else if(k % 2 == 0)
		LazyList(k + 1) #::: odd(k + 2)
	else
		LazyList(k) #::: odd(k + 2)
}
odd(2).take(15).toList

def arithmetic(first: Double, difference: Double): LazyList[Double] =
{
	LazyList(first) #::: arithmetic(first + difference, difference)
}
arithmetic(2, 3).take(13).toList