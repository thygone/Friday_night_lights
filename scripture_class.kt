class Scripture {
    // volume, book, chapter, verse_numbers,passage_text, speaker
    private var text = ""
    private var book = ""
    private var chapter = 0
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
    fun setChapter( chapt : Int){
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
    fun getChapter(): Int{
        return this.chapter
    }
    fun getSpeaker(): String{
        return (this.speaker)
    }
    fun getPlace(): String{
        return (this.place)
    }
}