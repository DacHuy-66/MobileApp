package eaut.example.btl.DATA;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseInitializer {

    // Phương thức để thêm dữ liệu câu hỏi vào cơ sở dữ liệu
    public static void addInitialQuestions(SQLiteDatabase db) {
        String[] questions = {
                "Đâu là thủ đô của Pháp?",
                "Trong hệ mặt trời, hành tinh nào là lớn nhất?",
                "Ai là tác giả của tác phẩm \"Đại chiến thế giới thứ ba\"?"
        };

        String[][] answers = {
                {"Berlin", "Madrid", "Paris", "Rome"},
                {"Sao Hỏa", "Sao Kim", "Sao Mộc", "Sao Thổ"},
                {"J.K. Rowling", "George Orwell", "J.R.R. Tolkien", "H.G. Wells"}
        };

        int[] correctAnswers = {3, 3, 4};

        for (int i = 0; i < questions.length; i++) {
            ContentValues cv = new ContentValues();
            cv.put(QuizContract.QuestionTable.COLUMN_QUESTION, questions[i]);
            cv.put(QuizContract.QuestionTable.COLUMN_OPTION1, answers[i][0]);
            cv.put(QuizContract.QuestionTable.COLUMN_OPTION2, answers[i][1]);
            cv.put(QuizContract.QuestionTable.COLUMN_OPTION3, answers[i][2]);
            cv.put(QuizContract.QuestionTable.COLUMN_OPTION4, answers[i][3]);
            cv.put(QuizContract.QuestionTable.COLUMN_ANSWER_NR, correctAnswers[i]);
            db.insert(QuizContract.QuestionTable.TABLE_NAME, null, cv);
        }
    }
}
