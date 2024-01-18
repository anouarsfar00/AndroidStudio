package com.example.quizz;

import android.provider.BaseColumns;

public final class QuizContract {
    private QuizContract(){}

    public static class QuestionsTable implements BaseColumns {
        public static final String Table_name="Quiz_questions";
        public static final String Column_question="question";
        public static final String Column_option1="Option1";
        public static final String Column_option2="Option2";
        public static final String Column_option3="Option3";
        public static final String Column_ANSWER_Nr="Answer_Nr";

    }
}
