abstract class Map
{
	//two types, keys and values can be of different type
	type K
	type V

	var keys: List[K] = List()
	var values: List[V] = List()

	def add(key: K, value: V): Boolean

	def toString: String

	def remove(key: K): V

	def clear(): Unit

	def size: Int

	def isEmpty: Int

	def getElement(key : K): V

	def modify(key: K, newValue : V): V
}

abstract class Set[T]
{
	val set: List[T]

	def add(newValue : T) :  Boolean

	def remove(toRemove : T): T

	def clear(): Unit

	def contains(toFind : T): Boolean

	def isEmpty: Int

	def size: Int

	//core set theoretical operations
	def union(set1: Set[T], set2 : Set[T]): Set[T]

	def intersection(set1: Set[T], set2 : Set[T]): Set[T]

	def difference(set1: Set[T], set2 : Set[T]): Set[T]

	def subset(set1: Set[T], set2 : Set[T]): Boolean
}

//methods to implement taken from wikipedia

/*
ArrayList uses arrays with fixed size to store it's elements.
That means, that if we want to add more elements and reach arrays capacity,
new array with bigger size is made, and all the values copied.
LinkedList saves data in form of pairs: element, and the address of the next element,
which makes adding new elements a lot easier.

In an arrayList we can access all data easily using indexes.
To get to nth element in LinkedList, we have to go through all n-1 elements,
which for big sets of data can take long time.

 */