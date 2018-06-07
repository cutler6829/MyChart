package com.example.user.mychart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.graphics.Color.GREEN;

public class MainActivity extends AppCompatActivity {
    LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chart=(LineChart) findViewById(R.id.chart);
        init();
    }
    void init(){
        //YourData[] dataObjects = ...;
        Random r =new Random();
        List<Entry> entries = new ArrayList<Entry>();

        for (int i =1;i<=50;i++) {
            entries.add(new Entry(i,r.nextInt(500)));

            // turn your data into Entry objects
        }

        LineDataSet dataSet = new LineDataSet(entries, "每日耗用"); // add entries to dataset
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextSize(10f);
        dataSet.setValueTextColor(Color.BLACK); // styling, ...

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(15f);
        xAxis.setTextColor(Color.RED);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setTextSize(15f);
        leftAxis.setTextColor(Color.BLACK);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);
        chart.setVisibleXRangeMaximum(30);
//        xAxis.setLabelCount(5);
        chart.invalidate(); // refresh





    }
}
