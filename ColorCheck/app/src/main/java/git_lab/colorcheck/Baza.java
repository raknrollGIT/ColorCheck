package git_lab.colorcheck;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Baza {
    private static final String DEBUG_TAG = "Baza";
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "database.db";

    private static final String DB_Score_TABLE = "Score";
    public static final String KEY_ID = "_id";
    public static final String ID_OPTIONS = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final int ID_COLUMN = 0;
    public static final String KEY_Player = "Player";
    public static final String Player_OPTIONS = "TEXT NOT NULL";
    public static final int Player_COLUMN = 1;
    public static final String KEY_Score = "Score";
    public static final String Score_OPTIONS = "INTEGER";
    public static final int Score_COLUMN = 2;

    private static final String DB_CREATE_Score_TABLE =
            "CREATE TABLE " + DB_Score_TABLE + "( " +
                    KEY_ID + " " + ID_OPTIONS + ", " +
                    KEY_Player + " " + Player_OPTIONS + ", " +
                    KEY_Score + " " + Score_OPTIONS +
                    ");";
    private static final String DROP_Score_TABLE ="DROP TABLE IF EXISTS " + DB_Score_TABLE;

    private SQLiteDatabase db;
    private Context context;
    private DatabaseHelper dbHelper;

    private class DatabaseHelper extends SQLiteOpenHelper {     // było private static class
        public DatabaseHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE_Score_TABLE);

            Log.d(DEBUG_TAG, "Database creating...");
            Log.d(DEBUG_TAG, "Table " + DB_Score_TABLE + " ver." + DB_VERSION + " created");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_Score_TABLE);

            Log.d(DEBUG_TAG, "Database updating...");
            Log.d(DEBUG_TAG, "Table " + DB_Score_TABLE + " updated from ver." + oldVersion + " to ver." + newVersion);
            Log.d(DEBUG_TAG, "All data is lost.");

            onCreate(db);
        }
    }
    public Baza(Context context) {
        this.context = context;
    }

    public Baza open(){
        dbHelper = new DatabaseHelper(context, DB_NAME, null, DB_VERSION);
        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLException e) {
            db = dbHelper.getReadableDatabase();
        }
        return this;
    }

    public void close() {
        dbHelper.close();
    }
    public long insertBaza(String Player, String Score) {
        ContentValues newBazaValues = new ContentValues();
        newBazaValues.put(KEY_Player, Player);
        newBazaValues.put(KEY_Score, Score);
        return db.insert(DB_Score_TABLE, null, newBazaValues);
    }
    public long insertBazaSS(String Player) {
        ContentValues newPlayerValues = new ContentValues();
        newPlayerValues.put(KEY_Player, Player);
        return db.insert(DB_Score_TABLE, null, newPlayerValues);
    }

    public class BazaTask {
        private long id;
        private String Player;
        private int Score;

        public BazaTask(long id, String Player, int Score) {
            this.id = id;
            this.Player = Player;
            this.Score = Score;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPlayer() {
            return Player;
        }

        public void setPlayer(String Player) {
            this.Player = Player;
        }

        public int getScore() {
            return Score;
        }

        public void setScore(int Score) {
            this.Score =Score;
        }
    }

    public boolean updateTodo(BazaTask task) {
        long id = task.getId();
        String Player = task.getPlayer();
        int Score = task.getScore();
        return updateTodo(id, Player, Score);
    }

    public boolean updateTodo(long id, String Player, int Score) {
        String where = KEY_ID + "=" + id;
        ContentValues updateBazaValues = new ContentValues();
        updateBazaValues.put(KEY_Player, Player);
        updateBazaValues.put(KEY_Score, Score);
        return db.update(DB_Score_TABLE, updateBazaValues, where, null) > 0;
    }
    public boolean deleteScore(long id){
        String where = KEY_ID + "=" + id;
        return db.delete(DB_Score_TABLE, where, null) > 0;
    }

    public Cursor getAllScores() {
        String[] columns = {KEY_ID, KEY_Player, KEY_Score};
        return db.query(DB_Score_TABLE, columns, null, null, null, null, null);
    }

    public BazaTask getScore(long id) {
        String[] columns = {KEY_ID, KEY_Player, KEY_Score};
        String where = KEY_ID + "=" + id;
        Cursor cursor = db.query(DB_Score_TABLE, columns, where, null, null, null, null);
        BazaTask task = null;
        if(cursor != null && cursor.moveToFirst()) {
            String Player = cursor.getString(Player_COLUMN);
            int Score = cursor.getInt(Score_COLUMN);
            task = new BazaTask(id, Player, Score);
        }
        return task;
    }

}
