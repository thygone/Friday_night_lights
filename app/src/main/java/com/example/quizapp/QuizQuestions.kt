package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlin.random.Random
import android.view.View

class QuizQuestions : AppCompatActivity() {
    // buttons for the 4 possible answers
    lateinit var opt1: Button
    lateinit var opt2: Button
    lateinit var opt3: Button
    lateinit var opt4: Button

    //array for holding the answers to the questions
    var answerKey: Array<String?> = arrayOfNulls(5)//correct answer

    // text holder for the scripture and reference
    lateinit var scrip: EditText
    lateinit var question: Scripture // this will hold the scripture that will be used for the test
    lateinit var correct: EditText

    // LIST OF SCRIPTURES
    val scriptures = listOf(
        mapOf(
            "book" to "2 Nephi",
            "chapter" to "28",
            "verses" to "30",
            "text" to "For behold, thus saith the Lord God to I will give unto  the children of men line upon line, precept upon precept, here a little and there a little; and blessed are those who hearken unto  my precepts, and lend an ear unto  my counsel, for they shall learn wisdom; for unto  him that receiveth I will give more; and from them that shall say, We have enough, from them shall be taken away even that which they have.",
            "speaker" to "Nephi"
        ),
        mapOf(
            "book" to "2 Nephi",
            "chapter" to "32",
            "verses" to "3",
            "text" to "Angels speak by the power of the Holy Ghost; wherefore, they speak the words of Christ. Wherefore, I said unto  you, feast upon the words of Christ; for behold, the words of Christ will tell you all things what ye should do.",
            "speaker" to "Nephi"
        ),
        mapOf(
            "book" to "2 Nephi",
            "chapter" to "32",
            "verses" to "8-9",
            "text" to "And now, my beloved brethren, I perceive that ye ponder still in your hearts; and it grieveth me that I must speak concerning this thing. For if ye would hearken unto  the Spirit which teacheth a man to  pray, ye would know that ye must pray; for the evil spirit teacheth not a man to  pray, but teacheth him that he must not pray. But behold, I say unto  you that ye must pray always, and not faint; that ye must not perform any thing unto  the Lord save in the first place ye shall pray unto  the Father in the name of Christ, that he will consecrate thy performance unto  thee, that thy performance may be for the welfare of thy soul.",
            "speaker" to "Nephi"
        ),
        mapOf(
            "book" to "Mosiah",
            "chapter" to "4",
            "verses" to "9",
            "text" to "Believe in God; believe that he is, and that he created all things, both in heaven and in earth; believe that he has all wisdom, and all power, both in heaven and in earth; believe that man doth not comprehend all the things which the Lord can comprehend.",
            "speaker" to "King Benjamin"
        ),
        mapOf(
            "book" to "Ether",
            "chapter" to "12",
            "verses" to "6",
            "text" to "And now, I, Moroni, would speak somewhat concerning these things; I would show unto  the world that faith is things which are hoped for and not seen; wherefore, dispute not because ye see not, for ye receive no witness until after the trial of your faith.",
            "speaker" to "Moroni"
        ),
        mapOf(
            "book" to "Moroni",
            "chapter" to "10",
            "verses" to "4-5",
            "text" to "And when ye shall receive these things, I would exhort you that ye would ask God, the Eternal Father, in the name of Christ, if these things are not true; and if ye shall ask with a sincere heart, with real intent, having faith in Christ, he will manifest the truth of it unto  you, by the power of the Holy Ghost. And by the power of the Holy Ghost ye may know the truth of all things.",
            "speaker" to "Moroni"
        ),
        mapOf(
            "book" to "2 Nephi",
            "chapter" to "26",
            "verses" to "33",
            "text" to "For none of these iniquities come of the Lord; for he doeth that which is good among the children of men; and he doeth nothing save it be plain unto  the children of men; and he inviteth them all to  come unto  him and partake of his goodness; and he denieth none that come unto  him, black and white, bond and free, male and female; and he remembereth the heathen; and all are alike unto  God, both Jew and Gentile.",
            "speaker" to "Nephi"
        ),
        mapOf(
            "book" to "3 Nephi",
            "chapter" to "11",
            "verses" to "10-11",
            "text" to "Behold, I am Jesus Christ, whom the prophets testified shall come into  the world. And behold, I am the light and the life of the world; and I have drunk out of that bitter cup which the Father hath given me, and have glorified the Father in taking upon me the sins of the world, in the which I have suffered the will of the Father in all things from the beginning.",
            "speaker" to "Jesus Christ"
        ),
        mapOf(
            "book" to "3 Nephi",
            "chapter" to "12",
            "verses" to "48",
            "text" to "Therefore I would that ye should be perfect even as I, or your Father who is in heaven is perfect.",
            "speaker" to "Jesus Christ"
        ),
        mapOf(
            "book" to "3 Nephi",
            "chapter" to "18",
            "verses" to "15,20-21",
            "text" to "Verily, verily, I say unto  you, ye must watch and pray always, lest ye be tempted by the devil, and ye be led away captive by him. And whatsoever ye shall ask the Father in my name, which is right, believing that ye shall receive, behold it shall be given unto  you. Pray in your families unto  the Father, always in my name, that your wives and your children may be blessed.",
            "speaker" to "Jesus Christ"
        ),
        mapOf(
            "book" to "2 Nephi",
            "chapter" to "2",
            "verses" to "22-25",
            "text" to "And now, behold, if Adam had not transgressed he would not have fallen, but he would have remained in the garden of Eden. And all things which were created must have remained in the same state in which they were after they were created; and they must have remained forever, and had no end. And they would have had no children; wherefore they would have remained in a state of innocence, having no joy, for they knew no misery; doing no good, for they knew no sin. But behold, all things have been done in the wisdom of him who knoweth all things. Adam fell that men might be; and men are, that they might have joy.",
            "speaker" to "Lehi"
        ),
        mapOf(
            "book" to "2 Nephi",
            "chapter" to "2",
            "verses" to "27",
            "text" to "Wherefore, men are free according to  the flesh; and all things are given them which are expedient unto  man. And they are free to  choose liberty and eternal life, through the great Mediator of all men, or to  choose captivity and death, according to  the captivity and power of the devil; for he seeketh that all men might be miserable like unto  himself.",
            "speaker" to "Lehi"
        ),
        mapOf(
            "book" to "Mosiah",
            "chapter" to "3",
            "verses" to "19",
            "text" to "For the natural man is an enemy to  God, and has been from the fall of Adam, and will be, forever and ever, unless he yields to  the enticings of the Holy Spirit, and putteth off the natural man and becometh a saint through the ato nement of Christ the Lord, and becometh as a child, submissive, meek, humble, patient, full of love, willing to  submit to  all things which the Lord seeth fit to  inflict upon him, even as a child doth submit to  his father.",
            "speaker" to "King Benjamin"
        ),
        mapOf(
            "book" to "Alma",
            "chapter" to "7",
            "verses" to "11-13",
            "text" to "And he shall go forth, suffering pains and afflictions and temptations of every kind; and this that the word might be fulfilled which saith he will take upon him the pains and the sicknesses of his people. And he will take upon him death, that he may loose the bands of death which bind his people; and he will take upon him their infirmities, that his bowels may be filled with mercy, according to  the flesh, that he may know according to  the flesh how to  succor his people according to  their infirmities. Now the Spirit knoweth all things; nevertheless the Son of God suffereth according to  the flesh that he might take upon him the sins of his people, that he might blot out their transgressions according to  the power of his deliverance; and now behold, this is the testimony which is in me.",
            "speaker" to "Alma the Younger"
        ),
        mapOf(
            "book" to "Alma",
            "chapter" to "34",
            "verses" to "9-10",
            "text" to "For it is expedient that an ato nement should be made; for according to  the great plan of the Eternal God there must be an ato nement made, or else all mankind must unavoidably perish; yea, all are hardened; yea, all are fallen and are lost, and must perish except it be through the ato nement which it is expedient should be made. For it is expedient that there should be a great and last sacrifice; yea, not a sacrifice of man, neither of beast, neither of any manner of fowl; for it shall not be a human sacrifice; but it must be an infinite and eternal sacrifice.",
            "speaker" to "Alma the Younger"
        ),
        mapOf(
            "book" to "Helaman",
            "chapter" to "5",
            "verses" to "12",
            "text" to "And now, my sons, remember, remember that it is upon the rock of our Redeemer, who is Christ, the Son of God, that ye must build your foundation; that when the devil shall send forth his mighty winds, yea, his shafts in the whirlwind, yea, when all his hail and his mighty sto rm shall beat upon you, it shall have no power over you to  drag you down to  the gulf of misery and endless wo, because of the rock upon which ye are built, which is a sure foundation, a foundation whereon if men build they cannot fall.",
            "speaker" to "Helaman"
        ),
        mapOf(
            "book" to "Ether",
            "chapter" to "12",
            "verses" to "27",
            "text" to "And if men come unto  me I will show unto  them their weakness. I give unto  men weakness that they may be humble; and my grace is sufficient for all men that humble themselves before me; for if they humble themselves before me, and have faith in me, then will I make weak things become strong unto  them.",
            "speaker" to "Moroni"
        ),
        mapOf(
            "book" to "Mosiah",
            "chapter" to "18",
            "verses" to "8-10",
            "text" to "And it came to  pass that he said unto  them to Behold, here are the waters of Mormon (for thus were they called) and now, as ye are desirous to  come into  the fold of God, and to  be called his people, and are willing to  bear one another’s burdens, that they may be light; Yea, and are willing to  mourn with those that mourn; yea, and comfort those that stand in need of comfort, and to  stand as witnesses of God at all times and in all things, and in all places that ye may be in, even until death, that ye may be redeemed of God, and be numbered with those of the first resurrection, that ye may have eternal life—Now I say unto  you, if this be the desire of your hearts, what have you against being baptized in the name of the Lord, as a witness before him that ye have entered into  a covenant with him, that ye will serve him and keep his commandments, that he may pour out his Spirit more abundantly upon you?",
            "speaker" to "Alma the Elder"
        ),
        mapOf(
            "book" to "3 Nephi",
            "chapter" to "27",
            "verses" to "20",
            "text" to "Now this is the commandment to Repent, all ye ends of the earth, and come unto  me and be baptized in my name, that ye may be sanctified by the reception of the Holy Ghost, that ye may stand spotless before me at the last day.",
            "speaker" to "Jesus Christ"
        ),
        mapOf(
            "book" to "Alma",
            "chapter" to "39",
            "verses" to "9",
            "text" to "Now my son, I would that ye should repent and forsake your sins, and go no more after the lusts of your eyes, but cross yourself in all these things; for except ye do this ye can in nowise inherit the kingdom of God. Oh, remember, and take it upon you, and cross yourself in these things.",
            "speaker" to "Alma the Younger"
        ),
        mapOf(
            "book" to "1 Nephi",
            "chapter" to "3",
            "verses" to "7",
            "text" to "And it came to  pass that I, Nephi, said unto  my father to I will go and do the things which the Lord hath commanded, for I know that the Lord giveth no commandments unto  the children of men, save he shall prepare a way for them that they may accomplish the thing which he commandeth them.",
            "speaker" to "Nephi"
        ),
        mapOf(
            "book" to "Mosiah",
            "chapter" to "2",
            "verses" to "17",
            "text" to "And behold, I tell you these things that ye may learn wisdom; that ye may learn that when ye are in the service of your fellow beings ye are only in the service of your God.",
            "speaker" to "King Benjamin"
        ),
        mapOf(
            "book" to "Mosiah",
            "chapter" to "2",
            "verses" to "41",
            "text" to "And moreover, I would desire that ye should consider on the blessed and happy state of those that keep the commandments of God. For behold, they are blessed in all things, both temporal and spiritual; and if they hold out faithful to  the end they are received into  heaven, that thereby they may dwell with God in a state of never-ending happiness. O remember, remember that these things are true; for the Lord God hath spoken it.",
            "speaker" to "King Benjamin"
        ),
        mapOf(
            "book" to "Alma",
            "chapter" to "41",
            "verses" to "10",
            "text" to "Do not suppose, because it has been spoken concerning resto ration, that ye shall be resto red from sin to  happiness. Behold, I say unto  you, wickedness never was happiness.",
            "speaker" to "Alma the Younger"
        ),
        mapOf(
            "book" to "Moroni",
            "chapter" to "7",
            "verses" to "45,47-48",
            "text" to "And charity suffereth long, and is kind, and envieth not, and is not puffed up, seeketh not her own, is not easily provoked, thinketh no evil, and rejoiceth not in iniquity but rejoiceth in the truth, beareth all things, believeth all things, hopeth all things, endureth all things. But charity is the pure love of Christ, and it endureth forever; and whoso is found possessed of it at the last day, it shall be well with him. Wherefore, my beloved brethren, pray unto  the Father with all the energy of heart, that ye may be filled with this love, which he hath besto wed upon all who are true followers of his Son, Jesus Christ; that ye may become the sons of God; that when he shall appear we shall be like him, for we shall see him as he is; that we may have this hope; that we may be purified even as he is pure. Amen.",
            "speaker" to "Mormon"
        )
    )
    var questionNumber = 0
    var score = 10

