package eaut.example.btl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Question_main extends AppCompatActivity {

    Button btn_back1;
    TextView tvQuestionNumber, tvQuestion, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    int currentQuestion = 0;
    int score = 0;

    // Câu hỏi và đáp án
    String[] questions = {
            "Cái gì tốt nhất?",
            "Đáp án nào là đúng?",
            "Đáp án nào là Sai?"
    };

    String[][] answers = {
            {"chân", "tất", "Tiền", "Đồ ăn"},
            {"Đúng", "Sai", "Sai", "Sai"},
            {"Sai", "Sai", "Sai", "Đúng"}
    };

    int[] correctAnswers = {2, 0, 3};

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

        // Hiển thị câu hỏi đầu tiên
        loadQuestion(currentQuestion);

        // Gán sự kiện khi người dùng chọn đáp án
        tvAnswer1.setOnClickListener(view -> checkAnswer(0, tvAnswer1));
        tvAnswer2.setOnClickListener(view -> checkAnswer(1, tvAnswer2));
        tvAnswer3.setOnClickListener(view -> checkAnswer(2, tvAnswer3));
        tvAnswer4.setOnClickListener(view -> checkAnswer(3, tvAnswer4));
    }

    @SuppressLint("SetTextI18n")
    private void loadQuestion(int questionIndex) {
        // Cập nhật câu hỏi và đáp án
        tvQuestion.setText(questions[questionIndex]);
        tvQuestionNumber.setText("Câu hỏi " + (questionIndex + 1));
        tvAnswer1.setText(answers[questionIndex][0]);
        tvAnswer2.setText(answers[questionIndex][1]);
        tvAnswer3.setText(answers[questionIndex][2]);
        tvAnswer4.setText(answers[questionIndex][3]);

        // Đặt nền cho các đáp án
        tvAnswer1.setBackground(blueDrawable);
        tvAnswer2.setBackground(blueDrawable);
        tvAnswer3.setBackground(blueDrawable);
        tvAnswer4.setBackground(blueDrawable);
    }

    private void checkAnswer(int selectedAnswerIndex, TextView selectedAnswer) {
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
            boolean isCorrect = (selectedAnswerIndex == correctAnswers[currentQuestion]);

            if (isCorrect) {
                // Đáp án đúng
                selectedAnswer.setBackground(greenDrawable);  // Đổi màu thành xanh nếu đúng
                score++;  // Tăng điểm số

                // Hiển thị đáp án đúng bằng cách đổi màu nền của đáp án đúng thành màu xanh
                for (int i = 0; i < allAnswers.length; i++) {
                    if (i == correctAnswers[currentQuestion]) {
                        allAnswers[i].setBackground(greenDrawable);
                    } else {
                        allAnswers[i].setBackground(redDrawable);  // Đổi màu đáp án sai thành đỏ
                    }
                }

                // Trì hoãn 1 giây trước khi chuyển sang câu hỏi tiếp theo nếu đúng
                new Handler().postDelayed(() -> {
                    if (currentQuestion < questions.length - 1) {
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
                    if (i == correctAnswers[currentQuestion]) {
                        allAnswers[i].setBackground(greenDrawable);
                    }
                }

                // Trì hoãn 1 giây rồi kết thúc trò chơi
                new Handler().postDelayed(() -> {
                    navigateToScore();
                    Toast.makeText(this, "Sai rồi! Trò chơi kết thúc.", Toast.LENGTH_SHORT).show();
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
        intent.putExtra("TOTAL_QUESTIONS", questions.length);
        startActivity(intent);
        finish();
    }
}
