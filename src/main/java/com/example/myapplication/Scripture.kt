package com.example.myapplication

class Scripture {
    // volume, book, chapter, verse_numbers,passage_text, speaker
    private var text = ""
    private var book = ""
    private var chapter = ""
    private var verses = ""
    private var speaker = ""


    //setters
    fun setText( words: String?){
        this.text = words.toString()
    }
    fun setBook( words: String?){
        this.book = words.toString()
    }
    fun setChapter(chapt: String?){
        this.chapter = chapt.toString()
    }
    fun setVerse(verse : String?)
    {
        this.verses = verse.toString()
    }
    fun setSpeaker(words: String?){
        this.speaker = words.toString()
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
    fun getVerse(): String{
        return (this.verses)
    }

    fun getRef(): String{
        var ref = this.book + " " + this.chapter + ":" + this.verses
        return(ref)
    }

}