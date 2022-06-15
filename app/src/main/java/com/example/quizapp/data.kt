package com.example.quizapp

object Data {

    const val USER_NAME: String="user_name"
    const val TOTAL_QS: String="total_questions"
    const val CORRECT_ANS:String="correct_answers"


    fun getQuestions():ArrayList<Questions>{
        val questionsList=ArrayList<Questions>()
        val q1= Questions(
        1,"What country does this flag belong to?",
        R.drawable.ic_flag_of_argentina,
        "INDIA","MEXICO","AMERICA","ARGENTINA",4)
        questionsList.add(q1)

        val q2= Questions(
            2,"What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "AUSTRALIA","SRI LANKA","AMERICA","ARGENTINA",1)
        questionsList.add(q2)

        val q3= Questions(
            3,"What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "INDIA","NEPAL","BELGIUM","ARGENTINA",3)
        questionsList.add(q3)

        val q4= Questions(
            4,"What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "INDIA","BRAZIL","AMERICA","ARGENTINA",2)
        questionsList.add(q4)

        val q5= Questions(
            5,"What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "INDIA","CANADA","DENMARK","ARGENTINA",3)
        questionsList.add(q5)

        val q6= Questions(
            6,"What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "FIJI","SOUTH AFRICA","AMERICA","ARGENTINA",1)
        questionsList.add(q6)

        val q7= Questions(
            7,"What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "INDIA","MALDIVES","AMERICA","GERMANY",4)
        questionsList.add(q7)

        val q8= Questions(
            8,"What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "INDIA","PAKISTAN","AMERICA","ARGENTINA",1)
        questionsList.add(q8)

        val q9= Questions(
            9,"What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "AFGHANISTAN","DUBAI","OMAN","KUWAIT",4)
        questionsList.add(q9)

        val q10= Questions(
            10,"What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "INDIA","NEW ZEALAND ","AMERICA","ARGENTINA",2)
        questionsList.add(q10)






        return questionsList


    }

}