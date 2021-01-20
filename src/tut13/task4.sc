import scala.collection.mutable

def wordCounter(text: String): mutable.Map[String, Int] =
{
	val map = mutable.Map.empty[String, Int].withDefaultValue(0)

	text.split(" ").foreach(word => map(word) +=1)
	map
}

val text = "five one three five two three three five four four two four five four five"
wordCounter(text)