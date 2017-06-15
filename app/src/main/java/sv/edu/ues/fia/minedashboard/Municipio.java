package sv.edu.ues.fia.minedashboard;

/**
 * Created by Enrique Lara on 15/06/2017.
 */

public class Municipio {
    private String id_mun, nombre, id_depto;
    public String getId_mun() {
        return id_mun;
    }

    public void setId_mun(String id_mun) {
        this.id_mun = id_mun;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId_depto() {
        return id_depto;
    }

    public void setId_depto(String id_depto) {
        this.id_depto = id_depto;
    }

    public String toString(){
        return nombre;
    }

}
