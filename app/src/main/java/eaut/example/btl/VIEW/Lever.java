package eaut.example.btl.VIEW;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        btn_easy.setOnClickListener(view -> {
            Intent myIntent = new Intent(Lever.this, Question_main.class);
            myIntent.putExtra("DIFFICULTY_LEVEL", 1); // 1: dễ
            startActivity(myIntent);
        });

        btn_medium = findViewById(R.id.btn_medium);
        btn_medium.setOnClickListener(view -> {
            Intent myIntent = new Intent(Lever.this, Question_main.class);
            myIntent.putExtra("DIFFICULTY_LEVEL", 2); // 2: vừa
            startActivity(myIntent);
        });

        btn_difficult = findViewById(R.id.btn_difficult);
        btn_difficult.setOnClickListener(view -> {
            Intent myIntent = new Intent(Lever.this, Question_main.class);
            myIntent.putExtra("DIFFICULTY_LEVEL", 3); // 3: khó
            startActivity(myIntent);
        });
    }
}
