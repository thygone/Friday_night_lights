import kotlin.random.Random

class Scripture4 {
    // volume, book, chapter, verse_numbers,passage_text, speaker
    private var text = ""
    private var book = ""
    private var chapter = ""
    private var verses = "" 
    private var speaker = ""
    private var place = ""
    

    //setters
    fun setText( words: String){
        this.text = words
    }
    fun setBook( words: String){
        this.book = words
    }
    fun setChapter( chapt : String){
        this.chapter = chapt
    }
    fun setVerse(verse : String)
    {
        this.verses = verse
    }
    fun setSpeaker(words: String){
        this.speaker = words
    }
    fun setPlace(words: String){
        this.place = words
    }
    
    //getters
    fun getText(): String{
        return (this.text)
    }
    fun getBook(): String{
        return (this.book)
    }
    fun getChapter(): String{
        return this.chapter
    }
    fun getSpeaker(): String{
        return (this.speaker)
    }
    fun getPlace(): String{
        return (this.place)
    }
    fun getVerse(): String{
        return (this.verses)
    }
}

//change array size to number of question
var answerKey:Array<String?> = arrayOfNulls(5)//correct answers
//change array size to number of question
var Panswers:Array<String?> = arrayOfNulls(5)//answers from player
var correct = booleanArrayOf(true)


fun display(ref : Scripture4){
    print(ref.getBook())
    print(" ")
    print(ref.getChapter())
    print(" : ")
    print(ref.getVerse())
    print("\n")
    print(ref.getText())
    print("\n")
    print("Speaker: " + ref.getSpeaker())
    print("\nPlace: " + ref.getPlace())  
}
/*
* Fun: getBlancs
* Peram: scriptures
* purpose: this function will move threw the text and create a certain number of blanks for the quize
* HOW loop through text for random # and copy to answers array, replace with "____",  
*/
fun getBlanks(scr : Scripture4, currBlank : Int) : Int{
    var id = currBlank
    val blank = "____" // replace what is being used
    
    //remove book
    answerKey[id] = scr.getBook()// take book and add it to the answer sheet
    scr.setBook(blank) // put a blank where the book would be
    id += 1  // incrament to the next index
    //remove chapter
    answerKey[id] = scr.getChapter()// take Chapter and add it to the answer sheet
    scr.setChapter(blank) // put a blank where chapter would be
    id += 1  // incrament to the next index
    //remove verses
    answerKey[id] = scr.getVerse()
    scr.setVerse(blank) 
    id += 1  
    // remove the speaker
    answerKey[id] = scr.getSpeaker()// take speaker and add him to the answer sheet
    scr.setSpeaker(blank) // put a blank where his name would be
    id += 1  // incrament to the next index

    // remove the place
    answerKey[id] = scr.getPlace()
    scr.setPlace(blank)
    id += 1

    

    return(id)


        

}
// this will compare the values in correct answers and player answers to see if they are the same
fun check_answer(){
    //change limit size to number of question
    for (i in (0..4)) // 1 less than total answers
        if (Panswers[i] == answerKey[i])
            correct[i] = true// if they are the same then the answer was correct
        else
            correct[i] = false// if they were not the same then the answer was false
}

fun makeQ(scr : Scripture4) {
    var questionNumber = 0
    //change limit size to number of question
    while (questionNumber < 5){
        questionNumber = getBlanks(scr,questionNumber)
    }
}

fun main(){
    // debugging info
    val test = Scripture4()
    test.setBook("Jacob")
    test.setChapter("1")
    test.setVerse("3")
    test.setText("For my soul delighteth in plainess; for after this manner doth the \n" +
                "Lord God work among the children of men. For the Lord God giveth light \n" + 
                "unto the understanding; for he speaketh unto men according to their\n " +
                "language, unto their understanding.") 
    test.setSpeaker("Jacob")
    test.setPlace("City of Lehi")
    // end debuging data
    
    makeQ(test)
    display(test)

    // what was put into the answer key?
    var i = 0
    //change limit size to number of question
    while (i < 5){
        print("\n")
        print(answerKey[i])
        i++}
}