package com.example.applicationforaccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Fragment是实现代码重用的小结构，可以在不同的activity里面调用，提高了运行的efficiency
// 可以认为，别人写的这些代码，本质上是官方相关API设定+自己的数据结构和前台绑定的过程
// 同时，还对一些简单的事件加了一些listenser上去，从而进行监听事件操作
public class OneFragment extends Fragment {
    // 显示数据的存放地区，算是比较原始的项目手段了
    List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();

    // 存储了文件夹下对应图片的具体格式，内容总是固定的？
    int[] image_expense = new int[] {R.mipmap.detail_income, R.mipmap.detial_patout};
    // 建一个空的构造函数
    // 直接从头开始学android studio，毫无疑问，难度是比较大的
    // 我感觉稍稍有点裂开的
    public OneFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frament_one, container, false);

        // int[] image_expense = new int[]{R.mipmap.detail_income, R.mipmap.detail_payout };
        String[] expense_category = new String[] {"发工资", "买衣服"};
        String[] expense_money = new String[] {"30000.00", "1500.00"};

        for (int i = 0; i < image_expense.length; i++)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image_expense", image_expense[i]);
            map.put("expense_category", expense_category[i]);
            map.put("expense_money", expense_money[i]);
            // list存储的是map，这真是一大浪费哇
            // 算是暂时无语了哦
            listitem.add(map);
        }
        // 以上的数据写死保证了暂时不会用到数据库
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),
                listitem,
                R.layout.frament_one_item,
                new String[] {"expense_category", "expense_money", "image_expense"},
                new int[] {R.id.tv_expense_category, R.id.tv_expense_money, R.id.image_expense});
        // 以上这个巨大的函数是为了某个内容的布局而建立的
        // listitem 是存储了数据的数据结构
        // layout导入每一个列表项的布局文件
        // 接下来的两个数组，指定了Map的键，制订了布局使用的图片文件，也就是layout里面的布局文件

        // 又是括号没有闭合的问题，我笑了哇
        // 专门用于将数据和前台内容绑定的数据结构
        ListView listView = (ListView) v.findViewById(R.id.lv_expense);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                Toast.makeText(getActivity(), map.get("expense_category").toString(), Toast.LENGTH_LONG).show();

            }
        });
        return v;
    }
}
