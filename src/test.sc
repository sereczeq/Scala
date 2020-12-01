sealed trait lBT[+A]

case object Leaf extends lBT[Nothing]

case class Branch[+A](elem: A, left: lBT[A], right: lBT[A]) extends lBT[A]

def paths[A](tree:lBT[A]):List[List[A]] = tree match {
	case Leaf => Nil
	case Branch(elem, Leaf, Leaf) => List(elem :: Nil)
	case Branch(elem, Leaf, right)  => paths(right).map(elem ::_)
	case Branch(elem, left, Leaf) => paths(left).map(elem ::_)
	case Branch(elem, left, right)  => (paths(left) ::: paths(right)).map(elem ::_)
}

var list = paths(Branch(1, Branch(2, Branch(3, Leaf, Leaf), Branch(4, Branch(5, Leaf, Leaf), Leaf)), Branch(6, Leaf, Branch(7, Leaf, Branch(8, Leaf, Leaf)))))
