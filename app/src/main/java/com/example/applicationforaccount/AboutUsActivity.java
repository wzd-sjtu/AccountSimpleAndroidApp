package com.example.applicationforaccount;
import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUsActivity extends AppCompatActivity {
    // 这里的组件直接定义在了这个about类里面，也就是id对应的某一个小组件
    // 还算是比较合理的

    private TextView tvAboutUs;
    private TextView tvIntroduce;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
    }
}
