import scala.collection.mutable

def wordCounter(text: String): mutable.Map[String, Int] =
{
	val map = mutable.Map.empty[String, Int]

	text.split(" ").foreach(word => {
		if(map.contains(word)) map(word) +=1
		else map.addOne(word, 1)
	})
	map
}

val text = "five one three five two three three five four four two four five four five"
wordCounter(text)