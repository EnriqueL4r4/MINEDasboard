package sv.edu.ues.fia.minedashboard;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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

public class MatriculaEscolar extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private String titulo;
    private int cantTotal;
    private float cantPublico, cantPrivado;
    private float cantRural, cantUrbano;
    private int cantMasculino, cantFemenino, cantNoEsp;
    private int cantInicial, cantParvularia, cantBasica, cantMedia, cantAdulto;
    int posicion;
    String seleccion;
    /*
    Instancias para los Views
     */
    Spinner spdepto;
    Spinner spmun;
    /*
    Adaptadores para los Spinners
     */
    //SimpleCursorAdapter departamentoSpinnerAdapter;
    //SimpleCursorAdapter municipioSpinnerAdapter;
    /*
    Nuestro origen de datos
     */
    ControlDB helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matricula_escolar);
        //helper = new ControlDB(this,null,null,1);
        //this.departamento = (Spinner) findViewById(R.id.sp_departamento);
        // this.municipio = (Spinner) findViewById(R.id.sp_municipio);
        //departamentoSpinnerAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, helper.getAllDepartamento(),new String[]{"nombre"}, new int[]{android.R.id.text1},SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        //departamento.setAdapter(departamentoSpinnerAdapter);
        //departamento.setOnItemSelectedListener(this);
        ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
        try {
            helper = new ControlDB(this, null, null, 1);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor rd =db.rawQuery("Select nombre from Departamento order by id_depto", null);
            Departamento depto;
            while(rd.moveToNext()){
                depto = new Departamento();
                depto.setId_depto(rd.getString(0));
                depto.setNombre(rd.getString(1));
                departamentos.add(depto);
            }
        } catch (Exception e){}

        spdepto = (Spinner) findViewById(R.id.sp_departamento);
        ArrayAdapter<Departamento> adaptador = new ArrayAdapter<Departamento>(this, android.R.layout.simple_spinner_dropdown_item, departamentos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spdepto.setAdapter(adaptador);
        spdepto.setOnItemSelectedListener(this);

        BarChart barChart = (BarChart) findViewById(R.id.barChart);
        PieChart pieChart = (PieChart) findViewById(R.id.pieChart);
        PieChart pieChart2 = (PieChart) findViewById(R.id.pieChart2);
        BarChart barChart2 = (BarChart) findViewById(R.id.barChart2);
        HorizontalBarChart barChart3 = (HorizontalBarChart) findViewById(R.id.barChart3);

        // MATRICULA TOTAL
        cantTotal = 1495552;
        titulo = "NACIONAL";
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(cantTotal, 0));
        BarDataSet dataset = new BarDataSet(entries, "MATRICULA TOTAL");
        ArrayList<String> labels = new ArrayList<String>();
        labels.add(titulo);
        BarData data = new BarData(labels,dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setData(data);
        barChart.setDescription(" ");
        barChart.animateY(5000);


        //MATRICULA POR SECTOR
        cantPrivado = 234495;
        cantPublico = 1261057;
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
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        PieDataSet set1 = new PieDataSet(valsY, "MATRICULA POR SECTOR");
        set1.setSliceSpace(0f);
        set1.setColors(colors);
        PieData dato1 = new PieData(valsX, set1);
        pieChart.setData(dato1);
        pieChart.setDescription(" ");
        pieChart.invalidate();

        //MATRICULA POR ZONA
        cantRural = 658952;
        cantUrbano = 836600;
        float rural = (cantRural*100/cantTotal);
        float urbano = (cantUrbano*100/cantTotal);
        pieChart2.setHoleRadius(40f);
        pieChart2.setRotationEnabled(true);
        pieChart2.animateXY(1500, 1500);
        ArrayList<Entry> valsY1 = new ArrayList<Entry>();
        valsY1.add(new Entry(rural, 0));
        valsY1.add(new Entry(urbano,1));
        ArrayList<String> valsX1 = new ArrayList<String>();
        valsX1.add("%Rural");
        valsX1.add("%Urbano");
        ArrayList<Integer> colors1 = new ArrayList<Integer>();
        colors1.add(Color.GREEN);
        colors1.add(Color.RED);
        PieDataSet set2 = new PieDataSet(valsY1,"MATRICULA POR ZONA");
        set2.setSliceSpace(0f);
        set2.setColors(colors1);
        PieData dato2 = new PieData(valsX1, set2);
        pieChart2.setData(dato2);
        pieChart2.setDescription(" ");
        pieChart2.invalidate();

        // MATRICULA POR SEXO
        cantMasculino = 765056;
        cantFemenino = 727761;
        cantNoEsp = 735;
        ArrayList<BarEntry> entries2 = new ArrayList<>();
        entries2.add(new BarEntry(cantMasculino, 0));
        entries2.add(new BarEntry(cantFemenino, 1));
        entries2.add(new BarEntry(cantNoEsp,2));
        BarDataSet dataset2 = new BarDataSet(entries2, "MATRICULA POR SEXO");
        ArrayList<String> labels2 = new ArrayList<String>();
        labels2.add("Masculino");
        labels2.add("Femenino");
        labels2.add("No especificó");
        BarData data2 = new BarData(labels2, dataset2);
        dataset2.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart2.setData(data2);
        barChart2.setDescription(" ");
        barChart2.animateY(5000);

        // MATRICULA POR NIVEL EDUCATIVO
        cantInicial = 11912;
        cantParvularia = 228456;
        cantBasica = 1046946;
        cantMedia = 205351;
        cantAdulto = 2887;
        ArrayList<BarEntry> entries3 = new ArrayList<>();
        entries3.add(new BarEntry(cantInicial, 4));
        entries3.add(new BarEntry(cantParvularia, 3));
        entries3.add(new BarEntry(cantBasica, 2));
        entries3.add(new BarEntry(cantMedia, 1));
        entries3.add(new BarEntry(cantAdulto, 0));
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.posicion = position;
        seleccion = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
