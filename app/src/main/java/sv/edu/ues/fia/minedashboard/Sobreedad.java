package sv.edu.ues.fia.minedashboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

public class Sobreedad extends AppCompatActivity {
    private float porcentSob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(sv.edu.ues.fia.minedashboard.R.layout.activity_sobreedad);

        PieChart pieChart = (PieChart) findViewById(R.id.pieChart);

        porcentSob = (float) 9.40;
        pieChart.setHoleRadius(0f);
        pieChart.setRotationEnabled(false);
        pieChart.animateXY(1500, 1500);
        ArrayList<Entry> valsY = new ArrayList<Entry>();
        valsY.add(new Entry(porcentSob, 0));
        valsY.add(new Entry(100f - porcentSob, 1));
        ArrayList<String> valsX = new ArrayList<String>();
        valsX.add("% Sobreedad");
        valsX.add("Sin sobreedad ");
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        PieDataSet set1 = new PieDataSet(valsY, "SOBREEDAD NACIONAL");
        set1.setSliceSpace(0f);
        set1.setColors(colors);
        PieData dato1 = new PieData(valsX, set1);
        pieChart.setData(dato1);
        pieChart.setDescription(" ");
        pieChart.invalidate();

    }
}
