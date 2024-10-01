package com.example.btlab23;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Khởi tạo ImageView cho biểu tượng điện thoại
        ImageView phoneIcon = findViewById(R.id.phone_icon); // Đảm bảo ID là đúng

        // Thiết lập OnClickListener cho biểu tượng điện thoại
        phoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall("1234567890"); // Số điện thoại để gọi
            }
        });
    }

    // Hàm để thực hiện cuộc gọi
    private void makePhoneCall(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel" + phoneNumber));

        // Kiểm tra xem có ứng dụng nào có thể xử lý Intent này không
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // Xử lý trường hợp không có ứng dụng nào
            Toast.makeText(this, "Không có ứng dụng nào có thể thực hiện cuộc gọi.", Toast.LENGTH_SHORT).show();
        }
    }
}