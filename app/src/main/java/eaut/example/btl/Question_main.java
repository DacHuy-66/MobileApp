package eaut.example.btl;

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

    // Câu hỏi và đáp án
    String[] questions = {
            "Câu hỏi 1: cái j tốt nhất?",
            "Câu hỏi 2: Đáp án nào là đúng?",
            "Câu hỏi 3: Đáp án nào là Sai?"
    };

    String[][] answers = {
            {"chân", "tất", "Tiền", "Đồ ăn"},
            {"Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D"},
            {"Đáp án X", "Đáp án Y", "Đáp án Z", "Đáp án W"}
    };

    int[] correctAnswers = {2, 0, 3};  // Chỉ mục của đáp án đúng

    // Drawable resources for answer backgrounds
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
        tvQuestionNumber = findViewById(R.id.tv_question_number);  // Ánh xạ TextView hiển thị số câu hỏi
        tvAnswer1 = findViewById(R.id.tv_answer1);
        tvAnswer2 = findViewById(R.id.tv_answer2);
        tvAnswer3 = findViewById(R.id.tv_answer3);
        tvAnswer4 = findViewById(R.id.tv_answer4);

        // Lấy các drawable resource
        yellowDrawable = ContextCompat.getDrawable(this, R.drawable.txt_answer_edit);
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

    private void loadQuestion(int questionIndex) {
        // Cập nhật câu hỏi và đáp án
        tvQuestion.setText(questions[questionIndex]);
        tvQuestionNumber.setText("Câu hỏi " + (questionIndex + 1));  // Hiển thị số thứ tự của câu hỏi
        tvAnswer1.setText(answers[questionIndex][0]);
        tvAnswer2.setText(answers[questionIndex][1]);
        tvAnswer3.setText(answers[questionIndex][2]);
        tvAnswer4.setText(answers[questionIndex][3]);

        // Đặt nền cho các đáp án
        tvAnswer1.setBackground(yellowDrawable);
        tvAnswer2.setBackground(yellowDrawable);
        tvAnswer3.setBackground(yellowDrawable);
        tvAnswer4.setBackground(yellowDrawable);
    }

    private void checkAnswer(int selectedAnswerIndex, TextView selectedAnswer) {

        // Chuyển màu đáp án đã chọn thành màu vàng
        selectedAnswer.setBackground(yellowDrawable);

        // Đổi màu của tất cả các đáp án sau khi chọn
        TextView[] allAnswers = {tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4};
        boolean isCorrect = (selectedAnswerIndex == correctAnswers[currentQuestion]);

        if (isCorrect) {
            // Đáp án đúng
            selectedAnswer.setBackground(greenDrawable);  // Đổi màu thành xanh nếu đúng

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
                } else {
                    Toast.makeText(this, "Bạn đã hoàn thành tất cả câu hỏi!", Toast.LENGTH_SHORT).show();
                    finish();  // Kết thúc nếu hoàn thành tất cả câu hỏi
                }
            }, 1000);  // Trì hoãn 1 giây

        } else {
            // Đáp án sai
            // Đổi màu nền của đáp án đã chọn thành đỏ
            selectedAnswer.setBackground(redDrawable);

            // Đổi màu đáp án đúng thành màu xanh
            for (int i = 0; i < allAnswers.length; i++) {
                if (i == correctAnswers[currentQuestion]) {
                    allAnswers[i].setBackground(greenDrawable);
                }
            }

            // Trì hoãn 1 giây rồi kết thúc activity
            new Handler().postDelayed(() -> {
                Toast.makeText(this, "Đáp án sai! Trò chơi kết thúc.", Toast.LENGTH_SHORT).show();
                finish();  // Kết thúc sau 1 giây
            }, 1000);  // Trì hoãn 1 giây
        }
    }
}
