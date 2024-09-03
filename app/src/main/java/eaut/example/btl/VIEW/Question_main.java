package eaut.example.btl.VIEW;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import eaut.example.btl.DATA.QuizDbHelper;
import eaut.example.btl.DATA.Question;
import eaut.example.btl.R;

public class Question_main extends AppCompatActivity {

    Button btn_back1;
    TextView tvQuestionNumber, tvQuestion, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    int currentQuestion = 0;
    int score = 0;
    List<Question> questionList;
    QuizDbHelper dbHelper;

    Drawable blueDrawable;
    Drawable yellowDrawable;
    Drawable greenDrawable;
    Drawable redDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_back1 = findViewById(R.id.btn_back1);
        btn_back1.setOnClickListener(view -> finish());

        // Ánh xạ các TextView
        tvQuestion = findViewById(R.id.tv_content_question);
        tvQuestionNumber = findViewById(R.id.tv_question_number);
        tvAnswer1 = findViewById(R.id.tv_answer1);
        tvAnswer2 = findViewById(R.id.tv_answer2);
        tvAnswer3 = findViewById(R.id.tv_answer3);
        tvAnswer4 = findViewById(R.id.tv_answer4);

        // Lấy các drawable resource
        yellowDrawable = ContextCompat.getDrawable(this, R.drawable.bg_yellow);
        blueDrawable = ContextCompat.getDrawable(this, R.drawable.txt_answer_edit);
        greenDrawable = ContextCompat.getDrawable(this, R.drawable.bg_green);
        redDrawable = ContextCompat.getDrawable(this, R.drawable.bg_red);

        // Khởi tạo QuizDbHelper và lấy câu hỏi từ cơ sở dữ liệu
        dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getAllQuestions();

        // Hiển thị câu hỏi đầu tiên
        if (!questionList.isEmpty()) {
            loadQuestion(currentQuestion);
        } else {
            Toast.makeText(this, "Không có câu hỏi trong cơ sở dữ liệu!", Toast.LENGTH_SHORT).show();
        }

        // Gán sự kiện khi người dùng chọn đáp án
        tvAnswer1.setOnClickListener(view -> checkAnswer(0, tvAnswer1));
        tvAnswer2.setOnClickListener(view -> checkAnswer(1, tvAnswer2));
        tvAnswer3.setOnClickListener(view -> checkAnswer(2, tvAnswer3));
        tvAnswer4.setOnClickListener(view -> checkAnswer(3, tvAnswer4));
    }

    @SuppressLint("SetTextI18n")
    private void loadQuestion(int questionIndex) {
        // Lấy câu hỏi hiện tại từ danh sách câu hỏi
        Question current = questionList.get(questionIndex);

        // Cập nhật câu hỏi và đáp án
        tvQuestion.setText(current.getQuestion());
        tvQuestionNumber.setText("Câu hỏi " + (questionIndex + 1));
        tvAnswer1.setText(current.getOption1());
        tvAnswer2.setText(current.getOption2());
        tvAnswer3.setText(current.getOption3());
        tvAnswer4.setText(current.getOption4());

        // Đặt nền cho các đáp án
        tvAnswer1.setBackground(blueDrawable);
        tvAnswer2.setBackground(blueDrawable);
        tvAnswer3.setBackground(blueDrawable);
        tvAnswer4.setBackground(blueDrawable);
    }

    private void checkAnswer(int selectedAnswerIndex, TextView selectedAnswer) {
        // Lấy câu trả lời đúng từ câu hỏi hiện tại
        int correctAnswerIndex = questionList.get(currentQuestion).getAnswerNr() - 1;  // Chỉ số bắt đầu từ 0

        // Đổi màu đáp án đã chọn thành màu vàng ngay khi người dùng chọn
        selectedAnswer.setBackground(yellowDrawable);

        // Vô hiệu hóa sự kiện click cho tất cả các đáp án
        tvAnswer1.setEnabled(false);
        tvAnswer2.setEnabled(false);
        tvAnswer3.setEnabled(false);
        tvAnswer4.setEnabled(false);

        // Sử dụng Handler để trì hoãn kiểm tra đáp án sau 2 giây
        new Handler().postDelayed(() -> {
            // Đổi màu của tất cả các đáp án sau khi đã đợi 2 giây
            TextView[] allAnswers = {tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4};
            boolean isCorrect = (selectedAnswerIndex == correctAnswerIndex);

            if (isCorrect) {
                // Đáp án đúng
                selectedAnswer.setBackground(greenDrawable);  // Đổi màu thành xanh nếu đúng
                score++;  // Tăng điểm số

                // Hiển thị đáp án đúng bằng cách đổi màu nền của đáp án đúng thành màu xanh
                for (int i = 0; i < allAnswers.length; i++) {
                    if (i == correctAnswerIndex) {
                        allAnswers[i].setBackground(greenDrawable);
                    } else {
                        allAnswers[i].setBackground(redDrawable);  // Đổi màu đáp án sai thành đỏ
                    }
                }

                // Trì hoãn 1 giây trước khi chuyển sang câu hỏi tiếp theo nếu đúng
                new Handler().postDelayed(() -> {
                    if (currentQuestion < questionList.size() - 1) {
                        currentQuestion++;
                        loadQuestion(currentQuestion);
                        // Kích hoạt lại sự kiện click sau khi chuyển sang câu hỏi tiếp theo
                        enableAnswerClick();
                    } else {
                        // Chuyển sang màn hình Score
                        navigateToScore();
                    }
                }, 1000);  // Trì hoãn 1 giây

            } else {
                selectedAnswer.setBackground(redDrawable);
                // Hiển thị đáp án đúng bằng cách đổi màu nền của đáp án đúng thành màu xanh
                for (int i = 0; i < allAnswers.length; i++) {
                    if (i == correctAnswerIndex) {
                        allAnswers[i].setBackground(greenDrawable);
                    }
                }

                // Trì hoãn 1 giây rồi kết thúc trò chơi
                new Handler().postDelayed(() -> {
                    navigateToScore();
                    finish();
                }, 1000);
            }
        }, 1000);  // Trì hoãn 1 giây trước khi kiểm tra đáp án
    }

    // Phương thức kích hoạt lại sự kiện click cho các đáp án
    private void enableAnswerClick() {
        tvAnswer1.setEnabled(true);
        tvAnswer2.setEnabled(true);
        tvAnswer3.setEnabled(true);
        tvAnswer4.setEnabled(true);
    }

    // Chuyển sang màn hình Score (Final Score Activity)
    private void navigateToScore() {
        Intent intent = new Intent(Question_main.this, final_Score.class);
        intent.putExtra("SCORE", score);
        intent.putExtra("TOTAL_QUESTIONS", questionList.size());
        startActivity(intent);
        finish();
    }
}