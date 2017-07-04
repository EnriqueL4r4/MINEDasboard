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

public class CentroEducativo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private String titulo;
    private int cantTotal;
    private float cantPublico, cantPrivado;
    private float cantRural, cantUrbano;
    Spinner deptosSpinner;
    Spinner muniSpinner;
    ControlDB helper;
    String idDepto;

    BarChart barChart;
    PieChart pieChart;
    PieChart pieChart2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(sv.edu.ues.fia.minedashboard.R.layout.activity_centro_educativo);

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
        valsX.add("% Privados");
        valsX.add("% Públicos");
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


        ArrayList<Municipio> municipios = new ArrayList<Municipio>();
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
                municipios.add(muni);
            }
        } catch (Exception e){}

        muniSpinner = (Spinner) findViewById(R.id.sp_municipio);
        ArrayAdapter<Municipio> adaptador = new ArrayAdapter<Municipio>(this, android.R.layout.simple_spinner_dropdown_item, municipios);
        muniSpinner.setAdapter(adaptador);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    //Botón Consultar
    public void consultar(View view){
        String depa = deptosSpinner.getSelectedItem().toString();
        String muni = muniSpinner.getSelectedItem().toString();
        String id_depto = null, id_muni = null;
//consulta del id_depto;
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
///Consulta los datos del indicador
        if(muni.equals(" ")){
            helper = new ControlDB(this, null, null, 1);
            SQLiteDatabase db3 = helper.getWritableDatabase();
            Cursor rd3 = db3.rawQuery("select * from CentrosEducativos where codJurisdiccion='"+id_depto+"'", null);
            if(rd != null){
                try{
                    if(rd3.moveToFirst()){
                        cantPublico = rd3.getInt(2);
                        cantPrivado =  rd3.getInt(3);
                        cantRural = rd3.getInt(4);
                        cantUrbano = rd3.getInt(5);
                        cantTotal = rd3.getInt(6);
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
            Cursor rd4 = db4.rawQuery("select * from CentrosEducativos where codJurisdiccion='"+id_muni+"'", null);
            if(rd != null){
                try{
                    if(rd4.moveToFirst()){
                        cantPublico = rd4.getInt(2);
                        cantPrivado =  rd4.getInt(3);
                        cantRural = rd4.getInt(4);
                        cantUrbano = rd4.getInt(5);
                        cantTotal = rd4.getInt(6);
                    }
                }catch (Exception e){}
            }
        }

        Graficar(depa, muni,cantTotal,cantPublico,cantPrivado,cantRural,cantUrbano);
    }

    public void Graficar(String depto, String mun, int cantTotal,float cantPublico, float cantPrivado, float cantRural, float cantUrbano){
        // CENTROS EDUCATIVOS TOTAL
        titulo = depto+", "+mun;
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
        pieChart.setDescription("Cantidad de Centros Educativos, Sector Privado: "+cantPrivado+"; Sector Público: "+cantPublico);
        pieChart.invalidate();

        //C.E. POR ZONA
        float rural = (cantRural*100/cantTotal);
        float urbano = (cantUrbano*100/cantTotal);
        pieChart2.setHoleRadius(40f);
        pieChart2.setRotationEnabled(true);
        pieChart2.animateXY(1500, 1500);
        ArrayList<Entry> valsY1 = new ArrayList<Entry>();
        valsY1.add(new Entry(rural, 0));
        valsY1.add(new Entry(urbano, 1));
        ArrayList<String> valsX1 = new ArrayList<String>();
        valsX1.add("% Rural");
        valsX1.add("% Urbano");
        ArrayList<Integer> colors1 = new ArrayList<Integer>();
        colors1.add(Color.GREEN);
        colors1.add(Color.BLUE);
        PieDataSet set2 = new PieDataSet(valsY1,"C.E. POR ZONA");
        set2.setSliceSpace(0f);
        set2.setColors(colors1);
        PieData dato2 = new PieData(valsX1, set2);
        pieChart2.setData(dato2);
        pieChart2.setDescription("Cantidad de Centros Educativos, Zona Rural: "+cantRural+"; Zona Urbana: "+cantUrbano);
        pieChart2.invalidate();
    }
}
