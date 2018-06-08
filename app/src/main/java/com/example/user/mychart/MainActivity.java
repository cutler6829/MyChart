package com.example.user.mychart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.graphics.Color.GREEN;
import static android.view.MenuItem.*;

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
        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(getData("4月每日支出",Color.BLUE));
        dataSets.add(getData("5月每日支出",Color.GREEN));


        LineData lineData = new LineData(dataSets);
        chart.setData(lineData);
        //chart.invalidate(); // refresh
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(15f);
        xAxis.setTextColor(Color.RED);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setTextSize(15f);
        leftAxis.setTextColor(Color.BLACK);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);
        chart.setVisibleXRangeMaximum(5);
//        xAxis.setLabelCount(5);
        chart.invalidate(); // refresh

    }

    LineDataSet getData(String label,int color){
        Random r =new Random();
        List<Entry> entries = new ArrayList<Entry>();

        for (int i =1;i<=50;i++) {
            entries.add(new Entry(i,r.nextInt(500)));

            // turn your data into Entry objects
        }

        LineDataSet dataSet = new LineDataSet(entries, label); // add entries to dataset
        dataSet.setColor(color);
        dataSet.setValueTextSize(10f);
        dataSet.setValueTextColor(Color.BLACK); // styling, ...
        dataSet.setLineWidth(3);//設定線的寬度
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);//設定線的形式(曲線)
        dataSet.setCircleRadius(5);//設定節點大小（半徑）
        dataSet.setCircleColor(Color.RED);
        return dataSet;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,"ZoomIn").setIcon(R.drawable.zoomin).setShowAsAction(SHOW_AS_ACTION_ALWAYS);
        menu.add(0,1,0,"ZoomOut").setIcon(R.drawable.zoomout).setShowAsAction(SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 0:
                chart.zoomIn();
                break;
            case 1:
                chart.zoomOut();
                break;
        }
        return super.onOptionsItemSelected(item);


    }
}
