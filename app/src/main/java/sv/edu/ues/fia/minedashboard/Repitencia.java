package sv.edu.ues.fia.minedashboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

public class Repitencia extends AppCompatActivity {
    private float porcentRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(sv.edu.ues.fia.minedashboard.R.layout.activity_repitencia);

        PieChart pieChart = (PieChart) findViewById(R.id.pieChart);

        porcentRep = (float) 4.67;
        pieChart.setHoleRadius(0f);
        pieChart.setRotationEnabled(false);
        pieChart.animateXY(1500, 1500);
        ArrayList<Entry> valsY = new ArrayList<Entry>();
        valsY.add(new Entry(porcentRep,0));
        valsY.add(new Entry(100f-porcentRep, 1));
        ArrayList<String> valsX = new ArrayList<String>();
        valsX.add("% Repetidores");
        valsX.add("No repiten ");
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        PieDataSet set1 = new PieDataSet(valsY, "REPITENCIA NACIONAL");
        set1.setSliceSpace(0f);
        set1.setColors(colors);
        PieData dato1 = new PieData(valsX, set1);
        pieChart.setData(dato1);
        pieChart.setDescription(" ");
        pieChart.invalidate();
    }
}
