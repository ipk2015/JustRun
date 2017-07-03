package com.ipk.handbookforrun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button weekButton1= (Button)findViewById(R.id.weekButton1);
        Button weekButton2=(Button)findViewById(R.id.weekButton2);
        Button weekButton3=(Button)findViewById(R.id.weekButton3);
        Button weekButton4=(Button)findViewById(R.id.weekButton4);
        Button weekButton5=(Button)findViewById(R.id.weekButton5);
        Button weekButton6=(Button)findViewById(R.id.weekButton6);
        Button weekButton7=(Button)findViewById(R.id.weekButton7);
        Button weekButton8=(Button)findViewById(R.id.weekButton8);
        Button weekButton9=(Button)findViewById(R.id.weekButton9);
        Button weekButton10=(Button)findViewById(R.id.weekButton10);
        Button weekButton11=(Button)findViewById(R.id.weekButton11);
        Button weekButton12=(Button)findViewById(R.id.weekButton12);
        Button weekButton13=(Button)findViewById(R.id.weekButton13);
        weekButton1.setOnClickListener(this);
        weekButton2.setOnClickListener(this);
        weekButton3.setOnClickListener(this);
        weekButton4.setOnClickListener(this);
        weekButton5.setOnClickListener(this);
        weekButton6.setOnClickListener(this);
        weekButton7.setOnClickListener(this);
        weekButton8.setOnClickListener(this);
        weekButton9.setOnClickListener(this);
        weekButton10.setOnClickListener(this);
        weekButton11.setOnClickListener(this);
        weekButton12.setOnClickListener(this);
        weekButton13.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,WeekActivity.class);
        intent.putExtra("week",v.getId());
        startActivity(intent);
    }
}
/*
* 第1周：步伐
第1课（34分钟）
跑步1分钟，行走2分钟，做8次。
第2课（28分钟）
跑步1分钟，行走2分钟，做6次。
第3课（31分钟）
跑步1分钟，行走2分钟，做7次。

第2周：建立基础
第1课（38分钟）
跑步2分钟，行走2分钟，做7次。
第2课（31分钟）
跑步1分钟，行走2分钟，做7次。
第3课（34分钟）
跑步2分钟，行走2分钟，做6次。

第3周：增加跑步的时间
第1课（45分钟）
跑步3分钟，行走2分钟，做7次。
第2课（34分钟）
跑步2分钟，行走2分钟，做6次。
第3课（40分钟）
跑步3分钟，行走2分钟，做6次。

第4周：轻松的恢复周
第1课（40分钟）
跑步3分钟，行走2分钟，做6次。
第2课（30分钟）
跑步2分钟，行走2分钟，做5次。
第3课（40分钟）
跑步2分钟，行走3分钟，做6次。

第5周：注意“拖着脚跑步”
第1课（46分钟）
跑步3分钟，行走1分钟，做9次。
第2课（34分钟）
跑步2分钟，行走1分钟，做8次。
第3课（42分钟）
跑步3分钟，行走1分钟，做8次。

第6周：增加训练量
第1课（52分钟）
跑步5分钟，行走1分钟，做7次。
第2课（38分钟）
跑步3分钟，行走1分钟，做7次。
第3课（50分钟）
跑步3分钟，行走1分钟，做10次。

第7周：训练过了一半
第1课（54分钟或者5000米距离）
跑步10分钟，行走1分钟，做4次。
或者按这个模式完成5000米。
第2课（40分钟）
跑步4分钟，行走1分钟，做6次。
第3课（52分钟）
跑步5分钟，行走1分钟，做7次。

第8周：轻松的恢复周
第1课（54分钟）
跑步10分钟，行走1分钟，做4次。
第2课（38分钟）
跑步3分钟，行走1分钟，做7次。
第3课（46分钟）
跑步5分钟，行走1分钟，做6次。

第9周：回到训练中
第1课（68分钟）
跑步10分钟，行走1分钟。
跑步15分钟，行走1分钟。
跑步20分钟，行走1分钟。
跑步10分钟
第2课（46分钟）
跑步5分钟，行走1分钟，做6次。
第3课（54分钟）
跑步10分钟，行走1分钟，做4次。

第10周：漫长的一周
第1课（72分钟）
跑步10分钟，行走1分钟。
跑步20分钟，行走1分钟。
跑步30分钟
第2课（54分钟）
跑步10分钟，行走1分钟，做4次。
第3课（57分钟）
跑步20分钟，行走1分钟。
跑步15分钟，行走1分钟。
跑步10分钟，行走1分钟。

第11周：树立信心
第1课（71分钟）
跑步40分钟，行走1分钟。
跑步20分钟
第2课（54分钟）
跑步10分钟，行走1分钟，做4次。
第3课（57分钟）
跑步20分钟，行走1分钟。
跑步15分钟，行走1分钟。
跑步10分钟，行走1分钟。

第12周：轻松的一周
第1课（60分钟）
跑步50分钟，行走1分钟。
第2课（43分钟）
跑步10分钟，行走1分钟，做3次。
第3课（52分钟）
跑步15分钟，行走1分钟。
跑步15分钟，行走1分钟。
跑步10分钟，行走1分钟。

第13周：祝贺！
第1课（50分钟）
跑步40分钟，行走1分钟。
第2课（43分钟）
跑步10分钟，行走1分钟，做3次。
第3课
10公里：享受乐趣，注意不要跑太快。
* */