package com.example.myquizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestions() : ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1, "다음 국기는 어느 나라의 국기인가요?",
            R.drawable.ic_flag_of_argentina,
            "아르헨티나", "오스트레일리아",
            "아르메니아", "오스트리아",
            1
        )
        questionsList.add(que1)

        val que2 = Question(
            2, "다음 국기는 어느 나라의 국기인가요?",
            R.drawable.ic_flag_of_australia,
            "아르헨티나", "오스트레일리아",
            "아르메니아", "오스트리아",
            2
        )
        questionsList.add(que2)

        val que3 = Question(
            3, "다음 국기는 어느 나라의 국기인가요?",
            R.drawable.ic_flag_of_belgium,
            "아르헨티나", "오스트레일리아",
            "벨기에", "오스트리아",
            3
        )
        questionsList.add(que3)

        val que4 = Question(
            4, "다음 국기는 어느 나라의 국기인가요?",
            R.drawable.ic_flag_of_brazil,
            "아르헨티나", "오스트레일리아",
            "아르메니아", "브라질",
            4
        )
        questionsList.add(que4)

        val que5 = Question(
            5, "다음 국기는 어느 나라의 국기인가요?",
            R.drawable.ic_flag_of_denmark,
            "덴마크", "뉴질랜드",
            "브라질", "독일",
            1
        )
        questionsList.add(que5)

        val que6 = Question(
            6, "다음 국기는 어느 나라의 국기인가요?",
            R.drawable.ic_flag_of_fiji,
            "인도", "피지",
            "필리핀", "뉴질랜드",
            2
        )
        questionsList.add(que6)

        val que7 = Question(
            7, "다음 국기는 어느 나라의 국기인가요?",
            R.drawable.ic_flag_of_germany,
            "영국", "프랑스",
            "독일", "벨기에",
            3
        )
        questionsList.add(que7)

        val que8 = Question(
            8, "다음 국기는 어느 나라의 국기인가요?",
            R.drawable.ic_flag_of_india,
            "인도네시아", "태국",
            "필리핀", "인도",
            4
        )
        questionsList.add(que8)

        val que9 = Question(
            9, "다음 국기는 어느 나라의 국기인가요?",
            R.drawable.ic_flag_of_kuwait,
            "정답 없음", "오스트레일리아",
            "이집트", "오스트리아",
            1
        )
        questionsList.add(que9)
        return questionsList
    }
}