type myInterface  = {
def method(input : String) : String
}

class Foo {
	def method(input: String) = input
}
class Bar {
	def method(input: String) = input
}
var foo: myInterface = new Bar(); // <- error