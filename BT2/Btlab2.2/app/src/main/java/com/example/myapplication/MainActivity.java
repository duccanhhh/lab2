package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout loadingLayout; // Thay đổi thành LinearLayout
    private ProgressBar customProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Gán layout cho activity

        // Khởi tạo các thành phần
        loadingLayout = findViewById(R.id.loading_layout); // ID của LinearLayout trong item_loading.xml
        customProgressBar = findViewById(R.id.custom_progress_bar);

        // Hiển thị Loading Layout khi cần
        showLoading();
        // Giả lập một tác vụ mất thời gian
        new android.os.Handler().postDelayed(this::hideLoading, 2000);
    }

    private void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE); // Hiển thị Loading Layout
        customProgressBar.setVisibility(View.VISIBLE); // Hiển thị ProgressBar
    }

    private void hideLoading() {
        loadingLayout.setVisibility(View.GONE); // Ẩn Loading Layout
        customProgressBar.setVisibility(View.GONE); // Ẩn ProgressBar
    }
}