def makeNoise(emitter:
            {def makeNoise(): String})
{
	println(emitter.makeNoise().capitalize + "!")
}

object Dog{
	def makeNoise() : String = "woof"
}
object Cat{
	def makeNoise() : String = "meow"
}
object Bird{
	def makeNoise() : String = "chirp"
}

object Fish{
}

makeNoise(Dog);
makeNoise(Cat);
makeNoise(Bird);
//makeNoise(Fish)