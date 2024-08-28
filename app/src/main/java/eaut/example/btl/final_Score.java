package eaut.example.btl;

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

public class final_Score extends AppCompatActivity {

    TextView tvEndMessage, tvEndScore;
    Button btnPlayAgain, btnBack;
    int score;

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

        // Khởi to các views
        tvEndMessage = findViewById(R.id.tv_end);
        tvEndScore = findViewById(R.id.tv_end_score);
        btnPlayAgain = findViewById(R.id.btn_playagain);
        btnBack = findViewById(R.id.btn_back2);

        // Nhận điểm từ Question_main activity
        Intent intent = getIntent();
        score = intent.getIntExtra("SCORE", 0);

        tvEndMessage.setText("Trò chơi kết thúc!");
        tvEndScore.setText("Điểm của bạn: " + score);


        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replayIntent = new Intent(final_Score.this, Score.class);
                startActivity(replayIntent);
                finish();
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
