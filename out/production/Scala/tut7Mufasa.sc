abstract class Map
{
	//two types, keys and values can be of different type
	type A
	type B
	var keys: List[A] = List()
	var data: List[B] = List()
	def add(key: A, x: B): Boolean
	def replace(key: A, x : B): B
	def empty(): Unit
	def getElem(key : A): B
	def getSize: Int
	def toString: String
	def remove(key: A): B
	def isEmpty: Int
}

abstract class Set[T]
{
	val list: List[T]
	def put(x : T) :  Boolean
	def difference(a: Set[T], b : Set[T]): Set[T]
	def hasElem(x : T): Boolean
	def empty(): Unit
	def union(a: Set[T], b : Set[T]): Set[T]
	def getSize: Int
	def intersection(a: Set[T], b : Set[T]): Set[T]
	def isEmpty: Int
	def delete(x : T): T
	def subset(a: Set[T], b : Set[T]): Boolean
}

/*ArrayList internally uses an array to store elements
	LunkedList uses a doubly linked list to store the elements

If an element is removed from the ArrayList, all the elements have to be shiften,
it's slower than LinkedList, which just changes an address

LinkedList can act as an list or a queue whereas ArrayList can only work as List

In summary: ArrayList is better for storing and accessing data, and takes less memory,
LinkedList is better for manipulating given data.*/