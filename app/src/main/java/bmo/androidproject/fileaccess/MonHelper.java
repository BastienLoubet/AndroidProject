package bmo.androidproject.fileaccess;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

import bmo.androidproject.resulthandling.Result;

/**
 * Created by Garry on 4/20/2017.
 */

public class MonHelper extends SQLiteOpenHelper {

    private Context oContext;

    public MonHelper(Context context) {
        super(context, "Results", null, 2);
        oContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE result(_id INTEGER PRIMARY KEY, time INTEGER, distance INTEGER, swimstyle INTEGER, date INTEGER, comment TEXT,ranking INTEGER, ligue TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //fill this when upgrading schema
        //this happens when the version number found on the constructor is different from the existing db
        //We then run some ALTER TABLE to update the table.
    }

    //Insert result into the table
    public void insertResult(int time,int distance,int swimstyle,long date,String comment,int ranking,String ligue){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO result(time,distance,swimstyle,date,comment,ranking,ligue) VALUES (?,?,?,?,?,?,?);",
                new Object[] {time,distance,swimstyle,date,comment,ranking,ligue});
    }

    //get the size of the table
    public int getTableSize(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT COUNT (*) FROM result WHERE 1;",new String[] {});
        int nb =0;
        if(c.moveToFirst())
            nb = c.getInt(0);
        c.close();
        return nb;
    }


    //creer l'objet Info a passer a ListResult
    private Info makeFromRow(Cursor c){
        int id = c.getInt(c.getColumnIndexOrThrow("_id"));
        int time = c.getInt(c.getColumnIndexOrThrow("time"));
        int distance = c.getInt(c.getColumnIndexOrThrow("distance"));
        int swimstyle= c.getInt(c.getColumnIndexOrThrow("swimstyle"));
        long date= c.getLong(c.getColumnIndexOrThrow("date"));
        String comment= c.getString(c.getColumnIndexOrThrow("comment"));
        int ranking= c.getInt(c.getColumnIndexOrThrow("ranking"));
        String ligue= c.getString(c.getColumnIndexOrThrow("ligue"));
        return new Info(id,time,distance,swimstyle,date,comment,ranking,ligue);
    }


    //Renvoie l'objet Info correspondant a l'id donne
    public Info getTableRow(int i){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM result WHERE _id=?;",new String[] {Integer.toString(i)});
        if(c.moveToFirst()){
            return makeFromRow(c);
        }
        c.close();
        return null;
    }

    //Retourne les info des iNbr dernier resultat
    public ArrayList<Info> getLastRow(int iNbr){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM result ORDER BY date DESC LIMIT ?;",new String[] {Integer.toString(iNbr)});
        if(c.moveToFirst()){
            return makeTableFromCursor(c);
        }
        c.close();
        return null;
    }

    //Cree un tableau de info a partir d'un curseur
    private ArrayList<Info> makeTableFromCursor(Cursor c){
        ArrayList<Info> aRes = new ArrayList<>();
        do {
            aRes.add(makeFromRow(c));
        }while (c.moveToNext());
        c.close();
        return aRes;
    }

    //retourne tout les champs sous forme d'un arrayl<Info>
    public ArrayList<Info> getAllRow(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM result ORDER BY date DESC;",null);
        if(c.moveToFirst()){
            return makeTableFromCursor(c);
        }
        c.close();
        return null;
    }

    public void ModifyResult(int iId,int iTime,int iDistance,int iSwinStyle, long lDate, String sComment, int iRanking,String sLigue){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE result SET time=? , distance=? , swimstyle=?, date =?, comment=?, ranking=?, ligue=? WHERE _id=?",
                new Object[] {iTime,iDistance,iSwinStyle,lDate,sComment,iRanking,sLigue,iId});
    }
}
