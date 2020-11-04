def returnPrimes(list: List[Int], acc :List[Int] = List()): List[Int] =
	{
		def isPrime(x : Int, denominator : Int = 2) :Boolean =
			{
				if (x % denominator == 0) true
				else isPrime(x, denominator + 1)
			}
		if (list.isEmpty) acc
		else if (isPrime(list.head)) returnPrimes(list.tail, acc :+ list.head)
		else returnPrimes(list.tail, acc)
	}

