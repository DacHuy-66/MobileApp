package eaut.example.btl.VIEW;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import eaut.example.btl.R;

public class final_Score extends AppCompatActivity {

    TextView tvEndMessage, tvEndScore;
    Button btnPlayAgain, btnBack;
    int score;
    int totalQuestions;

    // Mảng thông báo dựa trên điểm
    private final String[] messages = {
            "Wow, Thật luôn! Không một câu nào?",
            "Một câu hỏi đúng? Thật ấn tượng... theo kiểu ngược lại.",
            "Chúc mừng! Bạn đã trả lời đúng 2 câu hỏi. Bạn chắc chắn đang đi đúng hướng… dù là chậm.",
            "Bạn trả lời đúng 3 câu hỏi. Không tệ! Ít nhất bạn biết cách nhận diện câu hỏi.",
            "4 câu hỏi đúng? Wow, bạn có vẻ như đang lạc lối trong một mê cung của trí nhớ.",
            "5 câu hỏi đúng! Bạn không hoàn toàn mù mịt. Có lẽ bạn chỉ cần chút may mắn thêm.",
            "Bạn đã trả lời đúng 6 câu hỏi. Lên nào, bạn đang trên đường trở thành nhà thông thái.",
            "Chúc mừng bạn với 7 câu trả lời đúng! Bạn có phải là người xem nhiều quiz trên TV không?",
            "8 câu hỏi đúng? Bạn có thể muốn cân nhắc làm việc với các chuyên gia trí tuệ.",
            "9 câu hỏi đúng! Bạn có bí quyết gì không? Hay bạn là một thiên tài bất ngờ?",
            "Tất cả câu hỏi đều đúng! Chúc mừng, bạn đã làm tốt đến mức không ai có thể vượt qua bạn. Chắc vậy"
    };

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final_score);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Khởi tạo các views
        tvEndMessage = findViewById(R.id.tv_end);
        tvEndScore = findViewById(R.id.tv_end_score);
        btnPlayAgain = findViewById(R.id.btn_playagain);
        btnBack = findViewById(R.id.btn_back);

        // Nhận điểm và tổng số câu hỏi từ Intent
        Intent intent = getIntent();
        score = intent.getIntExtra("SCORE", 0);
        totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 0);

        // Tính toán thông báo dựa trên điểm số
        int index = Math.min(score, 10);
        tvEndMessage.setText(messages[index]);

        tvEndScore.setText("Điểm của bạn: " + score);

        btnPlayAgain.setOnClickListener(v -> {
            Intent replayIntent = new Intent(final_Score.this, Lever.class);
            startActivity(replayIntent);
            finish();
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
