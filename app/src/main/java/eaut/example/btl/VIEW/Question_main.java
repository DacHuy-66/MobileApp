package eaut.example.btl.VIEW;

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
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;


import java.util.List;

import eaut.example.btl.DATA.QuizDbHelper;
import eaut.example.btl.DATA.Question;
import eaut.example.btl.R;

import android.os.CountDownTimer;

public class Question_main extends AppCompatActivity {

    Button btn_back1;
    TextView tvQuestionNumber, tvQuestion, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    TextView tvHelp1, tvHelp2, tvHelp3;  // Các nút trợ giúp
    int currentQuestion = 0;
    int score = 0;
    List<Question> questionList;
    QuizDbHelper dbHelper;
    int difficultyLevel;

    Drawable blueDrawable;
    Drawable yellowDrawable;
    Drawable greenDrawable;
    Drawable redDrawable;

    private CountDownTimer countDownTimer;
    private TextView txtCountdown;
    private final long COUNTDOWN_IN_MILLIS = 31000;

    // Thay đổi trạng thái trợ giúp
    private boolean helpFiftyFiftyUsed = false;
    private boolean helpCorrectAnswerUsed = false;
    private boolean helpSkipQuestionUsed = false;

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
        btn_back1.setOnClickListener(view -> {
            // Tạo một AlertDialog Builder
            AlertDialog.Builder builder = new AlertDialog.Builder(Question_main.this);

            // Sử dụng LayoutInflater để tải layout tuỳ chỉnh
            View dialogView = getLayoutInflater().inflate(R.layout.dialog_out, null);

            // Liên kết các thành phần giao diện trong dialog
            TextView messageTextView = dialogView.findViewById(R.id.dialog_message);
            Button okButton = dialogView.findViewById(R.id.button_ok);
            Button cancelButton = dialogView.findViewById(R.id.button_cancel);

            // Thiết lập thông điệp cho TextView
            messageTextView.setText("Bạn có chắc chắn muốn thoát không?");

            // Đặt view tuỳ chỉnh cho AlertDialog
            builder.setView(dialogView);
            AlertDialog dialog = builder.create();

            // Xử lý sự kiện khi nút "Có" được nhấn
            okButton.setOnClickListener(v -> {
                dialog.dismiss();
                finish();
            });

            // Xử lý sự kiện khi nút "Không" được nhấn
            cancelButton.setOnClickListener(v -> dialog.dismiss());

            // Hiển thị hộp thoại
            dialog.show();
        });

        tvQuestion = findViewById(R.id.tv_content_question);
        tvQuestionNumber = findViewById(R.id.tv_question_number);
        tvAnswer1 = findViewById(R.id.tv_answer1);
        tvAnswer2 = findViewById(R.id.tv_answer2);
        tvAnswer3 = findViewById(R.id.tv_answer3);
        tvAnswer4 = findViewById(R.id.tv_answer4);

        yellowDrawable = ContextCompat.getDrawable(this, R.drawable.bg_yellow);
        blueDrawable = ContextCompat.getDrawable(this, R.drawable.txt_answer_edit);
        greenDrawable = ContextCompat.getDrawable(this, R.drawable.bg_green);
        redDrawable = ContextCompat.getDrawable(this, R.drawable.bg_red);

        dbHelper = new QuizDbHelper(this);

        // Nhận mức độ khó từ Score
        difficultyLevel = getIntent().getIntExtra("DIFFICULTY_LEVEL", 1);

        // Tải câu hỏi ngẫu nhiên dựa trên mức độ
        questionList = dbHelper.getRandomQuestionsByLevel(difficultyLevel);

        if (!questionList.isEmpty()) {
            loadQuestion(currentQuestion);
        } else {
            Toast.makeText(this, "Không có câu hỏi cho mức độ này!", Toast.LENGTH_SHORT).show();
        }

        tvAnswer1.setOnClickListener(view -> checkAnswer(0, tvAnswer1));
        tvAnswer2.setOnClickListener(view -> checkAnswer(1, tvAnswer2));
        tvAnswer3.setOnClickListener(view -> checkAnswer(2, tvAnswer3));
        tvAnswer4.setOnClickListener(view -> checkAnswer(3, tvAnswer4));

        txtCountdown = findViewById(R.id.txt_countdown);

        // Bắt đầu đồng hồ đếm ngược
        startCountdownTimer();

        // Khai báo các TextView cho nút trợ giúp
        tvHelp1 = findViewById(R.id.tv_help1);
        tvHelp2 = findViewById(R.id.tv_help2);
        tvHelp3 = findViewById(R.id.tv_help3);

        // Gán sự kiện click cho các nút trợ giúp
        tvHelp1.setOnClickListener(v -> {
            if (!helpFiftyFiftyUsed) {
                applyFiftyFifty();
                helpFiftyFiftyUsed = true;
                LamMo(tvHelp1);  // Làm mờ nút trợ giúp sau khi sử dụng
            }
        });

        tvHelp2.setOnClickListener(v -> {
            if (!helpCorrectAnswerUsed) {
                applyCorrectAnswer();
                helpCorrectAnswerUsed = true;
                LamMo(tvHelp2);
            }
        });

