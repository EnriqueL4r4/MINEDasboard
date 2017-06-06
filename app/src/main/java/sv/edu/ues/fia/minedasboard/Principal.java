package sv.edu.ues.fia.minedasboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
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
}
