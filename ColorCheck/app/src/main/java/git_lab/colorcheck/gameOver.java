package git_lab.colorcheck;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class gameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        //TextView WW = (TextView) findViewById(R.id.wWynik);
        //String lw = String.valueOf(Global.Score);
        //lw="Your score: " +lw;
        //WW.setText(lw);
        TextView zaw = (TextView) findViewById(R.id.wWynik);

        BazaV2 db = new BazaV2(this);
        db.dodajScore(Global.Nick,Global.Score);
        Cursor kk = db.dajOstatni();

        while (kk.moveToNext()){
            int id=kk.getInt(0);
            String Player=kk.getString(1);
            int Score=kk.getInt(2);
            zaw.setText(zaw.getText()+" "+Score);
        }

        kk=db.policzWszystkie();

        if(kk.getCount()>10)
        {
           db.usunNajslabszy();
        }
    }

    public void openmenu(View view){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
    public void openRanking(View view){
        Intent intent = new Intent(this, Ranking.class);
        startActivity(intent);
    }
    public void openGame(View view){
        Intent intent = new Intent(this, Trudnosc.class);
        startActivity(intent);
    }


    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        if (exit) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }
}
