type SectionLength = Int
type ChapterSectionsLengths = List[SectionLength]
type BookDescription = List[ChapterSectionsLengths]

def makeASection(start: Int, length: Int): SectionLength =
{
	length
}

def makeAChapter(start: Int, length: Int): ChapterSectionsLengths =
	{
		List(makeASection(start, length/3), makeASection(start+length/3, length/3*2))
	}

val chapter: ChapterSectionsLengths = List(1, 3, 5)