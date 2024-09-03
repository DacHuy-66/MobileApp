package eaut.example.btl.VIEW;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import eaut.example.btl.R;

public class Score extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);

        // Get the question number passed from Question_main
        int currentQuestion = getIntent().getIntExtra("QUESTION_NUMBER", 0);

        // Highlight the corresponding score TextView
        highlightScore(currentQuestion);

        // Delay for 3 seconds before transitioning to Question_main
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Score.this, Question_main.class);
            // Pass the question number back to Question_main
            intent.putExtra("QUESTION_NUMBER", currentQuestion);
            startActivity(intent);
            finish();
        }, 2000);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void highlightScore(int questionNumber) {
        // Array of TextView IDs for the score levels
        int[] scoreTextViewIds = {
                R.id.bac10, R.id.bac9, R.id.bac8, R.id.bac7, R.id.bac6,
                R.id.bac5, R.id.bac4, R.id.bac3, R.id.bac2, R.id.bac1
        };

        // Ensure questionNumber is within valid range
        if (questionNumber >= 0 && questionNumber < scoreTextViewIds.length) {
            // Get the corresponding TextView
            TextView scoreTextView = findViewById(scoreTextViewIds[questionNumber]);
            scoreTextView.setBackgroundResource(R.drawable.txt_answer_edit_yellow);

        }
    }
}
