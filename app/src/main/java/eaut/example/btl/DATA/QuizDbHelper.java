package eaut.example.btl.DATA;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QT.db";
    private static final int DATABASE_VERSION = 5;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " + QuizContract.QuestionTable.TABLE_NAME + " (" +
                QuizContract.QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizContract.QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuizContract.QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuizContract.QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuizContract.QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuizContract.QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuizContract.QuestionTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuizContract.QuestionTable.COLUMN_LEVEL + " INTEGER" +  // Thêm cột level
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);

        // Thêm câu hỏi vào cơ sở dữ liệu theo từng mức độ
        DatabaseInitializer.addEasyQuestions(db);   // Thêm câu hỏi mức độ dễ
        DatabaseInitializer.addMediumQuestions(db); // Thêm câu hỏi mức độ vừa
        DatabaseInitializer.addHardQuestions(db);   // Thêm câu hỏi mức độ khó
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xóa bảng cũ và tạo lại bảng mới nếu cơ sở dữ liệu được nâng cấp
        db.execSQL("DROP TABLE IF EXISTS " + QuizContract.QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    // Phương thức để lấy tất cả các câu hỏi từ cơ sở dữ liệu
    @SuppressLint("Range")
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuizContract.QuestionTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuizContract.QuestionTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    // Phương thức để lấy câu hỏi theo mức độ
    @SuppressLint("Range")
    public List<Question> getQuestionsByLevel(int level) {
        List<Question> questions = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = QuizContract.QuestionTable.COLUMN_LEVEL + " = ?";
        String[] selectionArgs = { String.valueOf(level) };
        Cursor cursor = db.query(
                QuizContract.QuestionTable.TABLE_NAME,
                null, // Select all columns
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            do {
                String questionText = cursor.getString(cursor.getColumnIndex(QuizContract.QuestionTable.COLUMN_QUESTION));
                String option1 = cursor.getString(cursor.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION1));
                String option2 = cursor.getString(cursor.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION2));
                String option3 = cursor.getString(cursor.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION3));
                String option4 = cursor.getString(cursor.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION4));
                int answerNr = cursor.getInt(cursor.getColumnIndex(QuizContract.QuestionTable.COLUMN_ANSWER_NR));
                questions.add(new Question(questionText, option1, option2, option3, option4, answerNr));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return questions;
    }
    // Phương thức để lấy câu hỏi ngẫu nhiên theo mức độ
    @SuppressLint("Range")
    public List<Question> getRandomQuestionsByLevel(int level) {
        List<Question> allQuestions = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = QuizContract.QuestionTable.COLUMN_LEVEL + " = ?";
        String[] selectionArgs = { String.valueOf(level) };
        Cursor cursor = db.query(
                QuizContract.QuestionTable.TABLE_NAME,
                null, // Select all columns
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            do {
                String questionText = cursor.getString(cursor.getColumnIndex(QuizContract.QuestionTable.COLUMN_QUESTION));
                String option1 = cursor.getString(cursor.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION1));
                String option2 = cursor.getString(cursor.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION2));
                String option3 = cursor.getString(cursor.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION3));
                String option4 = cursor.getString(cursor.getColumnIndex(QuizContract.QuestionTable.COLUMN_OPTION4));
                int answerNr = cursor.getInt(cursor.getColumnIndex(QuizContract.QuestionTable.COLUMN_ANSWER_NR));
                allQuestions.add(new Question(questionText, option1, option2, option3, option4, answerNr));
            } while (cursor.moveToNext());
        }
        cursor.close();

        // Trộn ngẫu nhiên danh sách câu hỏi
        Collections.shuffle(allQuestions);

        return allQuestions;
    }
}
