package com.example.applicationforaccount;

import androidx.appcompat.app.AppCompatActivity;
import com.example.applicationforaccount.CircleMenuLayout.OnMenuItemClickListener;
// 下面引入了很多包，具体的用法暂时不太清楚
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long mExitTime;

    // 这个其实就是自己定义的组件
    private CircleMenuLayout mCircleMenuLayout;

    private String[] mItemTexts = new String[] { "登录&注册", "关于我们", "心愿墙",
            "特色设置", "收入&支出", "统计" };
    // 专门用于实现圆形转圈菜单的数据结构，为什么是这样的我也不太懂的

    // 将图片陈列在六个方向的一个int数组，专门用于和组件相关联
    // 这个完全属于是别人写的，管中窥豹可以学习一点点有用的知识？
    private int[] mItemImgs = new int[] { R.mipmap.home_mbank_1_normal,
            R.mipmap.home_mbank_2_normal, R.mipmap.home_mbank_3_normal,
            R.mipmap.home_mbank_4_normal, R.mipmap.home_mbank_5_normal,
            R.mipmap.home_mbank_6_normal };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 总而言之，载入了很多不同的界面，还是比较ok的
        // 从开发难度来看，难度并不是特别的大的
        mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
        // 对应的某个构造函数

        mCircleMenuLayout.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public void itemClick(View view, int pos) {
                if (mItemTexts[pos] == "心愿墙") {
                    openWishWind(view);
                }
                else if(mItemTexts[pos] == "关于我们") {
                    openAboutUsAddWind(view);
                }
                else if(mItemTexts[pos] == "统计") {
                    openCountWind(view);
                }
                ;
            }
            public void itemCenterClick(View view) {
                Toast.makeText(MainActivity.this, "you can do something just like login or register", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void openAboutUsAddWind(View y) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, AboutUsActivity.class);
        this.startActivity(intent);
    }
    private void openWishWind(View y) {
        Intent intent = new Intent();
        // 标准的调用别的服务的流程，过程是非常明确的，这一点是需要谨记的
        intent.setClass(MainActivity.this, WishActivity.class);
        this.startActivity(intent);
    }
    protected void openCountWind(View y) {
        Intent intent = new Intent();

        intent.setClass(MainActivity.this, CountActivity.class);
        this.startActivity(intent);
    }
}
