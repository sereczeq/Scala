def lrepeat(k: Int)(lxs: LazyList[Any]):LazyList[Any] =
{
		if (k < 1) LazyList()
		else lxs #::: lrepeat(k-1)(lxs)
}

lrepeat(5)(LazyList(1, 2, 3)).toList

def fibonacciSeq(): LazyList[Int] =
{
		LazyList(0, 1) #::: fibonacciSeq().zip(fibonacciSeq().tail).map(a => a._1 + a._2)
}

fibonacciSeq().take(10).toList

trait LBT[+A]
case object LEmpty extends LBT[Nothing]
case class LNode[+A](elem:A, left:()=>LBT[A], right:()=>LBT[A]) extends LBT[A]

def generate(n : Int): LBT[Int] =
	LNode(n, () => generate(n * 2), () => generate(2*n+1))

def browseTree(tree: LBT[Int]): Unit =
{

}

generate(5)
