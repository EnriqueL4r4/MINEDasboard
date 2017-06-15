package sv.edu.ues.fia.minedashboard;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Enrique Lara on 15/06/2017.
 */

public class ControlDB extends SQLiteOpenHelper {
    public ControlDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "DBJurisdiccion", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creación de Tablas de Departamento y municipio
        db.execSQL("CREATE TABLE Departamento (id_depto VARCHAR(4) PRIMARY KEY  NOT NULL , nombre TEXT);");
        db.execSQL("CREATE TABLE Municipio (id_mun VARCHAR(4) PRIMARY KEY  NOT NULL , nombre TEXT, id_depto VARCHAR(4) FOREIGN KEY);");

        //Inserción de datos en la tabla Departamento
        db.execSQL("INSERT INTO Departamento VALUES('0000','NACIONAL');");
        db.execSQL("INSERT INTO Departamento VALUES('0001','AHUACHAPAN');");
        db.execSQL("INSERT INTO Departamento VALUES('0002','SANTA ANA');");
        db.execSQL("INSERT INTO Departamento VALUES('0003','SONSONATE');");
        db.execSQL("INSERT INTO Departamento VALUES('0004','CHALATENANGO');");
        db.execSQL("INSERT INTO Departamento VALUES('0005','LA LIBERTAD');");
        db.execSQL("INSERT INTO Departamento VALUES('0006','SAN SALVADOR');");
        db.execSQL("INSERT INTO Departamento VALUES('0007','CUSCATLAN');");
        db.execSQL("INSERT INTO Departamento VALUES('0008','LA PAZ');");
        db.execSQL("INSERT INTO Departamento VALUES('0009','CABAÑAS');");
        db.execSQL("INSERT INTO Departamento VALUES('0010','SAN VICENTE');");
        db.execSQL("INSERT INTO Departamento VALUES('0011','USULUTAN');");
        db.execSQL("INSERT INTO Departamento VALUES('0012','SAN MIGUEL');");
        db.execSQL("INSERT INTO Departamento VALUES('0013','MORAZAN');");
        db.execSQL("INSERT INTO Departamento VALUES('0014','LA UNION');");

