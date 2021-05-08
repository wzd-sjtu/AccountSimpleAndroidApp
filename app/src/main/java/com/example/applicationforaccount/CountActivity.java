package com.example.applicationforaccount;

import android.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.ArrayList;

public class CountActivity {

    private TextView tv_year;
    private TextView item_detail, item_category_report;
    private Button btnAddRecord;
    private ViewPager vp;

    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentPagerAdapter mFragmentAdapter;

    private Spinner month_spinner;
    private ArrayAdapter<String> month_adapter;

    private AlertDialog alertDialog_AddRecord;

    String[] titles = new String[] {"明细", "类别报表"};
    private static final String[] yearList = {pubFun.getTime("Y") + "年"};
    private static final String[] monthList = {"01月", "02月", "03月"};

    // 这里的类的书写方式用到了android studio开发的核心知识，是值得认真学习的。
}