    // compareAnswers()
    // function will compare the two answers to see if you got it correct
    // this is the output of the whole text. use this for score tracking and such.
    private fun compareAnswers(pa: String, ca: String) {
        if (pa == ca) {
            correct.setText("Correct")
            nextQ()
        } else {
            correct.setText("False")
            score -= 1
            nextQ()

        }

    }


    //NextQ()
    // this will fill in the quiz and act as the funtion to loop to get a new question on
    fun nextQ(){
        questionNumber += 1
        if (questionNumber <= 10){
            question = getQ()
            makeQ(question)
            displayQ(question)
        } else {
            val intent = Intent(this, Result::class.java)
            startActivity(intent)
            finish()
        }
    }


    //getQ()
    // this function will (in the future) read lines from a json
    // file into the scripture class; (book, chapter, verse, and text)
    fun getQ(): Scripture {
        val i = Math.abs(Random.nextInt() % 24)
        used[0] = i
        var test = Scripture()
        test.setBook(scriptures[i]["book"])
        test.setChapter(scriptures[i]["chapter"])
        test.setVerse(scriptures[i]["verses"])
        test.setText(scriptures[i]["text"])
        test.setSpeaker(scriptures[i]["speaker"])
        return (test)
    }


    //function makeQ()
    // this function will take the scripture and blank out the reference and the speaker
    fun makeQ(scr: Scripture) {
        var questionNumber = 0 // use this for quiz size???
        //change limit size to number of question
        while (questionNumber < 5) {
            questionNumber = getAnswer(scr, questionNumber)
        }
    }