        //Inserción de datos en la tabla Municipio
        db.execSQL("INSERT INTO Municipio VALUES('0000','NACIONAL','0000');");
        db.execSQL("INSERT INTO Municipio VALUES('0101','AHUACHAPAN','0001');");
        db.execSQL("INSERT INTO Municipio VALUES('0102','APANECA','0001');");
        db.execSQL("INSERT INTO Municipio VALUES('0103','ATIQUIZAYA','0001');");
        db.execSQL("INSERT INTO Municipio VALUES('0104','CONCEPCION DE ATACO','0001');");
        db.execSQL("INSERT INTO Municipio VALUES('0105','EL REFUGIO','0001');");
        db.execSQL("INSERT INTO Municipio VALUES('0106','GUAYMANGO','0001');");
        db.execSQL("INSERT INTO Municipio VALUES('0107','JUJUTLA','0001');");
        db.execSQL("INSERT INTO Municipio VALUES('0108','SAN FRANCISCO MENENDEZ','0001');");
        db.execSQL("INSERT INTO Municipio VALUES('0109','SAN LORENZO','0001');");
        db.execSQL("INSERT INTO Municipio VALUES('0110','SAN PEDRO PUXTLA','0001');");
        db.execSQL("INSERT INTO Municipio VALUES('0111','TACUBA','0001');");
        db.execSQL("INSERT INTO Municipio VALUES('0112','TURIN','0001');");
        db.execSQL("INSERT INTO Municipio VALUES('0201','CANDELARIA DE LA FRONTERA','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0202','COATEPEQUE','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0203','CHALCHUAPA','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0204','EL CONGO','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0205','EL PORVENIR','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0206','MASAHUAT','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0207','METAPAN','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0208','SAN ANTONIO PAJONAL','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0209','SAN SEBASTIAN SALITRILLO','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0210','SANTA ANA','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0211','SANTA ROSA GUACHIPILIN','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0212','SANTIAGO DE LA FRONTERA','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0213','TEXISTEPEQUE','0002');");
        db.execSQL("INSERT INTO Municipio VALUES('0301','ACAJUTLA','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0302','ARMENIA','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0303','CALUCO','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0304','CUISNAHUAT','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0305','SANTA ISABEL ISHUATAN','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0306','IZALCO','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0307','JUAYUA','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0308','NAHUIZALCO','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0309','NAHUILINGO','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0310','SALCOATITAN','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0311','SAN ANTONIO DEL MONTE','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0312','SAN JULIAN','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0313','SANTA CATARINA MASAHUAT','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0314','SANTO DOMINGO DE GUZMAN','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0315','SONSONATE','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0316','SONZACATE','0003');");
        db.execSQL("INSERT INTO Municipio VALUES('0401','AGUA CALIENTE','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0402','ARCATAO','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0403','AZACUALPA','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0404','CITALA','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0405','COMALAPA','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0406','CONCEPCION QUEZALTEPEQUE','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0407','CHALATENANGO','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0408','DULCE NOMBRE DE MARIA','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0409','EL CARRIZAL','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0410','EL PARAISO','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0411','LA LAGUNA','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0412','LA PALMA','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0413','LA REINA','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0414','LAS VUELTAS','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0415','NOMBRE DE JESUS','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0416','NUEVA CONCEPCION','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0417','NUEVA TRINIDAD','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0418','OJOS DE AGUA','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0419','POTONICO','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0420','SAN ANTONIO DE LA CRUZ','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0421','SAN ANTONIO DE LOS RANCHOS','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0422','SAN FERNANDO','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0423','SAN FRANCISCO LEMPA','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0424','SAN FRANCISCO MORAZAN','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0425','SAN IGNACIO','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0426','SAN ISIDRO LABRADOR','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0427','SAN JOSE CANCASQUE','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0428','SAN JOSE LAS FLORES','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0429','SAN LUIS DEL CARMEN','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0430','SAN MIGUEL DE MERCEDES','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0431','SAN RAFAEL','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0432','SANTA RITA','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0433','TEJUTLA','0004');");
        db.execSQL("INSERT INTO Municipio VALUES('0501','ANTIGUO CUSCATLAN','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0502','CIUDAD ARCE','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0503','COLON','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0504','COMASAGUA','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0505','CHILTIUPAN','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0506','HUIZUCAR','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0507','JAYAQUE','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0508','JICALAPA','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0509','LA LIBERTAD','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0510','NUEVO CUSCATLAN','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0511','SANTA TECLA','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0512','QUEZALTEPEQUE','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0513','SACACOYO','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0514','SAN JOSE VILLANUEVA','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0515','SAN JUAN OPICO','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0516','SAN MATIAS','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0517','SAN PABLO TACACHICO','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0518','TAMANIQUE','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0519','TALNIQUE','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0520','TEOTEPEQUE','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0521','TEPECOYO','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0522','ZARAGOZA','0005');");
        db.execSQL("INSERT INTO Municipio VALUES('0601','AGUILARES','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0602','APOPA','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0603','AYUTUXTEPEQUE','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0604','CUSCATANCINGO','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0605','EL PAISNAL','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0606','GUAZAPA','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0607','ILOPANGO','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0608','MEJICANOS','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0609','NEJAPA','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0610','PANCHIMALCO','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0611','ROSARIO DE MORA','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0612','SAN MARCOS','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0613','SAN MARTIN','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0614','SAN SALVADOR','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0615','SANTIAGO TEXACUANGOS','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0616','SANTO TOMAS','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0617','SOYAPANGO','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0618','TONACATEPEQUE','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0619','CIUDAD DELGADO','0006');");
        db.execSQL("INSERT INTO Municipio VALUES('0701','CANDELARIA','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0702','COJUTEPEQUE','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0703','EL CARMEN','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0704','EL ROSARIO','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0705','MONTE SAN JUAN','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0706','ORATORIO DE CONCEPCION','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0707','SAN BARTOLOME PERULAPIA','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0708','SAN CRISTOBAL','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0709','SAN JOSE GUAYABAL','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0710','SAN PEDRO PERULAPAN','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0711','SAN RAFAEL CEDROS','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0712','SAN RAMON','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0713','SANTA CRUZ ANALQUITO','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0714','SANTA CRUZ MICHAPA','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0715','SUCHITOTO','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0716','TENANCINGO','0007');");
        db.execSQL("INSERT INTO Municipio VALUES('0801','CUYULTITAN','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0802','EL ROSARIO','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0803','JERUSALEN','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0804','MERCEDES LA CEIBA','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0805','OLOCUILTA','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0806','PARAISO DE OSORIO','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0807','SAN ANTONIO MASAHUAT','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0808','SAN EMIGDIO','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0809','SAN FRANCISCO CHINAMECA','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0810','SAN JUAN NONUALCO','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0811','SAN JUAN TALPA','0008')");
        db.execSQL("INSERT INTO Municipio VALUES('0812','SAN JUAN TEPEZONTES','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0813','SAN LUIS TALPA','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0814','SAN MIGUEL TEPEZONTES','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0815','SAN PEDRO MASAHUAT','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0816','SAN PEDRO NONUALCO','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0817','SAN RAFAEL OBRAJUELO','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0818','SANTA MARIA OSTUMA','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0819','SANTIAGO NONUALCO','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0820','TAPALHUACA','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0821','ZACATECOLUCA','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0822','SAN LUIS LA HERRADURA','0008');");
        db.execSQL("INSERT INTO Municipio VALUES('0901','CINQUERA','0009');");
        db.execSQL("INSERT INTO Municipio VALUES('0902','GUACOTECTI','0009');");
        db.execSQL("INSERT INTO Municipio VALUES('0903','ILOBASCO','0009');");
        db.execSQL("INSERT INTO Municipio VALUES('0904','JUTIAPA','0009');");
        db.execSQL("INSERT INTO Municipio VALUES('0905','SAN ISIDRO','0009');");
        db.execSQL("INSERT INTO Municipio VALUES('0906','SENSUNTEPEQUE','0009');");
        db.execSQL("INSERT INTO Municipio VALUES('0907','TEJUTEPEQUE','0009');");
        db.execSQL("INSERT INTO Municipio VALUES('0908','VICTORIA','0009');");
        db.execSQL("INSERT INTO Municipio VALUES('0909','DOLORES','0009');");
        db.execSQL("INSERT INTO Municipio VALUES('1001','APASTEPEQUE','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1002','GUADALUPE','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1003','SAN CAYETANO ISTEPEQUE','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1004','SANTA CLARA','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1005','SANTO DOMINGO','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1006','SAN ESTEBAN CATARINA','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1007','SAN ILDEFONSO','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1008','SAN LORENZO','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1009','SAN SEBASTIAN','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1010','SAN VICENTE','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1011','TECOLUCA','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1012','TEPETITAN','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1013','VERAPAZ','0010');");
        db.execSQL("INSERT INTO Municipio VALUES('1101','ALEGRIA','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1102','BERLIN','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1103','CALIFORNIA','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1104','CONCEPCION BATRES','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1105','CIUDAD EL TRIUNFO','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1106','EREGUAYQUIN','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1107','ESTANZUELAS','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1108','JIQUILISCO','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1109','JUCUAPA','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1110','JUCUARAN','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1111','MERCEDES UMAÑA','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1112','NUEVA GRANADA','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1113','OZATLAN','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1114','PUERTO EL TRIUNFO','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1115','SAN AGUSTIN','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1116','SAN BUENAVENTURA','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1117','SAN DIONISIO','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1118','SANTA ELENA','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1119','SAN FRANCISCO JAVIER','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1120','SANTA MARIA','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1121','SANTIAGO DE MARIA','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1122','TECAPAN','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1123','USULUTAN','0011');");
        db.execSQL("INSERT INTO Municipio VALUES('1201','CAROLINA','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1202','CIUDAD BARRIOS','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1203','COMACARAN','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1204','CHAPELTIQUE','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1205','CHINAMECA','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1206','CHIRILAGUA','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1207','EL TRANSITO','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1208','LOLOTIQUE','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1209','MONCAGUA','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1210','NUEVA GUADALUPE','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1211','NUEVO EDEN DE SAN JUAN','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1212','QUELEPA','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1213','SAN ANTONIO','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1214','SAN GERARDO','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1215','SAN JORGE','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1216','SAN LUIS DE LA REINA','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1217','SAN MIGUEL','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1218','SAN RAFAEL ORIENTE','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1219','SESORI','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1220','ULUAZAPA','0012');");
        db.execSQL("INSERT INTO Municipio VALUES('1301','ARAMBALA','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1302','CACAOPERA','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1303','CORINTO','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1304','CHILANGA','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1305','DELICIAS DE CONCEPCION','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1306','EL DIVISADERO','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1307','EL ROSARIO','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1308','GUALOCOCTI','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1309','GUATAJIAGUA','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1310','JOATECA','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1311','JOCOAITIQUE','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1312','JOCORO','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1313','LOLOTIQUILLO','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1314','MEANGUERA','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1315','OSICALA','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1316','PERQUIN','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1317','SAN CARLOS','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1318','SAN FERNANDO','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1319','SAN FRANCISCO GOTERA','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1320','SAN ISIDRO','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1321','SAN SIMON','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1322','SENSEMBRA','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1323','SOCIEDAD','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1324','TOROLA','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1325','YAMABAL','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1326','YOLOAIQUIN','0013');");
        db.execSQL("INSERT INTO Municipio VALUES('1401','ANAMOROS','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1402','BOLIVAR','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1403','CONCEPCION DE ORIENTE','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1404','CONCHAGUA','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1405','EL CARMEN','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1406','EL SAUCE','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1407','INTIPUCA','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1408','LA UNION','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1409','LISLIQUE','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1410','MEANGUERA DEL GOLFO','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1411','NUEVA ESPARTA','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1412','PASAQUINA','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1413','POLOROS','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1414','SAN ALEJO','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1415','SAN JOSE','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1416','SANTA ROSA DE LIMA','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1417','YAYANTIQUE','0014');");
        db.execSQL("INSERT INTO Municipio VALUES('1418','YUCUAIQUIN','0014');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public Cursor getAllDepartamento() {
        SQLiteDatabase bd = getReadableDatabase();

        return bd.rawQuery("Select * from Departamento:", null);
    }

    public Cursor getMunByDepto(String deptoSelection) {
        SQLiteDatabase bd = getWritableDatabase();

        //Argumentos del WHERE
        String selectionArgs[] = new String[]{deptoSelection};

        String query = "select id_mun, nombre from Municpio where id_depto = ?";
        return bd.rawQuery(query,selectionArgs);
    }
}
