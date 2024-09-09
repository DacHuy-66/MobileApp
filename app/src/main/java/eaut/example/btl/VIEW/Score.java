package eaut.example.btl.VIEW;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import eaut.example.btl.R;

public class Score extends AppCompatActivity {

    private TextView countdownText;
    private Button btnStart;
    private CountDownTimer countDownTimer;
    private boolean isCountdownFinished = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);

        // Nhận mức độ khó được chuyển từ Lever
        int difficultyLevel = getIntent().getIntExtra("DIFFICULTY_LEVEL", 1);

        countdownText = findViewById(R.id.textView12);
        btnStart = findViewById(R.id.btn_tieptuc);

        // Xử lý sự kiện nhấn nút "Bắt đầu luôn"
        btnStart.setOnClickListener(view -> {
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            navigateToQuestionMain(difficultyLevel);
        });

        // Bắt đầu đếm ngược trước khi điều hướng đến Question_main
        startCountdownTimer(difficultyLevel);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void startCountdownTimer(int difficultyLevel) {
        // Tạo đồng hồ đếm ngược trong 10 giây
        countDownTimer = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                countdownText.setText("Bắt đầu sau " + millisUntilFinished / 1000 + " giây");
            }

            public void onFinish() {
                if (!isCountdownFinished) {
                    navigateToQuestionMain(difficultyLevel);
                }
            }

        }.start();
    }

    private void navigateToQuestionMain(int difficultyLevel) {
        isCountdownFinished = true;
        Intent intent = new Intent(Score.this, Question_main.class);
        intent.putExtra("DIFFICULTY_LEVEL", difficultyLevel);
        startActivity(intent);
        finish();
    }
}