    //getAnswer()
    // this function will take the reverence in the scripture provided
    // and add it to the answerKey
    fun getAnswer(scr: Scripture, id: Int): Int {
        answerKey[0] = scr.getRef()
        return (id + 1)
    }

    var used: Array<Int?> = arrayOfNulls(4)
    // function displayAnswers()
    // this function will display the answer and 3 other random options
    fun displayAnswers(vol: String?) {
        var answers: Array<String?> = arrayOfNulls(4)// the answers to be displayed
        answers[0] = answerKey[0]// the answer will be the first value in this array
        // get the books form the BOM
        if (vol == "BOM") {

            for (i in (1..3)) {// add them to the books
                var j = Math.abs(Random.nextInt() % 24)
                while (j in used){
                    j = Math.abs(Random.nextInt() % 24)
                }
                answers[i] =
                    (scriptures[j]["book"] + " " + scriptures[j]["chapter"] + ":" + scriptures[j]["verses"])
                used[i] = j
            }
            // insert the correct answer

            //shuffle the answers
            answers.shuffle()
            // display the answers
            opt1.setText(answers[0].toString())
            opt2.setText(answers[1].toString())
            opt3.setText(answers[2].toString())
            opt4.setText(answers[3].toString())
        }
    }



    // Function display()
    // this will be used to display the question
    fun displayQ(refr: Scripture) {
        scrip.setText(refr.getText().toString())
        displayAnswers("BOM")
    }


    //Function onCreate()
    //This function will assign all the objects to their proper id's in
    // the xml file when the app is opened
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        opt1 = findViewById(R.id.op1)
        opt2 = findViewById(R.id.op2)
        opt3 = findViewById(R.id.op3)
        opt4 = findViewById(R.id.op4)
        scrip = findViewById(R.id.scripture)
        correct = findViewById(R.id.pass)

        nextQ()
    }


    //what happens if button is clicked
    fun onClick(view: View) {
        var playerAnswer: String
        val correctAnswer = answerKey[0].toString()
        when (view.getId()) {
            R.id.op1 -> {
                playerAnswer = opt1.getText().toString()
                compareAnswers(playerAnswer, correctAnswer)
            }
            R.id.op2 -> {
                playerAnswer = opt2.getText().toString()
                compareAnswers(playerAnswer, correctAnswer)
            }
            R.id.op3 -> {
                playerAnswer = opt3.getText().toString()
                compareAnswers(playerAnswer, correctAnswer)
            }
            R.id.op4 -> {
                playerAnswer = opt4.getText().toString()
                compareAnswers(playerAnswer, correctAnswer)
            }
        }
    }

}
