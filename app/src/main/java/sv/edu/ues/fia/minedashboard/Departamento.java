package sv.edu.ues.fia.minedashboard;

/**
 * Created by Enrique Lara on 15/06/2017.
 */

public class Departamento {
    private String id_depto, nombre;

    public String getId_depto() {
        return id_depto;
    }

    public void setId_depto(String id_depto) {
        this.id_depto = id_depto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString(){
        return nombre;
    }
}
