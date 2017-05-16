package git_lab.colorcheck;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ranking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        TextView zaw = (TextView) findViewById(R.id.textWyniki);

        BazaV2 db = new BazaV2(this);
        //db.DeleteDB();
        //Cursor kk = db.dajWszystkie();
        Cursor kk = db.dajBest();

        while (kk.moveToNext()){
            int id=kk.getInt(0);
            String Player=kk.getString(1);
            int Score=kk.getInt(2);
            zaw.setText(zaw.getText()+"\n Nick: "+Player+"   Score: "+Score);
        }
    }

    public void openmenu(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void onBackPressed() {

        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);

    }
}