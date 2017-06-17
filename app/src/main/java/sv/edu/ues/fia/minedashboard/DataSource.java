package sv.edu.ues.fia.minedashboard;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Enrique Lara on 16/06/2017.
 */

public class DataSource {

    private ControlDB openHelper;
    private SQLiteDatabase database;

   /* public DataSource(Context context) {
        openHelper = new ControlDB(context);
        database = openHelper.getWritableDatabase();
    }*/

    public Cursor getAllDepartamentos(){
        return database.rawQuery("select * from" +DataBaseScript.DEPTOS_TABLE_NAME, null);
    }

    public Cursor getMuniByDeptos(String deptosSelection){
        String selectionArgs[] = new String[]{deptosSelection};

        String query =
                "select "+DataBaseScript.MuniColumns.ID_MUNI+","+DataBaseScript.MuniColumns.NAME_MUNI+
                        " from "+DataBaseScript.MUNI_TABLE_NAME +
                        " where "+DataBaseScript.MuniColumns.ID_DEPTOS +
                        "= ?";
        return database.rawQuery(query,selectionArgs);
    }
}
