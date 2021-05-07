package com.example.applicationforaccount;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

// 无法定位错误原因，开启别的activity，会引起黑屏问题，这个问题是难以理解的
public class WishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wish);
    }
}
