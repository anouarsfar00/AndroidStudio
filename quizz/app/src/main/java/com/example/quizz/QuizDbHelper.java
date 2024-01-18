package com.example.quizz;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.quizz.QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyAwesomeQuiz_db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public QuizDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " + QuestionsTable.Table_name + "(" +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.Column_question + "TEXT, " +
                QuestionsTable.Column_option1 + "TEXT, " +
                QuestionsTable.Column_option2 + "TEXT, " +
                QuestionsTable.Column_option3 + "TEXT, " +
                QuestionsTable.Column_ANSWER_Nr + "INTEGER " +
                " )";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.Table_name);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("A is correct", "A", "B", "C", 1);
        addQuestion(q1);
        Question q2 = new Question("B is correct", "A", "B", "C", 2);
        addQuestion(q2);
        Question q3 = new Question("C is correct", "A", "B", "C", 3);
        addQuestion(q3);
        Question q4 = new Question("A is correct again", "A", "B", "C", 1);
        addQuestion(q4);
        Question q5 = new Question("B is correct again", "A", "B", "C", 2);
        addQuestion(q5);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.Column_question, question.getQuestion());

        cv.put(QuestionsTable.Column_option1, question.getOption1());
        cv.put(QuestionsTable.Column_option2, question.getOption2());
        cv.put(QuestionsTable.Column_option3, question.getOption3());
        cv.put(QuestionsTable.Column_ANSWER_Nr, question.getAnswerNr());
        db.insert(QuestionsTable.Table_name, null, cv);

    }





    @SuppressLint("Range")
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery(" SELECT * FROM " + QuestionsTable.Table_name, null);

       if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.Column_question)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.Column_option1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.Column_option2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.Column_option3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.Column_ANSWER_Nr)));
                questionList.add(question);

            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }


}