        tvHelp3.setOnClickListener(v -> {
            if (!helpSkipQuestionUsed) {
                applySkipQuestion();
                helpSkipQuestionUsed = true;
                LamMo(tvHelp3);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void loadQuestion(int questionIndex) {
        Question current = questionList.get(questionIndex);

        tvQuestion.setText(current.getQuestion());
        tvQuestionNumber.setText("Câu hỏi " + (questionIndex + 1));
        tvAnswer1.setText(current.getOption1());
        tvAnswer2.setText(current.getOption2());
        tvAnswer3.setText(current.getOption3());
        tvAnswer4.setText(current.getOption4());

        tvAnswer1.setBackground(blueDrawable);
        tvAnswer2.setBackground(blueDrawable);
        tvAnswer3.setBackground(blueDrawable);
        tvAnswer4.setBackground(blueDrawable);

        // Đảm bảo các đáp án được hiển thị đầy đủ
        tvAnswer1.setVisibility(View.VISIBLE);
        tvAnswer2.setVisibility(View.VISIBLE);
        tvAnswer3.setVisibility(View.VISIBLE);
        tvAnswer4.setVisibility(View.VISIBLE);

        // Đặt lại và khởi động lại đồng hồ đếm ngược cho câu hỏi mới
        resetCountdownTimer();
    }

    private final Handler handler = new Handler();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
        handler.removeCallbacksAndMessages(null);
    }

    private void resetCountdownTimer() {
        // Hủy đồng hồ đếm ngược hiện có
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        // Bắt đầu đồng hồ đếm ngược mới
        startCountdownTimer();
    }

    private void startCountdownTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        countDownTimer = new CountDownTimer(COUNTDOWN_IN_MILLIS, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                seconds = seconds % 60;
                @SuppressLint("DefaultLocale") String timeLeft = String.format("%02d", seconds);
                txtCountdown.setText(timeLeft);
            }

            @Override
            public void onFinish() {
                Toast.makeText(Question_main.this, "Time's up!", Toast.LENGTH_SHORT).show();
                navigateToScore();
                finish();
            }
        }.start();
    }

    private void checkAnswer(int selectedAnswerIndex, TextView selectedAnswer) {
        // Hủy đồng hồ đếm ngược nếu câu trả lời được chọn
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

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
                // Đổi màu thành xanh nếu đúng
                selectedAnswer.setBackground(greenDrawable);
                score++;

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

    // Chuyển sang màn hình Final_Score
    private void navigateToScore() {
        Intent intent = new Intent(Question_main.this, final_Score.class);
        intent.putExtra("SCORE", score);
        intent.putExtra("TOTAL_QUESTIONS", questionList.size());
        startActivity(intent);
        finish();
    }


    // Phương thức để áp dụng chức năng "Hiển thị đáp án đúng"
    private void applyCorrectAnswer() {
        // Lấy câu trả lời đúng từ câu hỏi hiện tại
        int correctAnswerIndex = questionList.get(currentQuestion).getAnswerNr() - 1;

        // Tạo chuỗi để hiển thị đáp án đúng
        String correctAnswerText = "";
        TextView[] allAnswers = {tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4};
        for (int i = 0; i < allAnswers.length; i++) {
            if (i == correctAnswerIndex) {
                correctAnswerText = allAnswers[i].getText().toString();
                break;
            }
        }

        // Tạo và hiển thị hộp thoại thông báo với layout tùy chỉnh
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_correct_answer, null);
        TextView messageTextView = dialogView.findViewById(R.id.dialog_message);
        Button okButton = dialogView.findViewById(R.id.button_ok);

        messageTextView.setText("Đáp án đúng là: " + correctAnswerText);

        builder.setView(dialogView);
        AlertDialog dialog = builder.create();

        okButton.setOnClickListener(v -> {
            dialog.dismiss();
            // Kích hoạt lại sự kiện click cho tất cả các đáp án sau khi hộp thoại bị đóng
            enableAnswerClick();
        });

        dialog.show();
    }


    // Phương thức để áp dụng chức năng "Loại bỏ 2 phương án sai"
    private void applyFiftyFifty() {
        // Lấy câu trả lời đúng từ câu hỏi hiện tại
        int correctAnswerIndex = questionList.get(currentQuestion).getAnswerNr() - 1;

        // Chọn ngẫu nhiên 2 phương án sai để ẩn
        TextView[] allAnswers = {tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4};
        int[] indices = {0, 1, 2, 3};
        java.util.Collections.shuffle(java.util.Arrays.asList(indices));
        int hiddenCount = 0;
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] != correctAnswerIndex && hiddenCount < 2) {
                allAnswers[indices[i]].setVisibility(View.INVISIBLE);
                hiddenCount++;
            }
        }
    }

    // Phương thức để áp dụng chức năng "Bỏ qua câu hỏi"
    private void applySkipQuestion() {
        // Chuyển sang câu hỏi tiếp theo nếu có
        if (currentQuestion < questionList.size() - 1) {
            currentQuestion++;
            loadQuestion(currentQuestion);
            // Kích hoạt lại sự kiện click cho các đáp án
            enableAnswerClick();
        } else {
            // Chuyển sang màn hình Score
            navigateToScore();
        }
    }

    // Phương thức để làm mờ các nút trợ giúp sau khi sử dụng
    private void LamMo(TextView helpButton) {
        helpButton.setAlpha(0.5f);  // Đặt độ mờ của nút trợ giúp xuống 50%
        helpButton.setClickable(false);  // Vô hiệu hóa khả năng click của nút
    }
}
