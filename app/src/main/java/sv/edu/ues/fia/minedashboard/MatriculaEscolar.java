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
import java.util.List;


public class MatriculaEscolar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matricula_escolar);

        BarChart barChart = (BarChart) findViewById(R.id.barChart);
        PieChart pieChart = (PieChart) findViewById(R.id.pieChart);
        PieChart pieChart2 = (PieChart) findViewById(R.id.pieChart2);
        BarChart barChart2 = (BarChart) findViewById(R.id.barChart2);
        HorizontalBarChart barChart3 = (HorizontalBarChart) findViewById(R.id.barChart3);

        // MATRICULA TOTAL
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1495552, 0));

        BarDataSet dataset = new BarDataSet(entries, "MATRICULA TOTAL");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("NACIONAL");

        BarData data = new BarData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setData(data);
        barChart.setDescription(" ");
        barChart.animateY(5000);


        //MATRICULA POR SECTOR
        //definimos algunos atributos
        pieChart.setHoleRadius(40f);
        pieChart.setRotationEnabled(true);
        pieChart.animateXY(1500, 1500);

        //creamos una lista para los valores Y
        ArrayList<Entry> valsY = new ArrayList<Entry>();
        valsY.add(new Entry(234495* 100 / 1495552,0));
        valsY.add(new Entry(1261057 * 100 / 1495552,1));

        //creamos una lista para los valores X
        ArrayList<String> valsX = new ArrayList<String>();
        valsX.add("%Privados");
        valsX.add("%Públicos");

        //creamos una lista de colores
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);

        //seteamos los valores de Y y los colores
        PieDataSet set1 = new PieDataSet(valsY, "MATRICULA POR SECTOR");
        set1.setSliceSpace(0f);
        set1.setColors(colors);

        //seteamos los valores de X
        PieData dato1 = new PieData(valsX, set1);
        pieChart.setData(dato1);
        pieChart.setDescription(" ");
        pieChart.invalidate();

        //MATRICULA POR ZONA
        //definimos algunos atributos
        pieChart2.setHoleRadius(40f);
        pieChart2.setRotationEnabled(true);
        pieChart2.animateXY(1500, 1500);

        //creamos una lista para los valores Y
        ArrayList<Entry> valsY1 = new ArrayList<Entry>();
        valsY1.add(new Entry((658952 * 100 / 1495552), 0));
        valsY1.add(new Entry(836600 * 100 / 1495552,1));

        //creamos una lista para los valores X
        ArrayList<String> valsX1 = new ArrayList<String>();
        valsX1.add("%Rural");
        valsX1.add("%Urbano");

        //creamos una lista de colores
        ArrayList<Integer> colors1 = new ArrayList<Integer>();
        colors1.add(Color.GREEN);
        colors1.add(Color.BLUE);

        //seteamos los valores de Y y los colores
        PieDataSet set2 = new PieDataSet(valsY1,"MATRICULA POR ZONA");
        set2.setSliceSpace(0f);
        set2.setColors(colors1);

        //seteamos los valores de X
        PieData dato2 = new PieData(valsX1, set2);
        pieChart2.setData(dato2);
        pieChart2.setDescription(" ");
        pieChart2.invalidate();

        // MATRICULA POR SEXO
        ArrayList<BarEntry> entries2 = new ArrayList<>();
        entries2.add(new BarEntry(735,0));
        entries2.add(new BarEntry(765056, 1));
        entries2.add(new BarEntry(727761, 2));

        BarDataSet dataset2 = new BarDataSet(entries2, "MATRICULA POR SEXO");

        ArrayList<String> labels2 = new ArrayList<String>();
        labels2.add("No especificó");
        labels2.add("Masculino");
        labels2.add("Femenino");

        BarData data2 = new BarData(labels2, dataset2);
        dataset2.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart2.setData(data2);
        barChart2.setDescription(" ");
        barChart2.animateY(5000);

        // MATRICULA POR NIVEL EDUCATIVO
        ArrayList<BarEntry> entries3 = new ArrayList<>();
        entries3.add(new BarEntry(11912, 4));
        entries3.add(new BarEntry(228456, 3));
        entries3.add(new BarEntry(1046946, 2));
        entries3.add(new BarEntry(205351, 1));
        entries3.add(new BarEntry(2887, 0));

        BarDataSet dataset3 = new BarDataSet(entries3, "MATRICULA POR NIVEL EDUCATIVO");

        ArrayList<String> labels3 = new ArrayList<String>();
        labels3.add("Edu. de Adultos");
        labels3.add("Edu. Media");
        labels3.add("       Edu. Básica");
        labels3.add("Edu. Parvularia");
        labels3.add("Edu. Inicial");

        BarData data3 = new BarData(labels3, dataset3);
        dataset3.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart3.setData(data3);
        barChart3.setDescription(" ");
        barChart3.animateY(5000);

    }
}
