package git_lab.colorcheck;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BazaV2 extends SQLiteOpenHelper {

        public BazaV2(Context context){
            super (context,"Scores.db",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(
                    "create table Scores(" +
                    "Id integer primary key autoincrement," +
                    "Player text," +
                    "Score integer);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db , int oldVersion, int newVersion){

        }

        public void dodajScore(String Player, Integer Score){
            SQLiteDatabase db = getWritableDatabase();
            ContentValues wartosc = new ContentValues();
            wartosc.put("Player", Player);
            wartosc.put("Score",Score);
            db.insertOrThrow("Scores",null,wartosc);
        }

        public Cursor dajWszystkie(){
            String[] kolumny={"Id","Plyer","Score"};
            SQLiteDatabase db = getReadableDatabase();
            Cursor kursor = db.query("Scores",kolumny,null,null,null,null,null);
            return kursor;
        }

}