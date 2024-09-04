package eaut.example.btl.DATA;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseInitializer {

    // Phương thức để thêm dữ liệu câu hỏi cho mức độ dễ
    public static void addEasyQuestions(SQLiteDatabase db) {
        String[] easyQuestions = {
                "Đâu là thủ đô của Việt Nam?",
                "Sông nào dài nhất thế giới?",
                "Ai là tác giả của truyện ngắn 'Lão Hạc'?",
                // Thêm 7 câu hỏi dễ khác
        };

        String[][] easyAnswers = {
                {"Hà Nội", "Sài Gòn", "Đà Nẵng", "Huế"},
                {"Sông Nile", "Sông Amazon", "Sông Hằng", "Sông Mekong"},
                {"Nam Cao", "Nguyễn Du", "Ngô Tất Tố", "Tố Hữu"},
                // Thêm đáp án cho các câu hỏi dễ khác
        };

        int[] easyCorrectAnswers = {1, 1, 1}; // Đáp án đúng tương ứng
        addQuestionsToDatabase(db, easyQuestions, easyAnswers, easyCorrectAnswers, 1);
    }

    // Phương thức để thêm dữ liệu câu hỏi cho mức độ vừa
    public static void addMediumQuestions(SQLiteDatabase db) {
        String[] mediumQuestions = {
                "Hành tinh nào gần mặt trời nhất?",
                "Trong bảng tuần hoàn, ký hiệu hóa học của vàng là gì?",
                "Vị vua nào là người sáng lập triều đại nhà Nguyễn?",
                // Thêm 7 câu hỏi vừa khác
        };

        String[][] mediumAnswers = {
                {"Sao Kim", "Sao Thủy", "Sao Hỏa", "Sao Mộc"},
                {"Au", "Ag", "Pt", "Pb"},
                {"Gia Long", "Minh Mạng", "Tự Đức", "Bảo Đại"},
                // Thêm đáp án cho các câu hỏi vừa khác
        };

        int[] mediumCorrectAnswers = {2, 1, 1}; // Đáp án đúng tương ứng
        addQuestionsToDatabase(db, mediumQuestions, mediumAnswers, mediumCorrectAnswers, 2);
    }

    // Phương thức để thêm dữ liệu câu hỏi cho mức độ khó
    public static void addHardQuestions(SQLiteDatabase db) {
        String[] hardQuestions = {
                "Lực lượng đặc biệt của Đức quốc xã gọi là gì?",
                "Nhà khoa học nào khám phá ra penicillin?",
                "Đại dương nào lớn nhất trên Trái đất?",
                // Thêm 7 câu hỏi khó khác
        };

        String[][] hardAnswers = {
                {"SS", "Gestapo", "Wehrmacht", "Luftwaffe"},
                {"Marie Curie", "Alexander Fleming", "Albert Einstein", "Isaac Newton"},
                {"Thái Bình Dương", "Đại Tây Dương", "Ấn Độ Dương", "Bắc Băng Dương"},
                // Thêm đáp án cho các câu hỏi khó khác
        };

        int[] hardCorrectAnswers = {1, 2, 1}; // Đáp án đúng tương ứng
        addQuestionsToDatabase(db, hardQuestions, hardAnswers, hardCorrectAnswers, 3);
    }

    // Phương thức để thêm câu hỏi vào cơ sở dữ liệu
    private static void addQuestionsToDatabase(SQLiteDatabase db, String[] questions, String[][] answers, int[] correctAnswers, int level) {
        for (int i = 0; i < questions.length; i++) {
            ContentValues cv = new ContentValues();
            cv.put(QuizContract.QuestionTable.COLUMN_QUESTION, questions[i]);
            cv.put(QuizContract.QuestionTable.COLUMN_OPTION1, answers[i][0]);
            cv.put(QuizContract.QuestionTable.COLUMN_OPTION2, answers[i][1]);
            cv.put(QuizContract.QuestionTable.COLUMN_OPTION3, answers[i][2]);
            cv.put(QuizContract.QuestionTable.COLUMN_OPTION4, answers[i][3]);
            cv.put(QuizContract.QuestionTable.COLUMN_ANSWER_NR, correctAnswers[i]);
            cv.put(QuizContract.QuestionTable.COLUMN_LEVEL, level);  // Thêm mức độ câu hỏi
            db.insert(QuizContract.QuestionTable.TABLE_NAME, null, cv);
        }
    }
}
