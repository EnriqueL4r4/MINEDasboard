package sv.edu.ues.fia.minedashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toast.makeText(this, "¡Bienvenido/a!",Toast.LENGTH_LONG).show();
    }

    //ImageButton para Centros Educativos
    public void centroEducativo(View view){
        Intent ce = new Intent(this, CentroEducativo.class);
        startActivity(ce);
    }

    //ImageButton para Matricula Escolar
    public void matriculaEscolar(View view){
        Intent mat = new Intent(this, MatriculaEscolar.class);
        startActivity(mat);
    }

    //ImageButton para estudiantes repetidores
    public void repitencia(View view){
        Intent rep = new Intent(this, Repitencia.class);
        startActivity(rep);
    }

    //ImageButton para estudiantes con sobreedad
    public void sobreedad(View view){
        Intent sob = new Intent(this, Sobreedad.class);
        startActivity(sob);
    }

    public void about_us(View view){
        Toast.makeText(this, "App MINEDashboard® 2017 Ministerio de Educación es una aplicación desarrollada por:", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Cristian Aguilar, Wendy Gómez, Enrique Lara, Sofía Martínez y Walter Velis." , Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Estudiantes de Ingeniería de Sistemas Informáticos, FIA, UES", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Cátedra de Programación para Dispositivos Móviles, Docente: Ing. William Vides ", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Coordinado por el Ing. Edwin Ramírez, Coordinador de Servicios de Información y Divulgación, MINED", Toast.LENGTH_LONG).show();

    }

}
