package eaut.example.btl.VIEW;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import eaut.example.btl.R;

public class Lever extends AppCompatActivity {

    Button btn_easy;
    Button btn_medium;
    Button btn_difficult;
    Button btn_back3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lever);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_back3 = findViewById(R.id.btn_back3);
        btn_back3.setOnClickListener(view -> finish());

        btn_easy = findViewById(R.id.btn_easy);
        btn_easy.setOnClickListener(view -> navigateToScore(1));

        btn_medium = findViewById(R.id.btn_medium);
        btn_medium.setOnClickListener(view -> navigateToScore(2));

        btn_difficult = findViewById(R.id.btn_difficult);
        btn_difficult.setOnClickListener(view -> navigateToScore(3));
    }

    // Điều hướng đến hoạt động Điểm với mức độ khó đã chọn
    private void navigateToScore(int difficultyLevel) {
        Intent intent = new Intent(Lever.this, Score.class);
        // Vượt qua mức độ khó để ghi điểm
        intent.putExtra("DIFFICULTY_LEVEL", difficultyLevel);
        startActivity(intent);
    }
}
