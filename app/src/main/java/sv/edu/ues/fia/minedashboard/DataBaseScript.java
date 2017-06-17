package sv.edu.ues.fia.minedashboard;

import android.provider.BaseColumns;

/**
 * Created by Enrique Lara on 16/06/2017.
 */

public class DataBaseScript {
    //Metainformación de la base de datos
    public static final String DATABASE_NAME = "Minedashboard.db";
    public static final int DATABASE_VERSION = 1;
    public static final String STRING_TYPE = "text";
    public static final String VAR_TYPE = "text";

   // Nombres de las tablas
    public static final String DEPTOS_TABLE_NAME = "Departamentos";
    public static final String MUNI_TABLE_NAME = "Municipios";


    //Nombres de los campos de las tablas

    public static class DeptosColumns {
        public static final String ID_DEPTOS = BaseColumns._ID;
        public static final String NAME_DEPTOS = "nombre";
    }

    public static class MuniColumns {
        public static final String ID_MUNI = BaseColumns._ID;
        public static final String NAME_MUNI = "nombre";
        public static final String ID_DEPTOS = "id_depto";
    }

    //Sentencia SQL para la creación de las tablas
    public static final String CREATE_DEPTOS_SCRIPT =
            "create table " +DEPTOS_TABLE_NAME + "(" +
                    DeptosColumns.ID_DEPTOS + " " + VAR_TYPE + " primary key," +
                    DeptosColumns.NAME_DEPTOS + " " + STRING_TYPE + " not null)";

    public static final String CREATE_MUNI_SCRIPT =
            "create table " + MUNI_TABLE_NAME + "(" +
                    MuniColumns.ID_MUNI + " " + VAR_TYPE + " primary key," +
                    MuniColumns.NAME_MUNI + " " + STRING_TYPE + " not null, " +
                    MuniColumns.ID_DEPTOS + " " + VAR_TYPE + " not null"+
                    "foreign key(" + MuniColumns.ID_DEPTOS + ") " +
                    "references " + DEPTOS_TABLE_NAME + "(" + DeptosColumns.ID_DEPTOS + "))";

    /*
   Valores para la inserción de los Departamento
    */
    public static final String[] deptosNameValues = new String[]{"San Salvador", "Chalatenango", "Cabañas", "La Paz" };
    public static final String[] deptosKeyValues = new String[]{ "0006", "0004", "0009", "0008" };

    /*
    Sentencia SQL para la inserción de Departamentos
     */
    public static final String INSERT_DEPTOS_SCRIPT =
            "insert into "+ DEPTOS_TABLE_NAME +" values " +
                    "("+ deptosKeyValues[0]+",\""+ deptosNameValues[0]+"\")," +
                    "("+ deptosKeyValues[1]+",\""+ deptosNameValues[1]+"\")," +
                    "("+ deptosKeyValues[2]+",\""+ deptosNameValues[2]+"\")," +
                    "("+ deptosKeyValues[3]+",\""+ deptosNameValues[3]+"\")";

    /*
    Valores par la inserción de los Municipios
     */
    public static final String[] ssMuni = new String[]{"Apopa", "Soyapango", "San Marcos", "Cuscatancingo"};

    public static final String[] chalateMuni = new String[]{"La Palma", "San Ignacio", "Citala", "San Fernando"};

    public static final String[] cabañasMuni = new String[]{"Sensuntepeque", "Cinquera", "Ilobasco", "San Isidro"};

    public static final String[] laPazMuni = new String[]{"Olocuilta", "Cuyultitan", "San Juan Nonualco", "Zacatecoluca"};

    /*
    Sentencia SQL para la inserción de Municipios
     */
    public static final String INSERT_MUNI_SCRIPT =
            "insert into "+ MUNI_TABLE_NAME +" values " +
                    "(null,\""+ ssMuni[0]+"\","+ deptosKeyValues[0]+"),"+
                    "(null,\""+ ssMuni[1]+"\","+ deptosKeyValues[0]+"),"+
                    "(null,\""+ ssMuni[2]+"\","+ deptosKeyValues[0]+"),"+
                    "(null,\""+ ssMuni[3]+"\","+ deptosKeyValues[0]+"),"+
                    "(null,\""+ chalateMuni[0]+"\","+ deptosKeyValues[1]+"),"+
                    "(null,\""+ chalateMuni[1]+"\","+ deptosKeyValues[1]+"),"+
                    "(null,\""+ chalateMuni[2]+"\","+ deptosKeyValues[1]+"),"+
                    "(null,\""+ chalateMuni[3]+"\","+ deptosKeyValues[1]+"),"+
                    "(null,\""+ cabañasMuni[0]+"\","+ deptosKeyValues[2]+"),"+
                    "(null,\""+ cabañasMuni[1]+"\","+ deptosKeyValues[2]+"),"+
                    "(null,\""+ cabañasMuni[2]+"\","+ deptosKeyValues[2]+"),"+
                    "(null,\""+ cabañasMuni[3]+"\","+ deptosKeyValues[2]+"),"+
                    "(null,\""+ laPazMuni[0]+"\","+ deptosKeyValues[3]+"),"+
                    "(null,\""+ laPazMuni[1]+"\","+ deptosKeyValues[3]+"),"+
                    "(null,\""+ laPazMuni[2]+"\","+ deptosKeyValues[3]+"),"+
                    "(null,\""+ laPazMuni[3]+"\","+ deptosKeyValues[3]+")";


}
