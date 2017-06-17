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
    private String titulo;
    private int cantTotal;
    private float cantPublico, cantPrivado;
    private float cantRural, cantUrbano;
    private int cantMasculino, cantFemenino, cantNoEsp;
    private int cantInicial, cantParvularia, cantBasica, cantMedia, cantAdulto;

    /*
    Instancias para los Views
     */
    Spinner deptosSpinner;
    Spinner muniSpinner;
    TextView lyricList;
    ControlDB helper;
    String idDepto;

    //Adaptadores para los Spinners
   /* SimpleCursorAdapter deptosSpinnerAdapter;
    SimpleCursorAdapter muniSpinnerAdapter;*/

   //DataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matricula_escolar);

      /*  dataSource = new DataSource(this);

        deptosSpinner = (Spinner) findViewById(R.id.sp_departamento);
        muniSpinner = (Spinner) findViewById(R.id.sp_municipio);

        lyricList = (TextView) findViewById(R.id.textView4);

        deptosSpinnerAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_spinner_item,//Layout simple
                dataSource.getAllDepartamentos(),//Todos los registros
                new String[]{DataBaseScript.DeptosColumns.NAME_DEPTOS},//Mostrar solo el nombre
                new int[]{android.R.id.text1},//View para el nombre
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);//Observer para el refresco


        //Seteando Adaptador de GenreSpinner
        deptosSpinner.setAdapter(deptosSpinnerAdapter);

        //Relacionado la escucha de selección de GenreSpinner
        deptosSpinner.setOnItemSelectedListener(this);*/


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


   /*private void activeMunSpinner(String deptoSelection) {


        ArrayList<Municipio> municipios = new ArrayList<Municipio>();
        try {
            helper = new ControlDB(this, null, null, 1);
            SQLiteDatabase db = helper.getWritableDatabase();
            Cursor rd = db.rawQuery("Select * from Municipio where = ", null);
            Municipio muni;
            while(rd.moveToNext()){
                muni = new Municipio();
                muni.setId_depto(rd.getString(0));
                muni.setNombre(rd.getString(1));
                muni.setId_depto(rd.getString(2));
                municipios.add(muni);
            }
        } catch (Exception e){}

        muniSpinner = (Spinner) findViewById(R.id.sp_municipio);
        ArrayAdapter<Municipio> adaptador = new ArrayAdapter<Municipio>(this, android.R.layout.simple_spinner_dropdown_item, municipios);
        muniSpinner.setAdapter(adaptador);

        //deptosSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

  /* @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int idSpinner = parent.getId();

        switch(idSpinner){
            case R.id.sp_departamento:
                Cursor c1 = (Cursor) parent.getItemAtPosition(position);
                String deptosSelection = c1.getString(c1.getColumnIndex(DataBaseScript.DeptosColumns.ID_DEPTOS));

                activeMunSpinner(deptosSelection);
                break;

            case R.id.sp_municipio:

                //Obteniendo el nombre del municipio seleccionado

                Cursor c2 = (Cursor) parent.getItemAtPosition(position);
                String muniSelection = c2.getString(c2.getColumnIndex(DataBaseScript.MuniColumns.NAME_MUNI));


                //Cambiando el texto de LyricList según el Artista seleccionado

                lyricList.setText("Letra de "+" "+muniSelection);

                break;
        }

    }

   private void activeMunSpinner(String deptosSelection) {

        //Creando Adaptador para ArtistSpinner con el id del género

        muniSpinnerAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_spinner_item,
                dataSource.getMuniByDeptos(deptosSelection),
                new String[]{DataBaseScript.MuniColumns.NAME_MUNI},
                new int[]{android.R.id.text1},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);


        //Seteando el adaptador creado

        muniSpinner.setAdapter(muniSpinnerAdapter);

        //Relacionado la escucha

        muniSpinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/
}
