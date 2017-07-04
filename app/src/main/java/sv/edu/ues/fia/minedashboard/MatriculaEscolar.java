package sv.edu.ues.fia.minedashboard;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    String titulo;
    int cantTotal;
    float cantPublico, cantPrivado;
    float cantRural, cantUrbano;
    int cantMasculino, cantFemenino, cantNoEsp;
    int cantInicial, cantParvularia, cantBasica, cantMedia, cantAdulto;

    Spinner deptosSpinner;
    Spinner muniSpinner;
    ControlDB helper;
    String idDepto;
    BarChart barChart;
    PieChart pieChart;
    PieChart pieChart2;
    BarChart barChart2;
    HorizontalBarChart barChart3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matricula_escolar);

        //Población del Spinner de Departamentos
        ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
        try {
            helper = new ControlDB(this, null, null, 1);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor rd = db.rawQuery("Select * from Departamento", null);
            Departamento depto;
            while(rd.moveToNext()){
                depto = new Departamento();
                depto.setId_depto(rd.getString(0));
                depto.setNombre(rd.getString(1));
                departamentos.add(depto);
            }
        } catch (Exception e){}

        deptosSpinner = (Spinner) findViewById(R.id.sp_departamento);
        ArrayAdapter<Departamento> adaptador = new ArrayAdapter<Departamento>(this, android.R.layout.simple_spinner_dropdown_item, departamentos);
        deptosSpinner.setAdapter(adaptador);
        deptosSpinner.setOnItemSelectedListener(this);


        barChart = (BarChart) findViewById(R.id.barChart);
        pieChart = (PieChart) findViewById(R.id.pieChart);
        pieChart2 = (PieChart) findViewById(R.id.pieChart2);
        barChart2 = (BarChart) findViewById(R.id.barChart2);
        barChart3 = (HorizontalBarChart) findViewById(R.id.barChart3);

        // MATRICULA TOTAL
        int cantTotal = 1495552;
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
        float cantPrivado = 234495;
        float cantPublico = 1261057;
        float privado = (cantPrivado*100/cantTotal);
        float publico = (cantPublico*100/cantTotal);

        pieChart.setHoleRadius(40f);
        pieChart.setRotationEnabled(true);
        pieChart.animateXY(1500, 1500);
        ArrayList<Entry> valsY = new ArrayList<Entry>();
        valsY.add(new Entry(privado,0));
        valsY.add(new Entry(publico,1));
        ArrayList<String> valsX = new ArrayList<String>();
        valsX.add("% Privados");
        valsX.add("% Públicos");
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
        int cantRural = 658952;
        int cantUrbano = 836600;
        float rural = (cantRural*100/cantTotal);
        float urbano = (cantUrbano*100/cantTotal);
        pieChart2.setHoleRadius(40f);
        pieChart2.setRotationEnabled(true);
        pieChart2.animateXY(1500, 1500);
        ArrayList<Entry> valsY1 = new ArrayList<Entry>();
        valsY1.add(new Entry(rural, 0));
        valsY1.add(new Entry(urbano,1));
        ArrayList<String> valsX1 = new ArrayList<String>();
        valsX1.add("% Rural");
        valsX1.add("% Urbano");
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
        int cantMasculino = 765056;
        int cantFemenino = 727761;
        int cantNoEsp = 735;
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
        int cantInicial = 11912;
        int cantParvularia = 228456;
        int cantBasica = 1046946;
        int cantMedia = 205351;
        int cantAdulto = 2887;
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

        String selected = parent.getItemAtPosition(position).toString();

        if(selected.equals("Ahuachapán")){
            idDepto = "0001";
        }else{
            if(selected.equals("Santa Ana")){
                idDepto = "0002";
            }else {
                if(selected.equals("Sonsonate")){
                    idDepto = "0003";
                }else{
                    if (selected.equals("Chalatenango")){
                        idDepto = "0004";
                    }else{
                        if(selected.equals("La Libertad")){
                            idDepto = "0005";
                        }else{
                            if (selected.equals("San Salvador")){
                                idDepto = "0006";
                            }else{
                                if (selected.equals("Cuscatlán")){
                                    idDepto = "0007";
                                }else{
                                    if (selected.equals("La Paz")){
                                        idDepto = "0008";
                                    }else{
                                        if (selected.equals("Cabañas")){
                                            idDepto = "0009";
                                        }else{
                                            if (selected.equals("San Vicente")){
                                                idDepto = "0010";
                                            }else{
                                                if (selected.equals("Usulután")){
                                                    idDepto = "0011";
                                                }else{
                                                    if (selected.equals("San Miguel")){
                                                        idDepto = "0012";
                                                    }else{
                                                        if (selected.equals("Morazán")){
                                                            idDepto = "0013";
                                                        }else {
                                                            if (selected.equals("La Unión")){
                                                                idDepto = "0014";
                                                            }else{
                                                                idDepto = "0000";
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        //Población del Spinner de Municipios
        ArrayList<Municipio> municpios = new ArrayList<Municipio>();
        try {
            helper = new ControlDB(this, null, null, 1);
            SQLiteDatabase db = helper.getReadableDatabase();
            Cursor rd = db.rawQuery("Select * from Municipio where id_depto='" + idDepto +"'", null);
            Municipio muni;
            while(rd.moveToNext()){
                muni = new Municipio();
                muni.setId_mun(rd.getString(0));
                muni.setNombre(rd.getString(1));
                muni.setId_depto(rd.getString(2));
                municpios.add(muni);
            }
        } catch (Exception e){}

        muniSpinner = (Spinner) findViewById(R.id.sp_municipio);
        ArrayAdapter<Municipio> adaptador = new ArrayAdapter<Municipio>(this, android.R.layout.simple_spinner_dropdown_item, municpios);
        muniSpinner.setAdapter(adaptador);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void consultar(View view){
        String depa = deptosSpinner.getSelectedItem().toString();
        String muni = muniSpinner.getSelectedItem().toString();
        String id_depto = null, id_muni = null;

        //Consulta del id_depto;
        helper = new ControlDB(this, null, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor rd = db.rawQuery("select id_depto from Departamento where nombre ='"+depa+"'", null);
        if(rd != null){
            try{
                if(rd.moveToFirst()){
                    id_depto = rd.getString(0);
                }
            }catch (Exception e){}
        }

        //Consulta los datos del indicador Matricula
        if(muni.equals(" ")){
        helper = new ControlDB(this, null, null, 1);
        SQLiteDatabase db3 = helper.getWritableDatabase();
        Cursor rd3 = db3.rawQuery("select * from Matricula where codJurisdiccion='"+id_depto+"'", null);
            if(rd != null){
                try{
                    if(rd3.moveToFirst()){
                        cantPublico = rd3.getInt(2);
                        cantPrivado =  rd3.getInt(3);
                        cantRural = rd3.getInt(4);
                        cantUrbano = rd3.getInt(5);
                        cantMasculino =  rd3.getInt(6);
                        cantFemenino = rd3.getInt(7);
                        cantNoEsp = rd3.getInt(8);
                        cantInicial =  rd3.getInt(9);
                        cantParvularia = rd3.getInt(10);
                        cantBasica = rd3.getInt(11);
                        cantMedia =  rd3.getInt(12);
                        cantAdulto = rd3.getInt(13);
                        cantTotal = rd3.getInt(14);
                    }
                }catch (Exception e){}
            }

        }else{
            //Consulta del id_mun
            helper = new ControlDB(this, null, null, 1);
            SQLiteDatabase db2 = helper.getWritableDatabase();
            Cursor rd2 = db2.rawQuery("select id_mun from Municipio where nombre ='"+muni+"'", null);
            if(rd != null){
                try{
                    if(rd2.moveToFirst()){
                        id_muni = rd2.getString(0);
                    }
                }catch (Exception e){}
            }

            helper = new ControlDB(this, null, null, 1);
            SQLiteDatabase db4 = helper.getWritableDatabase();
            Cursor rd4 = db4.rawQuery("select * from Matricula where codJurisdiccion='"+id_muni+"'", null);
            if(rd != null){
                try{
                    if(rd4.moveToFirst()){
                        cantPublico = rd4.getInt(2);
                        cantPrivado =  rd4.getInt(3);
                        cantRural = rd4.getInt(4);
                        cantUrbano = rd4.getInt(5);
                        cantMasculino =  rd4.getInt(6);
                        cantFemenino = rd4.getInt(7);
                        cantNoEsp = rd4.getInt(8);
                        cantInicial =  rd4.getInt(9);
                        cantParvularia = rd4.getInt(10);
                        cantBasica = rd4.getInt(11);
                        cantMedia =  rd4.getInt(12);
                        cantAdulto = rd4.getInt(13);
                        cantTotal = rd4.getInt(14);
                    }
                }catch (Exception e){}
            }
        }

       Graficar(depa, muni,cantTotal,cantPublico,cantPrivado,cantRural,cantUrbano,cantMasculino,cantFemenino,cantNoEsp,cantInicial,cantParvularia,cantBasica,cantMedia,cantAdulto);
    }

    public void Graficar(String depto, String mun, int cantTotal,float cantPublico, float cantPrivado, float cantRural,float cantUrbano,  int cantMasculino, int cantFemenino, int cantNoEsp, int cantInicial, int cantParvularia, int cantBasica, int cantMedia, int cantAdulto){
        // MATRICULA TOTAL
        titulo = depto+", "+mun;
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
        float privado = (cantPrivado*100/cantTotal);
        float publico = (cantPublico*100/cantTotal);

        pieChart.setHoleRadius(40f);
        pieChart.setRotationEnabled(true);
        pieChart.animateXY(1500, 1500);
        ArrayList<Entry> valsY = new ArrayList<Entry>();
        valsY.add(new Entry(privado,0));
        valsY.add(new Entry(publico,1));
        ArrayList<String> valsX = new ArrayList<String>();
        valsX.add("% Privados");
        valsX.add("% Públicos");
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        PieDataSet set1 = new PieDataSet(valsY, "MATRICULA POR SECTOR");
        set1.setSliceSpace(0f);
        set1.setColors(colors);
        PieData dato1 = new PieData(valsX, set1);
        pieChart.setData(dato1);
        pieChart.setDescription("Cantidad de estudiantes, \nSector Privado: "+cantPrivado+ "\nSector Público: "+cantPublico);
        pieChart.invalidate();

        //MATRICULA POR ZONA
        float rural = (cantRural*100/cantTotal);
        float urbano = (cantUrbano*100/cantTotal);
        pieChart2.setHoleRadius(40f);
        pieChart2.setRotationEnabled(true);
        pieChart2.animateXY(1500, 1500);
        ArrayList<Entry> valsY1 = new ArrayList<Entry>();
        valsY1.add(new Entry(rural, 0));
        valsY1.add(new Entry(urbano,1));
        ArrayList<String> valsX1 = new ArrayList<String>();
        valsX1.add("% Rural");
        valsX1.add("% Urbano");
        ArrayList<Integer> colors1 = new ArrayList<Integer>();
        colors1.add(Color.GREEN);
        colors1.add(Color.RED);
        PieDataSet set2 = new PieDataSet(valsY1,"MATRICULA POR ZONA");
        set2.setSliceSpace(0f);
        set2.setColors(colors1);
        PieData dato2 = new PieData(valsX1, set2);
        pieChart2.setData(dato2);
        pieChart2.setDescription("Cantidad de estudiantes, Zona Rural: "+cantRural+"; Zona Urbana: "+cantUrbano);
        pieChart2.invalidate();

        // MATRICULA POR SEXO
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

}
