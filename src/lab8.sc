def duplicate(values: Stream[Any], multipliers: Stream[Int]): Stream[Any] =
	{
		def times (value: Any, multiplier: Int): Stream[Any] =
			{
				if(multiplier > 0) value #:: times(value, multiplier - 1)
				else Stream()
			}
		if(values.isEmpty || multipliers.isEmpty) Stream()
		else times(values.head, multipliers.head) #::: duplicate(values.tail, multipliers.tail)
	}

duplicate(Stream(1, 2, 3), Stream(0, 3, 1, 4)).toList