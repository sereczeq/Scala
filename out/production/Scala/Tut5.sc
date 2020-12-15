def repeatList(k: Int)(lxs: LazyList[Any]): LazyList[Any] =
{
	if(k < 1) LazyList()
	else lxs #::: repeatList(k - 1)(lxs)
}

repeatList(5)(LazyList(1, 2, 3)).toList
repeatList(3)(LazyList(1, 4, 7)).toList
repeatList(3)(LazyList("a")).toList
repeatList(3)(LazyList()).toList

def fibonacci(): LazyList[Int] =
{
	LazyList(0, 1) #::: fibonacci().zip(fibonacci().tail).map(a => a._1 + a._2)
}

fibonacci().take(10).toList
fibonacci().take(12).toList
fibonacci().take(1).toList
fibonacci().take(2).toList


sealed trait lBT[+A]

case object LEmpty extends lBT[Nothing]

case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]


def generateTree(n: Int): lBT[Int] = LNode(n, () => generateTree(2 * n), () => generateTree(2 * n + 1))
def breadthSearch[A](tree: lBT[A]): LazyList[A] =
{
	def iter(list: List[lBT[A]]): LazyList[A] = list match
	{
		case Nil => LazyList()
		case LEmpty :: tl => iter(tl)
		case LNode(v, bt1, bt2) :: tl => v #:: iter(tl ::: List(bt1(), bt2()))
	}

	iter(List(tree))
}

breadthSearch(generateTree(0)).take(30).toList
breadthSearch(generateTree(1)).take(20).toList
breadthSearch(generateTree(2)).take(20).toList
breadthSearch(generateTree(3)).take(20).toList
