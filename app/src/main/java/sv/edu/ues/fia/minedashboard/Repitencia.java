package sv.edu.ues.fia.minedashboard;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

public class Repitencia extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner deptosSpinner;
    Spinner muniSpinner;
    ControlDB helper;
    String idDepto;

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(sv.edu.ues.fia.minedashboard.R.layout.activity_repitencia);

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

        pieChart = (PieChart) findViewById(R.id.pieChart);

        float porcentRep = (float) 4.67;
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
        String idDepto, idMuni;
//consulta del id_depto;
        helper = new ControlDB(this, null, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor rd = db.rawQuery("select id_depto from Departamento where nombre ='"+depa+"'", null);
        if(rd != null){
            try{
                if(rd.moveToFirst()){
                    idDepto=rd.getString(0);
                }
            }catch (Exception e){}
        }
//consulta del id_mun
        helper = new ControlDB(this, null, null, 1);
        SQLiteDatabase db2 = helper.getWritableDatabase();
        Cursor rd2 = db2.rawQuery("select id_depto from Municipio where nombre ='"+muni+"'", null);
        if(rd != null){
            try{
                if(rd2.moveToFirst()){
                    idMuni=rd.getString(0);
                }
            }catch (Exception e){}
        }

        float porcentRep = (float) 4.67;
        float cantPublico=5136, cantPrivado=897;
        float cantRural=3961, cantUrbano=2072;

        Graficar(depa, muni,porcentRep);
    }

    public void Graficar(String depto, String mun, float porcentRep){
        //porcentRep = (float) 4.67;
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
