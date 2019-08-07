package com.as.demo_ok30;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.as.demo_ok30.pullextend.ExtendListFooter;
import com.as.demo_ok30.pullextend.ExtendListHeader;
import com.as.demo_ok30.pullextend.PullExtendLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/****
 *1.首先是extend_Head  align_parentbottom  俩个控件都要写
 *2.ExtentListFooter   ExtentListHeader
 *               这里边的 顶头 俩个变量 都是设置 拉长的最大高度 和 缩小后的最大高度
 *3.PullExtendLayout  搜索阻尼   有5个 左右
 *4.
 */

public class MainActivity extends AppCompatActivity {
    ExtendListHeader mPullNewHeader;
    ExtendListFooter mPullNewFooter;
    PullExtendLayout mPullExtendLayout;

    TextView tvHeader, tvFooter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPullNewHeader = findViewById(R.id.extend_header);
        mPullNewFooter = findViewById(R.id.extend_footer);
        mPullExtendLayout = findViewById(R.id.pull_extend);
        TextView tv = findViewById(R.id.tv);

        //字符串 是数字打头的
        String s = "00112312连续数字开头背景颜色改变";
        SpannableString spannableString = new SpannableString(s);
        Pattern pattern = Pattern.compile("[0-9]*");
        int stopIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            Matcher isNum = pattern.matcher(s.charAt(i) + "");
            if (!isNum.matches()) {
                //第一个数字以外的
                stopIndex = i;
                break;
            }
        }

        BackgroundColorSpan colorSpan = new BackgroundColorSpan(Color.parseColor("#AC00FF30"));
        spannableString.setSpan(colorSpan, 0, stopIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv.setText(spannableString);

        tvHeader = mPullNewHeader.getRecyclerView();
        tvFooter = mPullNewFooter.getRecyclerView();


        tvHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "嘿嘿", Toast.LENGTH_SHORT).show();
            }
        });

        tvFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}
