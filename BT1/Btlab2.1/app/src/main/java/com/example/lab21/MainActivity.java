package com.example.lab21;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private int[] colors = {Color.RED, Color.GREEN, Color.BLUE};
    private int[] icons = {R.drawable.img, R.drawable.img_1, R.drawable.img_2};
    private String[] birdNames;

    private ConstraintLayout mainLayout;
    private ImageView birdImage;
    private TextView birdName;

    private int currentIndex = 0; // Chỉ số hiện tại cho các biểu tượng, tên và màu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birdNames = new String[]{
                getString(R.string.bird_name),
                getString(R.string.monkey_name),
                getString(R.string.dog_name)
        };

        mainLayout = findViewById(R.id.main);
        birdImage = findViewById(R.id.bird_image);
        birdName = findViewById(R.id.bird_name);

        updateUI(); // Cập nhật giao diện ban đầu

        birdImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeUI(); // Gọi hàm thay đổi giao diện
            }
        });

        birdName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeUI(); // Gọi hàm thay đổi giao diện
            }
        });
    }

    private void updateUI() {
        // Cập nhật giao diện
        birdImage.setImageResource(icons[currentIndex]);
        birdName.setText(birdNames[currentIndex]);
        mainLayout.setBackgroundColor(colors[currentIndex]);
    }

    private void changeUI() {
        // Tăng chỉ số hiện tại và cập nhật UI
        currentIndex = (currentIndex + 1) % icons.length;
        updateUI(); // Cập nhật giao diện
    }
}