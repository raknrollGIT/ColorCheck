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
            SQLiteDatabase db = this.getWritableDatabase();
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
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues wartosc = new ContentValues();
            wartosc.put("Player", Player);
            wartosc.put("Score",Score);
            //db.insertOrThrow("Scores",null,wartosc);
            db.insert("Scores",null ,wartosc);
        }

        public Cursor dajWszystkie(){
            SQLiteDatabase db = getReadableDatabase();
            Cursor kursor = db.rawQuery("select * from Scores",null);
            return kursor;
        }

        public Cursor dajOstatni(){
            SQLiteDatabase db = getReadableDatabase();
            Cursor kursor = db.rawQuery("select * from Scores where Id = (select MAX(Id)  from Scores)",null);
            return kursor;
        }

        public Cursor policzWszystkie(){
            SQLiteDatabase db = getReadableDatabase();
            Cursor kursor = db.rawQuery("select Score from Scores",null);
            return kursor;
        }

        public void usunNajslabszy()
        {
            SQLiteDatabase db = getReadableDatabase();
            //db.rawQuery("delete * from Scores where Score = (select MIN(Score) from Scores)",null);
            db.delete("Scores", "Id=?", new String[]{"(select MAX(Id)  from Scores)"});
        }

         public Cursor dajBest(){
            SQLiteDatabase db = getReadableDatabase();
            Cursor kursor = db.rawQuery("select * from Scores order by Score desc limit 10",null);
            return kursor;
        }

         public void DeleteDB(){
            SQLiteDatabase db = getWritableDatabase();
            db.delete("Scores", null, null);
            db.close();
        }
}