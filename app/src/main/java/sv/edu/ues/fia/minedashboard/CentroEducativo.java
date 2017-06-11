package sv.edu.ues.fia.minedashboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class CentroEducativo extends AppCompatActivity {
    private String titulo;
    private int cantTotal;
    private float cantPublico, cantPrivado;
    private float cantRural, cantUrbano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(sv.edu.ues.fia.minedashboard.R.layout.activity_centro_educativo);

        BarChart barChart = (BarChart) findViewById(R.id.barChart);
        PieChart pieChart = (PieChart) findViewById(R.id.pieChart);
        PieChart pieChart2 = (PieChart) findViewById(R.id.pieChart2);

        // CENTROS EDUCATIVOS TOTAL
        cantTotal = 6033;
        titulo = "NACIONAL";
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(cantTotal, 0));
        BarDataSet dataset = new BarDataSet(entries, "C.E. TOTAL");
        ArrayList<String> labels = new ArrayList<String>();
        labels.add(titulo);
        BarData data = new BarData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setData(data);
        barChart.setDescription(" ");
        barChart.animateY(5000);


        //C.E. POR SECTOR
        cantPrivado = 897;
        cantPublico = 5136;
        float privado = (cantPrivado*100/cantTotal);
        float publico = (cantPublico*100/cantTotal);
        pieChart.setHoleRadius(40f);
        pieChart.setRotationEnabled(true);
        pieChart.animateXY(1500, 1500);
        ArrayList<Entry> valsY = new ArrayList<Entry>();
        valsY.add(new Entry(privado,0));
        valsY.add(new Entry(publico,1));
        ArrayList<String> valsX = new ArrayList<String>();
        valsX.add("%Privados");
        valsX.add("%Públicos");
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        PieDataSet set1 = new PieDataSet(valsY, "C.E. POR SECTOR");
        set1.setSliceSpace(0f);
        set1.setColors(colors);
        PieData dato1 = new PieData(valsX, set1);
        pieChart.setData(dato1);
        pieChart.setDescription(" ");
        pieChart.invalidate();


        //C.E. POR ZONA
        cantRural = 3961;
        cantUrbano = 2072;
        float rural = (cantRural*100/cantTotal);
        float urbano = (cantUrbano*100/cantTotal);
        pieChart2.setHoleRadius(40f);
        pieChart2.setRotationEnabled(true);
        pieChart2.animateXY(1500, 1500);
        ArrayList<Entry> valsY1 = new ArrayList<Entry>();
        valsY1.add(new Entry(rural, 0));
        valsY1.add(new Entry(urbano, 1));
        ArrayList<String> valsX1 = new ArrayList<String>();
        valsX1.add("%Rural");
        valsX1.add("%Urbano");
        ArrayList<Integer> colors1 = new ArrayList<Integer>();
        colors1.add(Color.GREEN);
        colors1.add(Color.BLUE);
        PieDataSet set2 = new PieDataSet(valsY1,"C.E. POR ZONA");
        set2.setSliceSpace(0f);
        set2.setColors(colors1);
        PieData dato2 = new PieData(valsX1, set2);
        pieChart2.setData(dato2);
        pieChart2.setDescription(" ");
        pieChart2.invalidate();
    }
}
